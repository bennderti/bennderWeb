package cl.bennder.bennderweb.controller;

import cl.bennder.bennderweb.session.UsuarioSession;
import cl.bennder.bennderweb.services.CategoriaServices;
import cl.bennder.bennderweb.session.BeneficioSession;
import cl.bennder.entitybennderwebrest.request.PaginadorBeneficioRequest;
import cl.bennder.entitybennderwebrest.response.BeneficiosResponse;
import cl.bennder.entitybennderwebrest.response.CategoriaResponse;
import cl.bennder.entitybennderwebrest.response.PaginadorBeneficioResponse;
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
    
    @Autowired
    private BeneficioSession beneficioSession;
    
    @RequestMapping(value = "/beneficiosPaginados.html", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public @ResponseBody String beneficiosPaginados(@RequestParam("indicePagina") Integer indicePagina,
                                                    @RequestParam("esInicial") Integer esInicial,
                                                    @RequestParam("idCatP") Integer idCatP,
                                                    @RequestParam("idCat") Integer idCat){
        log.info("INICIO");
        log.info("indicePagina->{}, esInicial ->{}, idCatP ->{}, idCat ->{}",indicePagina,esInicial,idCatP,idCat);
        String beneficiosJson = "";
        if(esInicial!=null && esInicial.equals(1)){
            log.info("obtenemos beneficios paginados...");
            beneficioSession.getPaginador().setIndicePagina(indicePagina);
            beneficioSession.getPaginador().getCategoria().setIdCategoria(idCat);
            beneficioSession.getPaginador().getCategoria().setIdCategoriaPadre(idCatP);
            PaginadorBeneficioResponse resp = categoriaServices.obtenerBeneficiosPaginados(new PaginadorBeneficioRequest(beneficioSession.getPaginador()));
            beneficiosJson = new Gson().toJson(resp);
        }
        else{
            log.info("obtenemos beneficios de sessión (carga inicial de página)");
            beneficiosJson = new Gson().toJson(new PaginadorBeneficioResponse(beneficioSession.getPaginador(), beneficioSession.getBeneficios()));
        }
        log.info("beneficiosJson ->{} ",beneficiosJson);
        log.info("FIN");
        return beneficiosJson;
    }

    /**
     * @author Diego
     * @param idCategoria
     * Carga la pantalla al seleccionar una categoria
     */
    @ExceptionHandler
    @RequestMapping(value = "/{idCategoria}.html", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public ModelAndView obtenerDetalleCategoria(@PathVariable Integer idCategoria) {
        log.info("INICIO");
        log.info("Usuario connected ->{}",usuarioSession.getIdUsuario());
        ModelAndView modelAndView = new ModelAndView("categoria");
        try {
            modelAndView.addObject("categorias", categoriaServices.obtenerCategorias().getCategorias());
            CategoriaResponse response = categoriaServices.cargarCategoria(idCategoria);
            modelAndView.addObject("beneficios", response.getBeneficios());
            beneficioSession.setBeneficios(response.getBeneficios());
            beneficioSession.setPaginador(response.getPaginador());
//            modelAndView.addObject("arrayBeneficios", new Gson().toJson(response.getBeneficios()));
//            modelAndView.addObject("paginador", new Gson().toJson(response.getPaginador()));
            
            modelAndView.addObject("idCategoriaPadre", response.getPaginador().getCategoria().getIdCategoriaPadre());
            modelAndView.addObject("idCategoria", response.getPaginador().getCategoria().getIdCategoria());
            modelAndView.addObject("categoriasRelacionadas", response.getCategoriasRelacionadas());
            modelAndView.addObject("categoriasRelacionadas", response.getCategoriasRelacionadas());
            modelAndView.addObject("nombreCategoria", response.getCategoriaPadre().getNombre());
            modelAndView.addObject("categoriaSeleccionada", idCategoria);
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
    public @ResponseBody String filtrarBeneficiosPorPrecio(@RequestParam("categoriaSeleccionada") Integer categoriaSeleccionada,
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
    public @ResponseBody String filtrarBeneficiosPorDescuento(@RequestParam("categoriaSeleccionada") Integer categoriaSeleccionada,
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

    /**
     * Obtiene una lista de beneficios dado un proveedor
     * @param proveedor
     * @return Beneficios filtrados
     */
    @RequestMapping(value = "/filtrarBeneficiosPorProveedor.html", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public @ResponseBody String filtrarBeneficiosPorProveedor(@RequestParam("proveedor") String proveedor, @RequestParam("categoriaSeleccionada") Integer categoriaSeleccionada){
        log.info("INICIO");
        log.info("proveedor ->{}", proveedor);
        log.info("categoriaSeleccionada ->{}", categoriaSeleccionada);

        BeneficiosResponse response = categoriaServices.filtrarBeneficiosPorProveedor(proveedor, categoriaSeleccionada);
        String responseString = new Gson().toJson(response);
        log.info("FIN");
        return responseString;
    }

    /**
     * Obtiene una lista de beneficios dado una calificacion
     * @param calificacion Integer entre 1 a 5
     * @return Beneficios filtrados
     */
    @RequestMapping(value = "/filtrarBeneficiosPorCalificacion.html", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public @ResponseBody String filtrarBeneficiosPorCalificacion(@RequestParam("calificacion") String calificacion, @RequestParam("categoriaSeleccionada") Integer categoriaSeleccionada){
        log.info("INICIO");
        log.info("calificacion ->{}", calificacion);
        log.info("categoriaSeleccionada ->{}", categoriaSeleccionada);

        BeneficiosResponse response = categoriaServices.filtrarBeneficiosPorCalificacion(calificacion, categoriaSeleccionada);
        String responseString = new Gson().toJson(response);
        log.info("FIN");
        return responseString;
    }
}
