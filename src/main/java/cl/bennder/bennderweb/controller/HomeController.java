/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.controller;

import cl.bennder.bennderweb.session.UsuarioSession;
import cl.bennder.bennderweb.services.CategoriaServices;
import cl.bennder.bennderweb.services.HomeServices;
import cl.bennder.entitybennderwebrest.request.CargarHomeRequest;
import cl.bennder.entitybennderwebrest.response.CargarHomeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 *
 * @author dyanez 28-12-2016
 */
@Controller
public class HomeController {
    
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);
    
    @Autowired
    private UsuarioSession usuarioSession;
    
    @Autowired
    private CategoriaServices categoriaServices;
    
    @Autowired
    private HomeServices homeServices;
    
    
//    @ExceptionHandler    
        //.- home (Version 1)!!!    
//    @RequestMapping(value = "/home.html", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
//    public ModelAndView homeI(HttpSession session) {
//        log.info("INICIO");
//        log.info("Usuario connected ->{}",usuarioSession.getIdUsuario());
//        ModelAndView modelAndView = new ModelAndView("home");
//        try {
//            session.setAttribute("categorias", categoriaServices.obtenerCategorias().getCategorias());
//            log.info("FIN");
//
//        }
//        catch (HttpClientErrorException ex) {
//            log.error("[Exception] Error al obtener categorías", ex);
//            if (ex.getStatusCode().equals(HttpStatus.UNAUTHORIZED))
//                modelAndView.setViewName("errorPage");
//        }
//        return modelAndView;
//    }
    
    @RequestMapping(value = "/home.html", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public ModelAndView homeI(HttpSession session) {
        log.info("INICIO");
        log.info("Usuario connected ->{}",usuarioSession.getIdUsuario());
        ModelAndView modelAndView = new ModelAndView("home");
        
        CargarHomeRequest request = new CargarHomeRequest();
        request.setIdUsuario(usuarioSession.getIdUsuario());
        
        CargarHomeResponse response =  homeServices.cargarHome(request);
                
        try {
            session.setAttribute("categorias", response.getCategorias());
            log.info("FIN");

        }
        catch (HttpClientErrorException ex) {
            log.error("[Exception] Error al obtener categorías", ex);
            if (ex.getStatusCode().equals(HttpStatus.UNAUTHORIZED))
                modelAndView.setViewName("errorPage");
        }
        
        log.info("FIN");
        return modelAndView;
    }
    
    
    
    

    /*
    @RequestMapping(value = "/admin/home.html", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public ModelAndView admin() {
        log.info("INICIO");
        log.info("Usuario connected ->{}",usuarioSession.getIdUsuario());
        ModelAndView modelAndView = new ModelAndView("home");
        
        modelAndView.addObject("categorias", categoriaServices.getCategorias().getCategorias());
        modelAndView.addObject("rol", "admin");
        log.info("FIN");
        return modelAndView;
    }
    @RequestMapping(value = "/proveedor/home.html", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public ModelAndView proveedor() {
        log.info("INICIO");
        log.info("Usuario connected ->{}",usuarioSession.getIdUsuario());
        ModelAndView modelAndView = new ModelAndView("home");
        
        modelAndView.addObject("categorias", categoriaServices.getCategorias().getCategorias());
        modelAndView.addObject("rol", "proveedor");
        log.info("FIN");
        return modelAndView;
    }
    @RequestMapping(value = "/empresa/home.html", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public ModelAndView empresa() {
        log.info("INICIO");
        log.info("Usuario connected ->{}",usuarioSession.getIdUsuario());
        ModelAndView modelAndView = new ModelAndView("home");
        
        modelAndView.addObject("categorias", categoriaServices.getCategorias().getCategorias());
        modelAndView.addObject("rol", "empresa");
        log.info("FIN");
        return modelAndView;
    }*/
    
    @RequestMapping(value = "/cierreSession.html", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public ModelAndView pageNotFound() {
        log.info("INICIO");
        ModelAndView modelAndView = new ModelAndView("index");
        log.info("FIN");
        return modelAndView;
    }
//    @RequestMapping(value = "/redirect.html", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
//    public ModelAndView redirect() {
//        log.info("INICIO");
//        ModelAndView modelAndView = new ModelAndView("index");
//        log.info("FIN");
//        return modelAndView;
//    }
    
}
