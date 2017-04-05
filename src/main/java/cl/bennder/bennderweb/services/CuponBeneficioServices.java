/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.services;

import cl.bennder.entitybennderwebrest.request.GeneraCuponQrRequest;
import cl.bennder.entitybennderwebrest.response.GeneraCuponQrResponse;

/**
 *
 * @author dyanez
 */
public interface CuponBeneficioServices {
    /***
     * Método que genera cupon con código QR e información de beneficio
     * @param request información de código de beneficio
     * @author dyanez
     * @return 
     */
    public GeneraCuponQrResponse generaCuponQR(GeneraCuponQrRequest request);
}
