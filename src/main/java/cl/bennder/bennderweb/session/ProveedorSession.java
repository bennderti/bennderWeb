/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.session;
import cl.bennder.entitybennderwebrest.model.Proveedor;
import java.util.List;

/**
 * Clase que permite mantenedor valores de proveedores en session para evitar ir a capa de servicio
 * @version 1.0
 * @author dyanez
 */
public class ProveedorSession {

    private List<Proveedor> lista;

    public ProveedorSession() {
    }

    public List<Proveedor> getLista() {
        return lista;
    }

    public void setLista(List<Proveedor> lista) {
        this.lista = lista;
    }
    
}
