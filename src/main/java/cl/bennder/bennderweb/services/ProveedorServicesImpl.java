/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.services;

import cl.bennder.bennderweb.rest.connector.RestConnector;
import cl.bennder.entitybennderwebrest.request.ProveedorIdRequest;
import cl.bennder.entitybennderwebrest.response.CategoriasResponse;
import cl.bennder.entitybennderwebrest.response.ProveedoresResponse;
import org.springframework.stereotype.Service;

/**
 *
 * @author dyanez
 */
@Service
public class ProveedorServicesImpl implements ProveedorServices{

    @Override
    public CategoriasResponse obtenerCategoriaByProveedor(ProveedorIdRequest request) {
        return RestConnector.obtenerCategoriaByProveedor(request);
    }

    @Override
    public ProveedoresResponse obtenerProveedorHabilitados(ProveedorIdRequest request) {
        return RestConnector.obtenerProveedorHabilitados(request);
    }
    
}
