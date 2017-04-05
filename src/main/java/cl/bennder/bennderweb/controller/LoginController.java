/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.controller;

import cl.bennder.bennderweb.body.response.LoginBodyResponse;
import cl.bennder.bennderweb.constantes.GoToUrl;
import cl.bennder.bennderweb.model.LoginForm;
import cl.bennder.bennderweb.model.UsuarioSession;
import cl.bennder.bennderweb.services.CuponBeneficioServices;
import cl.bennder.bennderweb.services.UsuarioServices;
import cl.bennder.entitybennderwebrest.request.GeneraCuponQrRequest;
import cl.bennder.entitybennderwebrest.request.LoginRequest;
import cl.bennder.entitybennderwebrest.request.RecuperacionPasswordRequest;
import cl.bennder.entitybennderwebrest.response.GeneraCuponQrResponse;
import cl.bennder.entitybennderwebrest.response.LoginResponse;
import cl.bennder.entitybennderwebrest.response.ValidacionResponse;
import com.google.gson.Gson;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author dyanez 28-12-2016
 */
@Controller
public class LoginController {
    
    @Autowired
    private UsuarioSession usuarioSession;
    
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    
    @Autowired
    private UsuarioServices usuarioServices;
    
    @Autowired
    private CuponBeneficioServices cuponBeneficioServices;
        
    //.- Index
    @RequestMapping(value = "/index.html", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public ModelAndView index() {
        log.info("INICIO");
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("loginForm", new LoginForm());
        log.info("FIN");
        return modelAndView;
    }
    //.- login!!!    
    /*@RequestMapping(value = "/login.html", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public ModelAndView login(@ModelAttribute("loginForm") LoginForm loginForm) {
        log.info("INICIO");
        log.info("datos ->{}",loginForm.toString());
        LoginResponse response = usuarioServices.validacionUsuario(new LoginRequest(loginForm.getUser(), loginForm.getPassword()));
        log.info("response ->{}",response.toString());
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("msg", response.getValidacion().getMensaje());
        log.info("FIN");
        return modelAndView;
    }*/
    @RequestMapping(value="login.html", method=RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String login(@ModelAttribute("loginForm") LoginForm loginForm, HttpSession session){
        log.info("INICIO");
        log.info("datos ->{}",loginForm.toString());
        LoginResponse response = usuarioServices.validacionUsuario(new LoginRequest(loginForm.getUser(), loginForm.getPassword()));
        LoginBodyResponse rBody = new LoginBodyResponse();
        rBody.setValidacion(response.getValidacion());
        if(response.getValidacion()!=null && response.getValidacion().getCodigo()!=null && "0".equals(response.getValidacion().getCodigo())){
            String mensajeLog = "[IdUsuario -> "+response.getIdUsuario()+"]";
            usuarioSession.setIdUsuario(response.getIdUsuario());//rut de cliente sin dv
            session.setAttribute("user", loginForm.getUser());
            if(usuarioSession!=null && usuarioSession.getCodigoCuponEncriptado()!=null){
                log.info("{} Usuario ha pinchado en link de correo enviado con información de cupón, por tanto ahora validando",mensajeLog);
                //.- se consume servicio de generacion de cupon QR
                //.- si es ok, se redire a url para descagar pdf en brower
                //.- sino, se envia mensaje a url validacion cupon
//                GeneraCuponQrResponse gResponse = cuponBeneficioServices.generaCuponQR(new GeneraCuponQrRequest(usuarioSession.getCodigoCuponEncriptado(), usuarioSession.getIdUsuario()));
//                if(gResponse!=null && gResponse.getValidacion()!=null){
//                    if("0".equals(gResponse.getValidacion().getCodigo()) && "0".equals(gResponse.getValidacion().getCodigoNegocio()) 
//                       && gResponse.getCuponPdf()!=null){
//                        log.info("{} Ahora redireccionado par generar cuppon en browser",mensajeLog);
//                        session.setAttribute("cuponPdf", gResponse.getCuponPdf());
//                        rBody.setGoToUrl(GoToUrl.URL_DOWNLOAD_CUPON_PDF);
//                    }
//                    else{
//                        log.info("{} Respuesta de generación cupon ->{}",mensajeLog,gResponse.getValidacion().getMensaje());
//                        usuarioSession.getValidacion().setMensaje(gResponse.getValidacion().getMensaje());
//                        rBody.setGoToUrl(GoToUrl.URL_VALIDACION_CUPON); 
//                    }
//                }
//                else{
//                    log.info("{} Problemas al generar código QR de beneficio",mensajeLog);
//                    usuarioSession.getValidacion().setMensaje("Problemas al generar código QR de beneficio");
//                    rBody.setGoToUrl(GoToUrl.URL_VALIDACION_CUPON);
//                }
//                usuarioSession.setCodigoCuponEncriptado(null);

                  rBody.setGoToUrl(cuponBeneficioServices.validaLinkExternoCupon(session));
            }
            else{
                if(response.getIdEstadoUsuario() == 1){
                    rBody.setGoToUrl(GoToUrl.URL_BIENVENIDO);
                }
                else{
                    rBody.setGoToUrl(GoToUrl.URL_HOME);
                }
            }
            log.info("Se guarda usuario en sessión ->{}",loginForm.getUser());
        }
        String respJson =  new Gson().toJson(rBody);
        log.info("FIN");
        return respJson;
    }
    @RequestMapping(value="logout.html", method=RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String logout(HttpSession session){
        if(session != null){
            log.info("limpiando datos de sessión...");
            session.invalidate();
        }
        return "redirect:/index.html";
    }
    
    /***
     * Permite solicitar/recuperar la contraseña la cual es enviada al correo ingresado
     * @param usuario usuario bennder, usualmente email
     * @return 
     */
    @RequestMapping(value="requestPassword.html", method=RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String recuperarPassword(@RequestParam("u") String usuario){
        log.info("INICIO");
        log.info("Usuario/correo a recuperar password ->{}",usuario);
        ValidacionResponse response = usuarioServices.recuperacionPassword(new RecuperacionPasswordRequest(usuario));
        String respJson =  new Gson().toJson(response);
        log.info("FIN");
        return respJson;
    }
    
}
