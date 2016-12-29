/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.services;

import cl.bennder.bennderweb.controller.HomeController;
import cl.bennder.bennderweb.rest.request.LoginRequest;
import cl.bennder.bennderweb.rest.response.LoginResponse;
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
    private static final String URL_VALIDACION_USUARIO = "http://localhost:9090/Bennder/services/login";
    
    

    @Override
    public LoginResponse validacionUsuario(LoginRequest request) {
        LoginResponse response = new LoginResponse();
        response.getValidacion().setCodigo("NOK");
        response.getValidacion().setMensaje("Problemas al validar usuario");
        log.info("INICIO");
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<LoginRequest> req = new HttpEntity<>(request, headers);

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            ResponseEntity<LoginResponse> resp = restTemplate.exchange(URL_VALIDACION_USUARIO, HttpMethod.POST, req, LoginResponse.class);
            response = resp.getBody();
        } catch (Exception e) {
            log.error("[Exception] Error validacion de usuario", e);
            response.getValidacion().setCodigo("NOK");
            response.getValidacion().setMensaje("Error al validar usuario");
        }
        log.info("FIN");
        return response;
        
        
        
    }
    
}
