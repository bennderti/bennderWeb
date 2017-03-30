package cl.bennder.bennderweb.services;

import cl.bennder.bennderweb.constantes.URLServiciosBennder;
import cl.bennder.bennderweb.properties.Properties;
import cl.bennder.bennderweb.rest.connector.RestConnector;
import cl.bennder.entitybennderwebrest.request.BeneficioRequest;
import cl.bennder.entitybennderwebrest.response.BeneficioResponse;
import org.springframework.stereotype.Service;

/**
 * Created by Diego on 29-03-2017.
 */
@Service
public class BeneficioServicesImpl implements BeneficioServices {

    @Override
    public BeneficioResponse obtenerDetalleBeneficio(BeneficioRequest request) {
        return RestConnector.clientRestGeneric(Properties.URL_SERVIDOR + URLServiciosBennder.URL_OBTENER_DETALLE_BENEFICIO, request, BeneficioResponse.class);
    }
}
