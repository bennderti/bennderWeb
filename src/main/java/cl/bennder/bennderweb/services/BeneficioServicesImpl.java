package cl.bennder.bennderweb.services;

import cl.bennder.bennderweb.constantes.URLServiciosBennder;
import cl.bennder.bennderweb.properties.Properties;
import cl.bennder.bennderweb.rest.connector.RestConnector;
import cl.bennder.bennderweb.session.UsuarioSession;
import cl.bennder.entitybennderwebrest.request.BeneficioRequest;
import cl.bennder.entitybennderwebrest.request.GetCuponBeneficioRequest;
import cl.bennder.entitybennderwebrest.response.BeneficioResponse;
import cl.bennder.entitybennderwebrest.response.GetCuponBeneficioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Diego on 29-03-2017.
 */
@Service
public class BeneficioServicesImpl implements BeneficioServices {

    @Override
    public GetCuponBeneficioResponse getCuponBeneficio(GetCuponBeneficioRequest request) {
        return RestConnector.getCuponBeneficio(request);
    }

    
    
    @Override
    public BeneficioResponse obtenerDetalleBeneficio(BeneficioRequest request) {
        return RestConnector.clientRestGeneric(Properties.URL_SERVIDOR + URLServiciosBennder.URL_OBTENER_DETALLE_BENEFICIO, request, BeneficioResponse.class);
    }
}
