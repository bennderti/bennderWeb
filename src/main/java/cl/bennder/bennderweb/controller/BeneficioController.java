package cl.bennder.bennderweb.controller;

import cl.bennder.bennderweb.model.UsuarioSession;
import cl.bennder.bennderweb.model.ValidaCuponForm;
import cl.bennder.bennderweb.services.BeneficioServices;
import cl.bennder.bennderweb.services.CuponBeneficioServices;
import cl.bennder.entitybennderwebrest.model.SucursalProveedor;
import cl.bennder.entitybennderwebrest.model.Validacion;
import cl.bennder.entitybennderwebrest.request.BeneficioRequest;
import cl.bennder.entitybennderwebrest.request.CanjeaCuponRequest;
import cl.bennder.entitybennderwebrest.request.GetCuponBeneficioRequest;
import cl.bennder.entitybennderwebrest.request.ValidacionCuponPOSRequest;
import cl.bennder.entitybennderwebrest.response.BeneficioResponse;
import cl.bennder.entitybennderwebrest.response.CanjeaCuponResponse;
import cl.bennder.entitybennderwebrest.response.GetCuponBeneficioResponse;
import cl.bennder.entitybennderwebrest.response.ValidacionCuponPOSResponse;
import com.google.gson.Gson;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
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
    private CuponBeneficioServices cuponBeneficioServices;
    
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
    public ModelAndView obtenerDetalleBeneficio(@RequestParam("c") String codigoCuponEncriptado,HttpSession session) {
        log.info("INICIO");
        log.info("codigoCuponEncriptado(antes formatear) ->{}",codigoCuponEncriptado);
        codigoCuponEncriptado = codigoCuponEncriptado.replaceAll(" ", "\\+");	
        log.info("codigoCuponEncriptado(despues formatear) ->{}",codigoCuponEncriptado);
        usuarioSession.setCodigoCuponEncriptado(codigoCuponEncriptado);
        String url = "index.html";
        if(usuarioSession!=null && usuarioSession.getIdUsuario()!=null){
            String mensajeLog = "[IdUsuario -> "+usuarioSession.getIdUsuario()+"]";
            log.info("{} Usuario ha pinchado en link de correo enviado con información de cupón, por tanto ahora validando",mensajeLog);
            url = cuponBeneficioServices.validaLinkExternoCupon(session);
        }
        else{
            log.info("Usuario no ha iniciado sesión, se redigige a login");
        }
        
        log.info("redireccionando a ->{}",url);
        log.info("FIN");
        return new ModelAndView("redirect:"+url);
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
        if(response.getBeneficio()!=null){
            response.getBeneficio().setIdBeneficio(idBeneficio);
        }
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
    
    @RequestMapping(value = "/canjeCupon.html", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public ModelAndView canjeCupon(@RequestParam("c") String codigoCuponEncriptado,HttpSession session) {
        log.info("INICIO");
        log.info("codigoCuponEncriptado(antes formatear) ->{}",codigoCuponEncriptado);
        codigoCuponEncriptado = codigoCuponEncriptado.replaceAll(" ", "\\+");	
        log.info("codigoCuponEncriptado(despues formatear) ->{}",codigoCuponEncriptado);
        log.info("Validando canje/cupón de beneficio");
        CanjeaCuponResponse response = cuponBeneficioServices.validaCanjeCuponBeneficio(new CanjeaCuponRequest(codigoCuponEncriptado));
        String url = "validacionCupon.html"; 
        ModelAndView model = new ModelAndView("redirect:"+url);
        if(response!=null && response.getValidacion()!=null && "0".equals(response.getValidacion().getCodigo())
           && "0".equals(response.getValidacion().getCodigoNegocio())){
            url = "validacionCanjeCuponPOS.html";//direccionamos para no dejar datos en URL de código encriptado
            usuarioSession.setCodigoCuponEncriptado(codigoCuponEncriptado);
            model = new ModelAndView("redirect:"+url);
            model.addObject("listaSucursal", response.getSucursales());
            return validacionCanjeCuponPOS(model, session);
        }
        else {
            log.info("Seteando mensaje de validación");
            usuarioSession.getValidacion().setMensaje(response.getValidacion().getMensaje());
        }    
        log.info("redireccionando a ->{}",url);
        log.info("FIN");
        return model;
    }
    
    @RequestMapping(value = "/validacionCanjeCuponPOS.html", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public ModelAndView validacionCanjeCuponPOS(ModelAndView model,HttpSession session) {
        log.info("INICIO");
//        ModelAndView modelAndView = new ModelAndView("login");
//        modelAndView.addObject("validaCuponForm", new ValidaCuponForm());
//      
        if(model!=null && model.getModel()!=null && model.getModel().get("listaSucursal")!=null){
            List<SucursalProveedor> lista = (List<SucursalProveedor>)model.getModel().get("listaSucursal");
            if(lista!=null){
                log.info("lista sucursal size ->{}",lista.size()); 
               log.info("lista sucursal ->{}",lista.toString()); 
            }
        }
        log.info("setViewName ->canjeCupon");
        model.setViewName("canjeCupon");
        model.addObject("validaCuponForm", new ValidaCuponForm());
        
        log.info("FIN");
        return model;
    }
    
     @RequestMapping(value="validacionCanjeCuponPOS.html", method=RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String validacionCanjeCuponPOS(@ModelAttribute("validaCuponForm") ValidaCuponForm validaCuponForm, HttpSession session){
        log.info("INICIO");
        log.info("datos ->{}",validaCuponForm.toString());
        ValidacionCuponPOSResponse response = new ValidacionCuponPOSResponse();
        response.setValidacion(new Validacion("0", "1", "Problemas al validar cupon beneficio en POS"));
        if(validaCuponForm.getIdVendedor()!=null && validaCuponForm.getPasswordSucursal()!=null && validaCuponForm.getIdDireccionSucursal()!=null){
            response =  cuponBeneficioServices.validacionCuponPOS(new ValidacionCuponPOSRequest(usuarioSession.getCodigoCuponEncriptado(), validaCuponForm.getIdVendedor(), validaCuponForm.getIdDireccionSucursal(), validaCuponForm.getPasswordSucursal()));
        }
        else{
            response.setValidacion(new Validacion("0", "1", "Favor completar datos para validar cupon beneficio en POS"));
        }
        String respJson =  new Gson().toJson(response);
        log.info("FIN");
        return respJson;
    }
}
