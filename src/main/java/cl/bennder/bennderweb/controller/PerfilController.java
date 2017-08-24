/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.controller;

import cl.bennder.bennderweb.services.PerfilService;
import cl.bennder.bennderweb.session.PerfilSession;
import cl.bennder.bennderweb.session.UsuarioSession;
import cl.bennder.entitybennderwebrest.model.Comuna;
import cl.bennder.entitybennderwebrest.model.DatosPerfil;
import cl.bennder.entitybennderwebrest.model.Sucursal;
import cl.bennder.entitybennderwebrest.request.DatosPerfilRequest;
import cl.bennder.entitybennderwebrest.request.InfoDatosPerfilRequest;
import cl.bennder.entitybennderwebrest.request.InfoInicioSucursalRequest;
import cl.bennder.entitybennderwebrest.request.InfoSucursalRequest;
import cl.bennder.entitybennderwebrest.request.SucursalesRequest;
import cl.bennder.entitybennderwebrest.response.DatosPerfilResponse;
import cl.bennder.entitybennderwebrest.response.InfoDatosPerfilResponse;
import cl.bennder.entitybennderwebrest.response.InfoInicioSucursalResponse;
import cl.bennder.entitybennderwebrest.response.InfoSucursalResponse;
import cl.bennder.entitybennderwebrest.response.SucursalesResponse;
import com.google.gson.Gson;
import java.util.List;
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
 * @author ext_dayanez
 */
@Controller
public class PerfilController {
    
    @Autowired
    private UsuarioSession usuarioSession;
    
    @Autowired
    private PerfilSession perfilSession;
    
    
    @Autowired
    private PerfilService perfilService;
    
    private static final Logger log = LoggerFactory.getLogger(PerfilController.class);
    
//    @RequestMapping(value = "/sucursal/crear.html", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
//    public ModelAndView crearSucursal() {
//        log.info("inicio");
//        ModelAndView modelAndView = new ModelAndView("proveedor/sucursal");        
//        InfoInicioSucursalResponse response = sucursalService.getInfoInicioSucursal(new InfoInicioSucursalRequest());
//        modelAndView.addObject("sucursalForm", new Sucursal());
//        modelAndView.addObject("regiones", response.getRegiones());
//        sucursalSession.setComunas(response.getComunas());
//        log.info("fin");
//        return modelAndView;
//    }
    
    @RequestMapping(value = "/perfil/getDatos.html", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public ModelAndView getDatosPerfil() {
        log.info("inicio");
        DatosPerfilResponse response = new DatosPerfilResponse();//perfilService.getDatosPerfil(new DatosPerfilRequest(usuarioSession.getUsuario()));
        ModelAndView modelAndView = new ModelAndView("datosPerfil");
        modelAndView.addObject("datosPerfilForm", response.getDatosPerfil());
        modelAndView.addObject("regiones", response.getRegiones());
        perfilSession.setComunas(response.getComunas());
        modelAndView.addObject("comunasRegion", perfilService.getComunasByRegion(response.getDatosPerfil().getDireccion().getComuna().getRegion().getIdRegion()));
        log.info("fin");
        return modelAndView;
    }
    
    @RequestMapping(value="/perfil/getComunaByIdReg.html", method=RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public @ResponseBody String getComunaByIdReg(@RequestParam("idRegion") Integer idRegion, 
                                              HttpSession session){
        log.info("INICIO");
        List<Comuna> comunas = perfilService.getComunasByRegion(idRegion);
        if(comunas != null){
            log.info("comunas.size()->{}",comunas.size());
        }
        String respJson =  new Gson().toJson(comunas);
        log.info("FIN");
        return respJson;
    }
    
    @RequestMapping(value = "/perfil/guardar.html", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String  guardarDatosPerfil(@ModelAttribute("datosPerfilForm") DatosPerfil datosPerfil) {
        log.info("INICIO");
        log.info("Datos perfil ->{}.",datosPerfil.toString());
        InfoDatosPerfilResponse response = perfilService.guardarDatosPerfil(new InfoDatosPerfilRequest(datosPerfil));
        log.info("FIN");
        String respJson =  new Gson().toJson(response.getValidacion());
        return respJson;
    }
//    @RequestMapping(value = "sucursales.html", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
//    public ModelAndView sucursales() {
//        log.info("INICIO");
//        ModelAndView modelAndView = new ModelAndView("sucursales");
//        SucursalesResponse response = sucursalService.getSucursalesProveedor(new SucursalesRequest());
//        modelAndView.addObject("sucursales", response.getSucursales());
//        log.info("FIN");
//        return modelAndView;
//    }
}
