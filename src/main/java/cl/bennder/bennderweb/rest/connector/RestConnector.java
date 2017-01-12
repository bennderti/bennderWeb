/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.rest.connector;

import cl.bennder.bennderweb.constantes.URLServiciosBennder;
import cl.bennder.bennderweb.model.Validacion;
import cl.bennder.bennderweb.properties.Properties;
import cl.bennder.bennderweb.rest.request.LoginRequest;
import cl.bennder.bennderweb.rest.response.LoginResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author dyanez
 */
public class RestConnector {
    private static final Logger LOG = LoggerFactory.getLogger(RestConnector.class);
    
    public static LoginResponse validacionUsuario( final LoginRequest query ) {
        return clientRestGeneric(Properties.URL_SERVIDOR  + URLServiciosBennder.URL_VALIDACION_USUARIO, query, LoginResponse.class);
    }
    
    private static <Q, R> R clientRestGeneric( String url, Q query, Class<R> responseClass ) {
        LOG.info("INICIO");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Q> req = new HttpEntity<>(query, headers);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        LOG.info("URL->{} ", url);
        
        ResponseEntity<R> callResult = restTemplate.exchange(url, HttpMethod.POST, req, responseClass);

        if ( callResult == null ) {
            LOG.error("Sin respuesta de servicio REST (ResponseEntity)");
            return null;
        }

        R response = callResult.getBody();
        if ( response == null ) {
            LOG.error("Sin respuesta de servicio REST (getBody)");
            return null;
        }

        Validacion validacion = null;

        // Search all the methods for a repuesta
        for ( Method method : response.getClass().getDeclaredMethods() ) {
            // If the method is public, without params and giving back a Repuesta
            if ( Modifier.isPublic(method.getModifiers())
                 && ( method.getParameterTypes().length == 0 )
                 && method.getReturnType().equals(Validacion.class) ) {
                // We should have it
                try {
                    validacion = (Validacion) method.invoke(response);
                    break;
                }
                catch ( IllegalAccessException | InvocationTargetException ignored ) {
                    // Simply skip this method
                }
            }
        }

        if ( validacion == null ) {
            LOG.error("Sin respuesta servicio REST (validacion)");
            return null;
        }
        if ( "0".compareTo(validacion.getCodigo()) != 0) {
            LOG.error("Respuesta NOK, mensaje->{}", validacion.getMensaje());
            return null;
        }
        LOG.info("FIN");
        return response;
    }
}