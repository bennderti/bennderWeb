/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.services;

import cl.bennder.bennderweb.model.UsuarioSession;
import cl.bennder.bennderweb.rest.connector.RestConnector;
import cl.bennder.entitybennderwebrest.request.LoginRequest;
import cl.bennder.entitybennderwebrest.request.RecuperacionPasswordRequest;
import cl.bennder.entitybennderwebrest.response.LoginResponse;
import cl.bennder.entitybennderwebrest.response.ValidacionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dyanez
 */
@Service
public class UsuarioServicesImpl implements UsuarioServices{
    
    @Autowired
    private UsuarioSession usuarioSession;
    
    private static final Logger log = LoggerFactory.getLogger(UsuarioServicesImpl.class);
    //private static final String URL_VALIDACION_USUARIO = "login";

    @Override
    public ValidacionResponse recuperacionPassword(RecuperacionPasswordRequest request) {
        return RestConnector.recuperacionPassword(request);
    }

//    @Override
//    public String goToUrl(HttpSession session) {
//        String url = "index.html";
//        
//        if(usuarioSession!=null && usuarioSession.getCodigoCuponEncriptado()!=null){
//            log.info("{} Usuario ha pinchado en link de correo enviado con información de cupón, por tanto ahora validando",mensajeLog);
//            //.- se consume servicio de generacion de cupon QR
//            //.- si es ok, se redire a url para descagar pdf en brower
//            //.- sino, se envia mensaje a url validacion cupon
//            GeneraCuponQrResponse gResponse = cuponBeneficioServices.generaCuponQR(new GeneraCuponQrRequest(usuarioSession.getCodigoCuponEncriptado(), usuarioSession.getIdUsuario()));
//            if(gResponse!=null && gResponse.getValidacion()!=null){
//                if("0".equals(gResponse.getValidacion().getCodigo()) && "0".equals(gResponse.getValidacion().getCodigoNegocio()) 
//                   && gResponse.getCuponPdf()!=null){
//                    log.info("{} Ahora redireccionado par generar cuppon en browser",mensajeLog);
//                    session.setAttribute("cuponPdf", gResponse.getCuponPdf());
//                    url = GoToUrl.URL_DOWNLOAD_CUPON_PDF;
//                }
//                else{
//                    log.info("{} Respuesta de generación cupon ->{}",mensajeLog,gResponse.getValidacion().getMensaje());
//                    usuarioSession.getValidacion().setMensaje(gResponse.getValidacion().getMensaje());
//                    url = GoToUrl.URL_VALIDACION_CUPON;
//                }
//            }
//            else{
//                log.info("{} Problemas al generar código QR de beneficio",mensajeLog);
//                usuarioSession.getValidacion().setMensaje("Problemas al generar código QR de beneficio");
//                //rBody.setGoToUrl(GoToUrl.URL_VALIDACION_CUPON);
//                url = GoToUrl.URL_VALIDACION_CUPON;
//            }
//            usuarioSession.setCodigoCuponEncriptado(null);
//        }
//        else{
//            if(response.getIdEstadoUsuario() == 1){
//                url = GoToUrl.URL_BIENVENIDO;
//            }
//            else{
//                url = GoToUrl.URL_HOME;
//            }
//        }
//    }
     
    
    
    @Override
    public LoginResponse validacionUsuario(LoginRequest request) {
        LoginResponse response = new LoginResponse();
        response.getValidacion().setCodigo("NOK");
        response.getValidacion().setMensaje("Problemas al validar usuario");
        log.info("INICIO");
        try {
            /*
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<LoginRequest> req = new HttpEntity<>(request, headers);

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            log.info("URL services: {} ",(Properties.URL_SERVIDOR + URL_VALIDACION_USUARIO));
            ResponseEntity<LoginResponse> resp = restTemplate.exchange(Properties.URL_SERVIDOR + URL_VALIDACION_USUARIO, HttpMethod.POST, req, LoginResponse.class);
            response = resp.getBody();*/
            response = RestConnector.validacionUsuario(request);
            if(response == null){
                response = new LoginResponse();
                response.getValidacion().setCodigo("NOK");
                response.getValidacion().setMensaje("Problemas al validar usuario contra servidor");
                log.info("INICIO");
            }
        } catch (Exception e) {
            log.error("[Exception] Error validacion de usuario", e);
            response.getValidacion().setCodigo("NOK");
            response.getValidacion().setMensaje("Error al validar usuario");
        }
        log.info("FIN");
        return response;
    }
    
}
