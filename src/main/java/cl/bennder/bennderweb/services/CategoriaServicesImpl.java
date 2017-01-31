/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.services;

import cl.bennder.bennderweb.constantes.URLServiciosBennder;
import cl.bennder.bennderweb.properties.Properties;
import cl.bennder.bennderweb.rest.connector.RestConnector;
import cl.bennder.bennderweb.rest.request.CategoriasRequest;
import cl.bennder.bennderweb.rest.response.CategoriasResponse;
import cl.bennder.bennderweb.rest.response.LoginResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CategoriaServicesImpl implements CategoriaServices{

    private static final Logger log = LoggerFactory.getLogger(CategoriaServicesImpl.class);
    
    
    @Override
    public CategoriasResponse getCategorias() {
        CategoriasResponse response = new CategoriasResponse();
        response.getValidacion().setCodigo("NOK");
        response.getValidacion().setMensaje("Problemas al obtener categorías");
        log.info("INICIO");
        try {
            CategoriasRequest request = new CategoriasRequest();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<CategoriasRequest> req = new HttpEntity<>(request, headers);

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            log.info("URL services: {} ",(Properties.URL_SERVIDOR + URLServiciosBennder.URL_GET_CATEGORIAS));
             ResponseEntity<CategoriasResponse> resp = restTemplate.exchange(Properties.URL_SERVIDOR + URLServiciosBennder.URL_GET_CATEGORIAS, HttpMethod.POST, req, CategoriasResponse.class);
            response = resp.getBody();
            
            //response = RestConnector.getCategorias(new CategoriasRequest());
            if(response == null){
                response = new CategoriasResponse();
                response.getValidacion().setCodigo("NOK");
                response.getValidacion().setMensaje("Problemas al obtener categorías");
                log.info("INICIO");
            }
        } catch (Exception e) {
            log.error("[Exception] Error al obtener categorías", e);
            response.getValidacion().setCodigo("NOK");
            response.getValidacion().setMensaje("Error al obtener categorías");
        }
        log.info("FIN");
        return response;
    }
 
}
