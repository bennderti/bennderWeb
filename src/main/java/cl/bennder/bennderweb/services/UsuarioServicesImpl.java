/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.services;

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
    CuponBeneficioServices cuponBeneficioServices;
    
    private static final Logger log = LoggerFactory.getLogger(UsuarioServicesImpl.class);
    //private static final String URL_VALIDACION_USUARIO = "login";

    @Override
    public ValidacionResponse recuperacionPassword(RecuperacionPasswordRequest request) {
        return RestConnector.recuperacionPassword(request);
    }    
    
    @Override
    public LoginResponse validacionUsuario(LoginRequest request) {
        LoginResponse response = new LoginResponse();
        response.getValidacion().setCodigo("NOK");
        response.getValidacion().setMensaje("Problemas al validar usuario");
        log.info("INICIO");
        try {
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
