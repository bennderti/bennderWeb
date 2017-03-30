package cl.bennder.bennderweb.controller;

import cl.bennder.bennderweb.model.UsuarioSession;
import cl.bennder.bennderweb.services.BeneficioServices;
import cl.bennder.bennderweb.services.CategoriaServices;
import cl.bennder.entitybennderwebrest.request.BeneficioRequest;
import cl.bennder.entitybennderwebrest.response.BeneficioResponse;
import cl.bennder.entitybennderwebrest.response.CategoriaResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Diego on 29-03-2017.
 */
@RestController
public class BeneficioController {

    private static final Logger log = LoggerFactory.getLogger(BeneficioController.class);

    @Autowired
    private BeneficioServices beneficioServices;

    @Autowired
    private UsuarioSession usuarioSession;

    /**
     * @author Diego Riveros
     * @param idBeneficio
     * @return vista con detalle de un beneficio
     */
    @ExceptionHandler
    @RequestMapping(value = "/detalleBeneficio/{idBeneficio}.html", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public ModelAndView obtenerDetalleBeneficio(@PathVariable Integer idBeneficio) {
        log.info("INICIO");
        log.info("Usuario connected ->{}",usuarioSession.getIdUsuario());
        ModelAndView modelAndView = new ModelAndView("detalleBeneficio");

        BeneficioResponse response = beneficioServices.obtenerDetalleBeneficio(new BeneficioRequest(idBeneficio));
        modelAndView.addObject("beneficio", response.getBeneficio());

        log.info("FIN");
        return modelAndView;
    }
}
