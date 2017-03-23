package cl.bennder.bennderweb.controller;



import cl.bennder.bennderweb.model.UsuarioSession;
import cl.bennder.bennderweb.services.CategoriaServices;
import cl.bennder.entitybennderwebrest.model.Validacion;
import cl.bennder.entitybennderwebrest.request.CategoriaByIdRequest;
import cl.bennder.entitybennderwebrest.response.BeneficiosResponse;
import cl.bennder.entitybennderwebrest.response.CategoriasResponse;
import com.google.gson.Gson;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Diego on 01-03-2017.
 */
@Controller
public class CargadorController {

    private static final Logger log = LoggerFactory.getLogger(CargadorController.class);

    @Autowired
    private CategoriaServices categoriaServices;

    @Autowired
    private UsuarioSession usuarioSession;

    @ExceptionHandler
    @RequestMapping(value = "/listaCategorias.html", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public ModelAndView obtenerDetalleCategoria() {
        log.info("INICIO");
        log.info("Usuario connected ->{}",usuarioSession.getIdUsuario());
        ModelAndView modelAndView = new ModelAndView("cargadorImagenes");
        modelAndView.addObject("categorias", categoriaServices.obtenerCategorias().getCategorias());
        log.info("FIN");
        return modelAndView;
    }
    
    @RequestMapping(value="getSubCatById.html", method=RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public @ResponseBody String getSubCatById(@RequestParam("id") Integer idCategoria, HttpSession session){
        log.info("INICIO - idCategoria ->{}",idCategoria);
        CategoriasResponse response = new CategoriasResponse();
        response.setValidacion(new Validacion("0", "1", "Sin categorias encontradas"));
        if(idCategoria!=null){
            response = categoriaServices.obtenerCategoriasById(new CategoriaByIdRequest(idCategoria));
        }
        String respJson =  new Gson().toJson(response);
        log.info("FIN");
        return respJson;
    }
    
    @RequestMapping(value="getBeneficiosByIdCat.html", method=RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public @ResponseBody String getBeneficiosByIdCat(@RequestParam("id") Integer idCategoria, HttpSession session){
        log.info("INICIO - idBeneficio ->{}",idCategoria);
        BeneficiosResponse response = new BeneficiosResponse();
        response.setValidacion(new Validacion("0", "1", "Sin beneficios encontradas"));
        if(idCategoria!=null){
            response = categoriaServices.getBeneficiosByIdCat(new CategoriaByIdRequest(idCategoria));
        }
        String respJson =  new Gson().toJson(response);
        log.info("FIN");
        return respJson;
    }
}
