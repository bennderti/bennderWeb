/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.services;

import cl.bennder.entitybennderwebrest.request.CanjeaCuponRequest;
import cl.bennder.entitybennderwebrest.request.GeneraCuponQrRequest;
import cl.bennder.entitybennderwebrest.response.CanjeaCuponResponse;
import cl.bennder.entitybennderwebrest.response.GeneraCuponQrResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dyanez
 */
public interface CuponBeneficioServices {
    
    
    /***
     * Método que permite consumir servicio para validar canje o hacer efectivo el cupón de beneficio, cmbiando estado
     * @param request Contiene código de cupón QR desde link
     * @return Validación de cupón de beneficio
     */
    public CanjeaCuponResponse validaCanjeCuponBeneficio(CanjeaCuponRequest request);
    /***
     * Método que genera cupon con código QR e información de beneficio
     * @param request información de código de beneficio
     * @author dyanez
     * @return 
     */
    public GeneraCuponQrResponse generaCuponQR(GeneraCuponQrRequest request);
    
    
    
    /***
     * Método que entrega url validado al acceder a la aplicación desde medio externo, ya sea para descargar cupon (genera QR)
     * o canjea Cupon desde link de pistolear QR
     * @param session Información de session de usuario
     * @return URL para redirigir flujo de venta
     * @see LoginController#login(cl.bennder.bennderweb.model.LoginForm, javax.servlet.http.HttpSession) 
     */
    public String validaLinkExternoCupon(HttpSession session);
}
