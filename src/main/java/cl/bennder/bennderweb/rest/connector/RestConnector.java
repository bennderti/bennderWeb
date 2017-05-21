/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.rest.connector;

import cl.bennder.bennderweb.constantes.URLServiciosBennder;
import cl.bennder.bennderweb.multitenancy.TenantContext;
import cl.bennder.bennderweb.properties.Properties;
import cl.bennder.entitybennderwebrest.request.*;
import cl.bennder.entitybennderwebrest.response.BeneficiosCargadorResponse;
import cl.bennder.entitybennderwebrest.response.CanjeaCuponResponse;
import cl.bennder.entitybennderwebrest.response.CargarHomeResponse;
import cl.bennder.entitybennderwebrest.response.CategoriasResponse;
import cl.bennder.entitybennderwebrest.response.DatosGeneralProveedorResponse;
import cl.bennder.entitybennderwebrest.response.GeneraCuponQrResponse;
import cl.bennder.entitybennderwebrest.response.GetCuponBeneficioResponse;
import cl.bennder.entitybennderwebrest.response.LoginResponse;
import cl.bennder.entitybennderwebrest.response.ProveedoresResponse;
import cl.bennder.entitybennderwebrest.response.SubCategoriaProveedorResponse;
import cl.bennder.entitybennderwebrest.response.UploadBeneficioImagenResponse;
import cl.bennder.entitybennderwebrest.response.ValidacionCuponPOSResponse;
import cl.bennder.entitybennderwebrest.response.ValidacionResponse;
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
    private static final String AUTHENTICATION = "Authorization";
    private static final String TENANT_HEADER_NAME = "X-TENANT-ID";

    public static <Q, R> R clientRestGeneric( String url, Q query, Class<R> responseClass, String token) {
        LOG.info("INICIO");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(AUTHENTICATION, token);
        headers.set(TENANT_HEADER_NAME, TenantContext.getCurrentTenant());

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
        LOG.info("FIN");
        return response;
    }
    
    
}
