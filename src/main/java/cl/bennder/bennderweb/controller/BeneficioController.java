package cl.bennder.bennderweb.controller;

import cl.bennder.bennderweb.model.UsuarioSession;
import cl.bennder.bennderweb.services.BeneficioServices;
import cl.bennder.bennderweb.services.CuponBeneficioServices;
import cl.bennder.entitybennderwebrest.request.BeneficioRequest;
import cl.bennder.entitybennderwebrest.request.GetCuponBeneficioRequest;
import cl.bennder.entitybennderwebrest.response.BeneficioResponse;
import cl.bennder.entitybennderwebrest.response.GetCuponBeneficioResponse;
import com.google.gson.Gson;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    
    @Autowired
    private CuponBeneficioServices uponBeneficioServices;
    
    /***
     * Método que entrega mensaje al usuario al momento de descargar cupón
     * @return vista html para mostrar al usuario mensaje de validación
     */
    @RequestMapping(value = "/validacionCupon.html", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public ModelAndView validacionCupon() {
        log.info("INICIO");
        ModelAndView modelAndView = new ModelAndView("validacionBeneficio");
        log.info("Mensaje ->{}",usuarioSession.getValidacion().getMensaje());
        modelAndView.addObject("mensaje", usuarioSession.getValidacion().getMensaje());
        log.info("FIN");
        return modelAndView;
    }
    
    /***
     * Permite descargar el pdf en browser
     * @param response Objeto para enviar el pdf al browser
     * @param session datos de sessión para obtner los bytes del cupon de pdf
     */
    @RequestMapping(value = "/downloadCuponPdf.html", method = RequestMethod.GET)
    public void downloadCuponPdf(HttpServletResponse response,HttpSession session) {
        try {
          // get your file as InputStream
          //InputStream is = ...;
          // copy it to response's OutputStream
          log.info("inicio");
          //File initialFile = new File("C:\\Users\\dyanez\\AppData\\Local\\Temp\\sample1.pdf");
          //InputStream is = new ByteArrayInputStream(decodedBytes);
          //InputStream targetStream = FileUtils.openInputStream(initialFile);
          byte[] bytesPdf = (byte[])session.getAttribute("cuponPdf");
          if(bytesPdf != null){
                log.info("descargando cupón pdf en browser");
                InputStream targetStream = new ByteArrayInputStream(bytesPdf);
                org.apache.commons.io.IOUtils.copy(targetStream, response.getOutputStream());
                response.flushBuffer();
                response.setContentType("application/pdf");
          }
          else{
              log.info("No existe información de pdf de cupón a generar");
              response.sendError(200,"No existe información de pdf de cupón a generar");              
          }

          log.info("fin");
        } catch (IOException ex) {
          log.info("Error al generar cupón", ex);
          throw new RuntimeException("Error al generar cupón");
        }

    }
    
    
    @RequestMapping(value = "/downloadCupon.html", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public ModelAndView obtenerDetalleBeneficio(@RequestParam("c") String codigoCuponEncriptado) {
        log.info("INICIO");
        log.info("codigoCuponEncriptado(antes formatear) ->{}",codigoCuponEncriptado);
        codigoCuponEncriptado = codigoCuponEncriptado.replaceAll(" ", "\\+");	
        log.info("codigoCuponEncriptado(despues formatear) ->{}",codigoCuponEncriptado);
        usuarioSession.setCodigoCuponEncriptado(codigoCuponEncriptado);
        //.- valida si usuario ha iniciado sessión, para enviar a pantalla directamente a generar pdf o validación
        //.-------------------------------------------------
        //.-------------------------------------------------
        //.------------------APLCIAR VALIDACIÓN-------------------------------
        //.-------------------------------------------------
        //.-------------------------------------------------
        
        log.info("redireccionando a index");
        log.info("FIN");
        return new ModelAndView("redirect:index.html");
    }

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
    
    /**
     * Método utilizado cuando usuario ha seleccionado un cupon bajo la opción obtenido
     * @author dyanez
     * @param idBeneficio beneficio seleccionado
     * @return vista con detalle de un beneficio
     */
    @ExceptionHandler
    @RequestMapping(value = "/getCuponBeneficio/{idBeneficio}.html", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public @ResponseBody String getCuponBeneficio(@PathVariable Integer idBeneficio) {
        log.info("INICIO");
        log.info("Usuario connected ->{}, beneficio seleccionado ->{}",usuarioSession.getIdUsuario(),idBeneficio);
        GetCuponBeneficioResponse response = beneficioServices.getCuponBeneficio(new GetCuponBeneficioRequest(idBeneficio, usuarioSession.getIdUsuario()));
        String respJson =  new Gson().toJson(response);
        log.info("respJson ->{}",respJson);
        log.info("FIN");
        return respJson;
    }
}
