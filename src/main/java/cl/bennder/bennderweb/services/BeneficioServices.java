package cl.bennder.bennderweb.services;

import cl.bennder.entitybennderwebrest.request.BeneficioRequest;
import cl.bennder.entitybennderwebrest.request.BusquedaRequest;
import cl.bennder.entitybennderwebrest.request.GetCuponBeneficioRequest;
import cl.bennder.entitybennderwebrest.response.BeneficioResponse;
import cl.bennder.entitybennderwebrest.response.BusquedaResponse;
import cl.bennder.entitybennderwebrest.response.GetCuponBeneficioResponse;

/**
 * Created by Diego on 29-03-2017.
 */
public interface BeneficioServices {

    BeneficioResponse obtenerDetalleBeneficio(BeneficioRequest request);
    
    /***
     * Registra acción y envía correo a usuario de beneficio seleccionado
     * @param request Datos de usuario y beneficio
     * @return Respuesta de validación d eobtención de beneficio
     * @author dyanez
     */
    public GetCuponBeneficioResponse getCuponBeneficio(GetCuponBeneficioRequest request);
    
    /**
     * Busqueda de beneficios
     * @param request
     * @return Respuesta de beneficios encontrados
     * @author mgutierrez
     */
    public BusquedaResponse obtenerBeneficiosPorBusqueda(BusquedaRequest request);
}
