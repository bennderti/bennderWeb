package cl.bennder.bennderweb.services;

import cl.bennder.entitybennderwebrest.request.BeneficioRequest;
import cl.bennder.entitybennderwebrest.response.BeneficioResponse;

/**
 * Created by Diego on 29-03-2017.
 */
public interface BeneficioServices {

    BeneficioResponse obtenerDetalleBeneficio(BeneficioRequest request);
}
