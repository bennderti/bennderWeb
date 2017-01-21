/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.rest.request;

import java.io.Serializable;

/**
 *
 * @author dyanez
 */
public class HomeUsuarioRequest implements Serializable{
    private Integer idUsuario;
    
    public HomeUsuarioRequest() {
    }

    public HomeUsuarioRequest(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    
}
