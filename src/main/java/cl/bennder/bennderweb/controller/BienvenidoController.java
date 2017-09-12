/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.controller;

import cl.bennder.bennderweb.services.BienvenidoServices;
import cl.bennder.entitybennderwebrest.request.BienvenidoRequest;
import cl.bennder.entitybennderwebrest.request.GuardarDatosBienvenidaRequest;
import cl.bennder.entitybennderwebrest.response.BienvenidoResponse;
import cl.bennder.entitybennderwebrest.response.GuardarDatosBienvenidaResponse;
import com.google.gson.Gson;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Marcos
 */
@Controller
public class BienvenidoController {
    
    private static final Logger log = LoggerFactory.getLogger(BienvenidoController.class);
    
    @Autowired
    private BienvenidoServices bienvenidoServices;
    
    @RequestMapping(value = "/bienvenido.html", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public ModelAndView index() {
        log.info("INICIO");
        
        BienvenidoRequest request = new BienvenidoRequest();
        
        BienvenidoResponse response;
        
        response = bienvenidoServices.obtenerDatosBienvenida(request);
        
        ModelAndView modelAndView = new ModelAndView("bienvenido");
        modelAndView.addObject("categorias", response.getCategorias());
        
        log.info("FIN");
        return modelAndView;
    }
    
    @RequestMapping(value="/bienvenido/guardarDatosBienvenida.html", method=RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String guardarDatosBienvenida(@RequestParam("listaCategoriasSelec") List<Integer> listaCategoriasSelec, HttpSession session){
        log.info("INICIO");     
        String respJson = "";
 
        if(listaCategoriasSelec!=null && !listaCategoriasSelec.isEmpty())
        {
            log.info("Cantidad de categorias seleccionadas ->{}",listaCategoriasSelec.size());
            
            GuardarDatosBienvenidaRequest request = new GuardarDatosBienvenidaRequest();
            request.setListaCategoriasSelec(listaCategoriasSelec);
            
            GuardarDatosBienvenidaResponse response = bienvenidoServices.guardarDatosBienvenida(request);
            
            respJson =  new Gson().toJson(response.getValidacion());
        }
        else
        {
            log.info("La lista de categorias seleccionadas es vacía o nula");            
            respJson =  new Gson().toJson("Debe haber seleccionado al menos una categoría");
        }
        
        log.info("respJson->{}",respJson);
        log.info("FIN");
        return respJson;
    }
}
