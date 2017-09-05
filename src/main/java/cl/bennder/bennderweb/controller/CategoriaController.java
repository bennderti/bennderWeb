package cl.bennder.bennderweb.controller;

import cl.bennder.bennderweb.session.UsuarioSession;
import cl.bennder.bennderweb.services.CategoriaServices;
import cl.bennder.entitybennderwebrest.response.BeneficiosResponse;
import cl.bennder.entitybennderwebrest.response.CategoriaResponse;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;

import javax.enterprise.inject.Model;

/**
 * Created by Diego on 01-03-2017.
 */
@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    private static final Logger log = LoggerFactory.getLogger(CategoriaController.class);

    @Autowired
    private CategoriaServices categoriaServices;

    @Autowired
    private UsuarioSession usuarioSession;

    /**
     * @author Diego
     * @param nombreCategoria
     * Carga la pantalla al seleccionar una categoria
     */
    @ExceptionHandler
    @RequestMapping(value = "/{nombreCategoria}.html", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public ModelAndView obtenerDetalleCategoria(@PathVariable String nombreCategoria) {
        log.info("INICIO");
        log.info("Usuario connected ->{}",usuarioSession.getIdUsuario());
        ModelAndView modelAndView = new ModelAndView("categoria");
        try {
            modelAndView.addObject("categorias", categoriaServices.obtenerCategorias().getCategorias());
            CategoriaResponse response = categoriaServices.cargarCategoria(nombreCategoria);
            modelAndView.addObject("beneficios", response.getBeneficios());
            modelAndView.addObject("categoriasRelacionadas", response.getCategoriasRelacionadas());
            modelAndView.addObject("nombreCategoria", response.getCategoriaPadre().getNombre());
            modelAndView.addObject("categoriaSeleccionada", nombreCategoria);
            modelAndView.addObject("filtroProveedores", response.getFiltros().get("proveedores"));
            if (response.getRango().get("precioMin") != null && response.getRango().get("precioMax") != null)
                modelAndView.addObject("rango", response.getRango());

        }
        catch (HttpClientErrorException ex){
            log.error(ex.getLocalizedMessage());
            if (ex.getStatusCode().equals(HttpStatus.UNAUTHORIZED))
                modelAndView.setViewName("errorPage");
        }
        log.info("FIN");
        return modelAndView;
    }

    @RequestMapping(value = "/filtrarBeneficiosPorPrecio.html", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public @ResponseBody String filtrarBeneficiosPorPrecio(@RequestParam("categoriaSeleccionada") String categoriaSeleccionada,
                                                   @RequestParam("precioMin") Integer precioMin,
                                                   @RequestParam("precioMax") Integer precioMax){
        log.info("INICIO");
        log.info("categoriaSeleccionada ->{}",categoriaSeleccionada);
        log.info("precioMin ->{}",precioMin);
        log.info("precioMax ->{}",precioMax);

        BeneficiosResponse response = categoriaServices.obtenerBeneficiosCategoriaFiltradosPorPrecio(categoriaSeleccionada, precioMin, precioMax);
        String responseString = new Gson().toJson(response);
        log.info("FIN");
        return responseString;
    }

    @RequestMapping(value = "/filtrarBeneficiosPorDescuento.html", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public @ResponseBody String filtrarBeneficiosPorDescuento(@RequestParam("categoriaSeleccionada") String categoriaSeleccionada,
                                                           @RequestParam("descuentoMin") Integer descuentoMin,
                                                           @RequestParam("descuentoMax") Integer descuentoMax){
        log.info("INICIO");
        log.info("categoriaSeleccionada ->{}",categoriaSeleccionada);
        log.info("descuentoMin ->{}",descuentoMin);
        log.info("descuentoMax ->{}",descuentoMax);

        BeneficiosResponse response = categoriaServices.obtenerBeneficiosCategoriaFiltradosPorDescuento(categoriaSeleccionada, descuentoMin, descuentoMax);
        String responseString = new Gson().toJson(response);
        log.info("FIN");
        return responseString;
    }
}
