/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.services;

import cl.bennder.bennderweb.constantes.GoToUrl;
import cl.bennder.bennderweb.constantes.URLServiciosBennder;
import cl.bennder.bennderweb.properties.Properties;
import cl.bennder.bennderweb.session.UsuarioSession;
import cl.bennder.bennderweb.rest.connector.RestConnector;
import cl.bennder.bennderweb.util.UtilBennderWeb;
import cl.bennder.entitybennderwebrest.request.CanjeaCuponRequest;
import cl.bennder.entitybennderwebrest.request.GeneraCuponQrRequest;
import cl.bennder.entitybennderwebrest.request.ValidacionCuponPOSRequest;
import cl.bennder.entitybennderwebrest.response.CanjeaCuponResponse;
import cl.bennder.entitybennderwebrest.response.GeneraCuponQrResponse;
import cl.bennder.entitybennderwebrest.response.ValidacionCuponPOSResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dyanez
 */
@Service
public class CuponBeneficioServicesImpl implements CuponBeneficioServices{
    
    @Autowired
    private UsuarioSession usuarioSession;
    
    private static final Logger log = LoggerFactory.getLogger(CuponBeneficioServicesImpl.class);

    @Override
    public ValidacionCuponPOSResponse validacionCuponPOS(ValidacionCuponPOSRequest request) {
        return RestConnector.clientRestGenericUrlIgnoring(Properties.URL_SERVIDOR + URLServiciosBennder.URL_BENEFICIO_VALIDA_CUPON_POS, request, ValidacionCuponPOSResponse.class, usuarioSession.getTenantId());
    }

    
    
    @Override
    public CanjeaCuponResponse validaCanjeCuponBeneficio(CanjeaCuponRequest request) {
        return RestConnector.clientRestGenericUrlIgnoring(Properties.URL_SERVIDOR + URLServiciosBennder.URL_BENEFICIO_GET_VALIDA_CANJEA_CUPON, request, CanjeaCuponResponse.class, usuarioSession.getTenantId());
    }
    
    @Override
    public GeneraCuponQrResponse generaCuponQR(GeneraCuponQrRequest request) {
        return RestConnector.clientRestGeneric(Properties.URL_SERVIDOR + URLServiciosBennder.URL_BENEFICIO_GENERAR_CUPON_QR, request, GeneraCuponQrResponse.class, usuarioSession.getToken());
    }

   @Override
    public String validaLinkExternoCupon(HttpSession session) {
        log.info("inicio");
        
        String url = "index.html";
        log.info("Validando si cliente ha pinchado link para generación de cupon QR desde mail");
        //.- se consume servicio de generacion de cupon QR
        //.- si es ok, se redire a url para descagar pdf en brower
        //.- sino, se envia mensaje a url validacion cupon
        try {
            //if(usuarioSession!=null && usuarioSession.getIdUsuario()!=null){
                String mensajeLog = "[IdUsuario -> "+usuarioSession.getUsuario()+"]";
                log.info("{} Usuario ha pinchado en link de correo enviado con información de cupón, por tanto ahora validando",mensajeLog);
                //.- se consume servicio de generacion de cupon QR
                //.- si es ok, se redire a url para descagar pdf en brower
                //.- sino, se envia mensaje a url validacion cupon
                GeneraCuponQrResponse gResponse = this.generaCuponQR(new GeneraCuponQrRequest(usuarioSession.getCodigoCuponEncriptado()));
                if(gResponse!=null && gResponse.getValidacion()!=null){
                    if("0".equals(gResponse.getValidacion().getCodigo()) && "0".equals(gResponse.getValidacion().getCodigoNegocio()) 
                       && gResponse.getCuponPdf()!=null){
                        log.info("{} Ahora redireccionado par generar cupón en browser",mensajeLog);
                        session.setAttribute("cuponPdf", gResponse.getCuponPdf());
                        url = ".."+GoToUrl.URL_DOWNLOAD_CUPON_PDF;
                    }
                    else{
                        log.info("{} Respuesta de generación cupón ->{}",mensajeLog,gResponse.getValidacion().getMensaje());
                        usuarioSession.getValidacion().setMensaje(gResponse.getValidacion().getMensaje()); 
                        url = GoToUrl.URL_VALIDACION_CUPON;
                    }
                }
                else{
                    log.info("{} Problemas al generar código QR de beneficio",mensajeLog);
                    usuarioSession.getValidacion().setMensaje("Problemas al generar código QR de beneficio");
                    url = GoToUrl.URL_VALIDACION_CUPON;
                }
                usuarioSession.setCodigoCuponEncriptado(null);
//            }
//            else{
//                log.info("Usuario no ha iniciado sesión, se redigige a login");
//            }
            
        } catch (Exception e) {
            log.error("Error en validaLinkGeneraCuponQr",e);
        }
        log.info("inicio");
        return url;
    }
    
    
    
}
