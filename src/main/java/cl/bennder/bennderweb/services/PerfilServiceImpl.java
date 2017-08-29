/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.services;

import cl.bennder.bennderweb.constantes.URLServiciosBennder;
import cl.bennder.bennderweb.properties.Properties;
import cl.bennder.bennderweb.rest.connector.RestConnector;
import cl.bennder.bennderweb.session.PerfilSession;
import cl.bennder.bennderweb.session.UsuarioSession;
import cl.bennder.entitybennderwebrest.model.Comuna;
import cl.bennder.entitybennderwebrest.request.DatosPerfilRequest;
import cl.bennder.entitybennderwebrest.request.InfoDatosPerfilRequest;
import cl.bennder.entitybennderwebrest.request.InfoInicioSucursalRequest;
import cl.bennder.entitybennderwebrest.request.InfoSucursalRequest;
import cl.bennder.entitybennderwebrest.request.SucursalesRequest;
import cl.bennder.entitybennderwebrest.response.DatosPerfilResponse;
import cl.bennder.entitybennderwebrest.response.InfoDatosPerfilResponse;
import cl.bennder.entitybennderwebrest.response.InfoInicioSucursalResponse;
import cl.bennder.entitybennderwebrest.response.InfoSucursalResponse;
import cl.bennder.entitybennderwebrest.response.SucursalesResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ext_dayanez
 */
@Service
public class PerfilServiceImpl implements PerfilService{

    @Autowired
    private PerfilSession perfilSession;
    
    @Autowired
    private UsuarioSession usuarioSession;
    
    
    @Override
    public DatosPerfilResponse getDatosPerfil(DatosPerfilRequest request) {
        return RestConnector.clientRestGeneric(Properties.URL_SERVIDOR + URLServiciosBennder.URL_GET_DATOS_PERFIL, request, DatosPerfilResponse.class, usuarioSession.getToken());
    }

    @Override
    public InfoDatosPerfilResponse guardarDatosPerfil(InfoDatosPerfilRequest request) {
        return RestConnector.clientRestGeneric(Properties.URL_SERVIDOR + URLServiciosBennder.URL_GUARDAR_DATOS_PERFIL, request, InfoDatosPerfilResponse.class, usuarioSession.getToken());
    }

//    @Override
//    public SucursalesResponse getSucursalesProveedor(SucursalesRequest request) {
//        return RestConnector.clientRestGeneric(Properties.URL_SERVIDOR + URLServiciosBennderB2B.URL_SUCURSALES_PROVEEDOR, request, SucursalesResponse.class, usuarioSession.getToken());
//    }
    
    

    @Override
    public List<Comuna> getComunasByRegion(Integer idRegion) {
        List<Comuna> comunas = new ArrayList<>();
        if(perfilSession.getComunas()!=null){        
            for(Comuna c:perfilSession.getComunas()){
                if(c.getRegion()!=null && c.getRegion().getIdRegion()!=null && c.getRegion().getIdRegion().compareTo(idRegion) == 0){
                    comunas.add(c);
                }
            }
        }        
        return comunas;
        
    }
    
    
    
}
