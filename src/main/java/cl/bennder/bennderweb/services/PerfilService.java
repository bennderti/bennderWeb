/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.services;

import cl.bennder.entitybennderwebrest.model.Comuna;
import cl.bennder.entitybennderwebrest.request.DatosPerfilRequest;
import cl.bennder.entitybennderwebrest.request.InfoDatosPerfilRequest;
import cl.bennder.entitybennderwebrest.response.DatosPerfilResponse;
import cl.bennder.entitybennderwebrest.response.InfoDatosPerfilResponse;
import java.util.List;

/**
 *
 * @author ext_dayanez
 */
public interface PerfilService {
    
    
    public DatosPerfilResponse getDatosPerfil(DatosPerfilRequest request);
    
    public List<Comuna> getComunasByRegion(Integer idRegion);
    
    public InfoDatosPerfilResponse guardarDatosPerfil(InfoDatosPerfilRequest request);
    
//    public SucursalesResponse getSucursalesProveedor(SucursalesRequest request);
    
}
