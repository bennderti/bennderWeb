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
import cl.bennder.entitybennderwebrest.request.BienvenidoRequest;
import cl.bennder.entitybennderwebrest.request.GuardarDatosBienvenidaRequest;
import cl.bennder.entitybennderwebrest.response.BienvenidoResponse;
import cl.bennder.entitybennderwebrest.response.GuardarDatosBienvenidaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marcos
 */
@Service
public class BienvenidoServicesImpl implements BienvenidoServices{
    
    @Autowired
    UsuarioSession usuarioSession;
    
    @Override
    public BienvenidoResponse obtenerDatosBienvenida(BienvenidoRequest request) {
        return RestConnector.clientRestGeneric(Properties.URL_SERVIDOR + URLServiciosBennder.URL_OBTENER_DATOS_BIENVENIDA, request, BienvenidoResponse.class, usuarioSession.getToken());
    }

    @Override
    public GuardarDatosBienvenidaResponse guardarDatosBienvenida(GuardarDatosBienvenidaRequest request) {
        return RestConnector.clientRestGeneric(Properties.URL_SERVIDOR + URLServiciosBennder.URL_GUARDAR_DATOS_BIENVENIDA, request, GuardarDatosBienvenidaResponse.class, usuarioSession.getToken());
    }  
}
