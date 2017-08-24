package cl.bennder.bennderweb.services;

import cl.bennder.bennderweb.constantes.URLServiciosBennder;
import cl.bennder.bennderweb.properties.Properties;
import cl.bennder.bennderweb.rest.connector.RestConnector;
import cl.bennder.bennderweb.session.UsuarioSession;
import cl.bennder.entitybennderwebrest.request.BeneficioRequest;
import cl.bennder.entitybennderwebrest.request.BusquedaRequest;
import cl.bennder.entitybennderwebrest.request.GetCuponBeneficioRequest;
import cl.bennder.entitybennderwebrest.response.BeneficioResponse;
import cl.bennder.entitybennderwebrest.response.BusquedaResponse;
import cl.bennder.entitybennderwebrest.response.GetCuponBeneficioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Diego on 29-03-2017.
 */
@Service
public class BeneficioServicesImpl implements BeneficioServices {

    @Autowired
    UsuarioSession usuarioSession;

    @Override
    public GetCuponBeneficioResponse getCuponBeneficio(GetCuponBeneficioRequest request) {
        return RestConnector.clientRestGeneric(Properties.URL_SERVIDOR + URLServiciosBennder.URL_BENEFICIO_GET_CUPON_BENEFICIO, request, GetCuponBeneficioResponse.class, usuarioSession.getToken());
    }

    
    
    @Override
    public BeneficioResponse obtenerDetalleBeneficio(BeneficioRequest request) {
        return RestConnector.clientRestGeneric(Properties.URL_SERVIDOR + URLServiciosBennder.URL_OBTENER_DETALLE_BENEFICIO, request, BeneficioResponse.class, usuarioSession.getToken());
    }

    @Override
    public BusquedaResponse obtenerBeneficiosPorBusqueda(BusquedaRequest request) {
        return RestConnector.clientRestGeneric(Properties.URL_SERVIDOR + URLServiciosBennder.URL_BENEFICIO_BUSCAR_BENEFICIOS, request, BusquedaResponse.class, usuarioSession.getToken());
    }
    
    
}
