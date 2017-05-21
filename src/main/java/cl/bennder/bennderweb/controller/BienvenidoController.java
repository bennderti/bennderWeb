/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Marcos
 */
@Controller
@RequestMapping("/{tenantId}")
public class BienvenidoController {
    
    private static final Logger log = LoggerFactory.getLogger(BienvenidoController.class);
    
    @RequestMapping(value = "/bienvenido.html", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public ModelAndView index() {
        log.info("INICIO");
        ModelAndView modelAndView = new ModelAndView("bienvenido");
        log.info("FIN");
        return modelAndView;
    }
}
