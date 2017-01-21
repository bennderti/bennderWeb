/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.rest.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dyanez
 */
public class CategoriasRequest implements Serializable{
    private Integer idCliente;
    public CategoriasRequest() {
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    
    
    
}
