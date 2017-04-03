/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.services;

import cl.bennder.bennderweb.rest.connector.RestConnector;
import cl.bennder.entitybennderwebrest.request.GeneraCuponQrRequest;
import cl.bennder.entitybennderwebrest.response.GeneraCuponQrResponse;
import org.springframework.stereotype.Service;

/**
 *
 * @author dyanez
 */
@Service
public class CuponBeneficioServicesImpl implements CuponBeneficioServices{

    @Override
    public GeneraCuponQrResponse generaCuponQR(GeneraCuponQrRequest request) {
        return RestConnector.generaCuponQR(request);
    }
    
}
