/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.services;

import cl.bennder.bennderweb.rest.request.LoginRequest;
import cl.bennder.bennderweb.rest.request.RecuperacionPasswordRequest;
import cl.bennder.bennderweb.rest.response.LoginResponse;
import cl.bennder.bennderweb.rest.response.ValidacionResponse;

/**
 *
 * @author dyanez
 */
public interface UsuarioServices {
    public LoginResponse validacionUsuario(LoginRequest request);
        /***
     * Método encargado de enviar un correo con la contraseña del usuario
     * @param request Usuario correo destino
     * @return Validación de recuperación de contraseña
     */
    public ValidacionResponse recuperacionPassword(RecuperacionPasswordRequest request);
}
