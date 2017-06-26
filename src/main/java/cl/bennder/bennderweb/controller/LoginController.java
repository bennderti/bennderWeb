/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.controller;

import cl.bennder.bennderweb.body.response.LoginBodyResponse;
import cl.bennder.bennderweb.constantes.GoToUrl;
import cl.bennder.bennderweb.model.LoginForm;
import cl.bennder.bennderweb.multitenancy.TenantContext;
import cl.bennder.bennderweb.session.UsuarioSession;
import cl.bennder.bennderweb.services.CuponBeneficioServices;
import cl.bennder.bennderweb.services.UsuarioServices;
import cl.bennder.bennderweb.util.UtilBennderWeb;
import cl.bennder.entitybennderwebrest.request.LoginRequest;
import cl.bennder.entitybennderwebrest.request.RecuperacionPasswordRequest;
import cl.bennder.entitybennderwebrest.response.LoginResponse;
import cl.bennder.entitybennderwebrest.response.ValidacionResponse;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Map;

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
    @RequestMapping(value = "{tenantId}/index.html", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public ModelAndView index(HttpServletRequest request) {
        log.info("INICIO");
        if(request!=null && request.getParameter("c")!=null){
            String codigoCuponEncriptado = request.getParameter("c");
            log.info("cliente ha seleccionado link bennder desde correo enviando códigos de cupón encriptado...");
            log.info("codigoCuponEncriptado(antes formatear) ->{}",codigoCuponEncriptado);
            codigoCuponEncriptado = codigoCuponEncriptado.replaceAll(" ", "\\+");	
            log.info("codigoCuponEncriptado(despues formatear) ->{} y seteando en sesión de usuario",codigoCuponEncriptado);
            usuarioSession.setCodigoCuponEncriptado(codigoCuponEncriptado);
        }
        
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("loginForm", new LoginForm());
        log.info("FIN");
        return modelAndView;
    }

    /**
     * Metodo para authenticar al usuario
     * @param loginForm (email, password)
     * @param session
     * @return pagina home
     * @author driveros
     */
    @RequestMapping(value = "{tenantId}/login.html", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String login(@ModelAttribute("loginForm") LoginForm loginForm, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        log.info("INICIO");
        log.info("datos ->{}", loginForm.toString());

        try {
            if (!obtenerTenantId(request, response)){
                return null;
            }
            usuarioSession.setTenantId(UtilBennderWeb.getTenantId(request));
            LoginResponse loginResponse = usuarioServices.validacionUsuario(new LoginRequest(loginForm.getUser(), loginForm.getPassword()));
            LoginBodyResponse rBody = new LoginBodyResponse();
            rBody.setValidacion(loginResponse.getValidacion());

            if (loginResponse.getValidacion() != null && loginResponse.getValidacion().getCodigo() != null && "0".equals(loginResponse.getValidacion().getCodigo())) {
                String mensajeLog = "[token -> " + loginResponse.getToken() + "]";

                usuarioSession.setUsuario(loginForm.getUser());//rut de cliente sin dv
                session.setAttribute("user", loginForm.getUser());
                usuarioSession.setToken(loginResponse.getToken());
                log.debug(usuarioSession.getToken());

                if (usuarioSession != null && usuarioSession.getCodigoCuponEncriptado() != null) {
                    
                    log.info("{} Usuario ha pinchado en link de correo enviado con información de cupón, por tanto ahora validando", mensajeLog);
                    rBody.setGoToUrl(cuponBeneficioServices.validaLinkExternoCupon(session));
                } else {
                    if (loginResponse.getIdEstadoUsuario() == 1) {
                        rBody.setGoToUrl(session.getServletContext().getContextPath() + GoToUrl.URL_BIENVENIDO);
                    } else {
                        rBody.setGoToUrl(session.getServletContext().getContextPath() + GoToUrl.URL_HOME);
                    }
                }
                log.info("Se guarda usuario en sessión ->{}", loginForm.getUser());
            }
            String respJson = new Gson().toJson(rBody);
            log.info("FIN");
            return respJson;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value="/logout.html", method=RequestMethod.GET, produces = "text/html;charset=UTF-8")
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
    @RequestMapping(value="/requestPassword.html", method=RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String recuperarPassword(@RequestParam("u") String usuario){
        log.info("INICIO");
        log.info("Usuario/correo a recuperar password ->{}",usuario);
        ValidacionResponse response = usuarioServices.recuperacionPassword(new RecuperacionPasswordRequest(usuario));
        String respJson =  new Gson().toJson(response);
        log.info("FIN");
        return respJson;
    }

    private Boolean obtenerTenantId(HttpServletRequest req, HttpServletResponse res) throws IOException{

        Map<String, Object> pathVars = (Map<String, Object>) req.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

        if (pathVars.containsKey("tenantId")) {
            req.setAttribute("CURRENT_TENANT_IDENTIFIER", pathVars.get("tenantid"));
            TenantContext.setCurrentTenant(pathVars.get("tenantId").toString());
            return true;
        }
        res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        res.setContentType(MediaType.APPLICATION_JSON_VALUE);
        res.getWriter().write("{\"error\": \"No tenant supplied\"}");
        res.getWriter().flush();
        return false;
    }
    
}
