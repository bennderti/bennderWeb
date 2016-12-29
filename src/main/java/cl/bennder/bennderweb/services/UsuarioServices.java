/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.services;

import cl.bennder.bennderweb.rest.request.LoginRequest;
import cl.bennder.bennderweb.rest.response.LoginResponse;

/**
 *
 * @author dyanez
 */
public interface UsuarioServices {
    public LoginResponse validacionUsuario(LoginRequest request);
}
