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
import cl.bennder.entitybennderwebrest.request.CargarHomeRequest;
import cl.bennder.entitybennderwebrest.response.CargarHomeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marcos
 */
@Service
public class HomeServicesImpl implements HomeServices {
    
    private static final Logger log = LoggerFactory.getLogger(HomeServicesImpl.class);
    
    @Autowired
    private UsuarioSession usuarioSession;
    
    /**
     * Método para obtener toda la informaciòn a cargar en el home
     * MG - 9.4.2017
     * @param request usuario
     * @return response lista de categorías, beneficios preferenciales, ùltimos vistos, tendencias, publicidad
     */    
    public CargarHomeResponse cargarHome(CargarHomeRequest request) {
        CargarHomeResponse response =  new CargarHomeResponse();
        response.getValidacion().setCodigo("NOK");
        response.getValidacion().setMensaje("Problemas al obtener categorías");
        log.info("INICIO");
        
        try{
            response = RestConnector.clientRestGeneric(Properties.URL_SERVIDOR + URLServiciosBennder.URL_HOME_CARGAR_HOME, request, CargarHomeResponse.class, usuarioSession.getToken());
            
            if(response == null){
                response = new CargarHomeResponse();
                response.getValidacion().setCodigo("NOK");
                response.getValidacion().setMensaje("Problemas al obtener información para el home");
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
