/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.services;

import cl.bennder.bennderweb.controller.HomeController;
import cl.bennder.bennderweb.properties.Properties;
import cl.bennder.bennderweb.rest.connector.RestConnector;
import cl.bennder.entitybennderwebrest.request.LoginRequest;
import cl.bennder.entitybennderwebrest.request.RecuperacionPasswordRequest;
import cl.bennder.entitybennderwebrest.response.LoginResponse;
import cl.bennder.entitybennderwebrest.response.ValidacionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author dyanez
 */
@Service
public class UsuarioServicesImpl implements UsuarioServices{
    
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
