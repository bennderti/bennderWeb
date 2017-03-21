package cl.bennder.bennderweb.controller;

import cl.bennder.bennderweb.model.Categoria;
import cl.bennder.bennderweb.model.UsuarioSession;
import cl.bennder.bennderweb.rest.response.CategoriaResponse;
import cl.bennder.bennderweb.services.CategoriaServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Diego on 01-03-2017.
 */
@Controller
public class CategoriaController {

    private static final Logger log = LoggerFactory.getLogger(CategoriaController.class);

    @Autowired
    private CategoriaServices categoriaServices;

    @Autowired
    private UsuarioSession usuarioSession;

    @ExceptionHandler
    @RequestMapping(value = "/categoria/{nombreCategoria}.html", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public ModelAndView obtenerDetalleCategoria(@PathVariable String nombreCategoria) {
        log.info("INICIO");
        log.info("Usuario connected ->{}",usuarioSession.getIdUsuario());
        ModelAndView modelAndView = new ModelAndView("categoria");

        modelAndView.addObject("categorias", categoriaServices.obtenerCategorias().getCategorias());
        CategoriaResponse response = categoriaServices.cargarCategoria(nombreCategoria);
        modelAndView.addObject("beneficios", response.getBeneficios());
        modelAndView.addObject("categoriasRelacionadas", response.getCategoriasRelacionadas());
        modelAndView.addObject("nombreCategoria", nombreCategoria);

        log.info("FIN");
        return modelAndView;
    }
}