/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.controller;

import cl.bennder.bennderweb.model.LoginForm;
import cl.bennder.bennderweb.model.UsuarioSession;
import cl.bennder.bennderweb.rest.request.LoginRequest;
import cl.bennder.bennderweb.rest.response.LoginResponse;
import cl.bennder.bennderweb.services.CategoriaServices;
import cl.bennder.bennderweb.services.UsuarioServices;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    
    
    @ExceptionHandler
    
        //.- home (Version 1)!!!    
    @RequestMapping(value = "/home.html", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public ModelAndView homeI() {
        log.info("INICIO");
        log.info("Usuario connected ->{}",usuarioSession.getIdUsuario());
        ModelAndView modelAndView = new ModelAndView("home");
        
        modelAndView.addObject("categorias", categoriaServices.getCategorias().getCategorias());
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
