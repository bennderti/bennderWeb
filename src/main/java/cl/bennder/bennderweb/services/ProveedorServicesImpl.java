/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.services;

import cl.bennder.bennderweb.rest.connector.RestConnector;
import cl.bennder.bennderweb.session.ProveedorSession;
import cl.bennder.entitybennderwebrest.model.Proveedor;
import cl.bennder.entitybennderwebrest.request.DatosGeneralProveedorRequest;
import cl.bennder.entitybennderwebrest.request.ProveedorIdRequest;
import cl.bennder.entitybennderwebrest.response.CategoriasResponse;
import cl.bennder.entitybennderwebrest.response.DatosGeneralProveedorResponse;
import cl.bennder.entitybennderwebrest.response.ProveedoresResponse;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dyanez
 */
@Service
public class ProveedorServicesImpl implements ProveedorServices{

    private static final Logger log = LoggerFactory.getLogger(ProveedorServicesImpl.class);
    
    @Autowired
    private ProveedorSession proveedorSession;

    @Override
    public DatosGeneralProveedorResponse guardaDatosGeneralesProveedor(DatosGeneralProveedorRequest request) {
        return RestConnector.guardaDatosGeneralesProveedor(request);
    }

    
    
    @Override
    public Proveedor getProveedorByIdLista(List<Proveedor> lista, Integer idProveedor) {
        Proveedor proveedor = null;
        if(lista!=null && lista.size() > 0){
            for(Proveedor p : lista){
                if(p.getIdProveedor().compareTo(idProveedor) == 0){
                    log.info("Se ha encontrado proveedor según id ->{}",idProveedor);
                    return p;
                }
            }
        }
        return proveedor;
    }
    
    
    @Override
    public CategoriasResponse obtenerCategoriaByProveedor(ProveedorIdRequest request) {
        return RestConnector.obtenerCategoriaByProveedor(request);
    }

    @Override
    public ProveedoresResponse obtenerProveedorHabilitados(ProveedorIdRequest request) {
        return RestConnector.obtenerProveedorHabilitados(request);
    }

    @Override
    public List<Proveedor> getProveedoreSessionServices() {
        List<Proveedor> lista = null;
        if(proveedorSession!=null && proveedorSession.getLista()!=null){
            log.info("obteniendo proveedores de capa de session");
            lista = proveedorSession.getLista();
        }
        else{
            log.info("obteniendo proveedores de capa de servicio");
            lista = this.obtenerProveedorHabilitados(new ProveedorIdRequest()).getProveedores();
            proveedorSession.setLista(lista);
        }
        return lista;
    }
    
    
    
}
