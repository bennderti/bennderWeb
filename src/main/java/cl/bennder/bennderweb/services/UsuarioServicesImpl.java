/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.services;

import cl.bennder.bennderweb.constantes.URLServiciosBennder;
import cl.bennder.bennderweb.properties.Properties;
import cl.bennder.bennderweb.rest.connector.RestConnector;
import cl.bennder.bennderweb.session.UsuarioSession;
import cl.bennder.entitybennderwebrest.request.CambioPasswordRequest;
import cl.bennder.entitybennderwebrest.request.LoginRequest;
import cl.bennder.entitybennderwebrest.request.RecuperacionPasswordRequest;
import cl.bennder.entitybennderwebrest.response.CambioPasswordResponse;
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
    UsuarioSession usuarioSession;

    @Autowired
    CuponBeneficioServices cuponBeneficioServices;
    
    private static final Logger log = LoggerFactory.getLogger(UsuarioServicesImpl.class);
    //private static final String URL_VALIDACION_USUARIO = "login";

    @Override
    public ValidacionResponse recuperacionPassword(RecuperacionPasswordRequest request) {
        return RestConnector.clientRestGenericUrlIgnoring(Properties.URL_SERVIDOR + URLServiciosBennder.URL_MAIL_RECUPERACION_PASSWORD, request, ValidacionResponse.class, usuarioSession.getTenantId());
    }    
    @Override
    public CambioPasswordResponse cambioPassword(CambioPasswordRequest request) {
       return RestConnector.clientRestGeneric(Properties.URL_SERVIDOR + URLServiciosBennder.URL_CAMBIO_PASSWORD, request, CambioPasswordResponse.class, usuarioSession.getToken());
    }
    
    @Override
    public LoginResponse validacionUsuario(LoginRequest request) {
        LoginResponse response = new LoginResponse();
        response.getValidacion().setCodigo("NOK");
        response.getValidacion().setMensaje("Problemas al validar usuario");
        log.info("INICIO");
        try {
            response = RestConnector.clientRestGeneric(Properties.URL_SERVIDOR + URLServiciosBennder.URL_VALIDACION_USUARIO, request, LoginResponse.class, usuarioSession.getToken());
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
