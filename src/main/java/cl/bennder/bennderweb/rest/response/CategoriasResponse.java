/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.rest.response;

import cl.bennder.bennderweb.model.Categoria;
import cl.bennder.bennderweb.model.Validacion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dyanez
 */
public class CategoriasResponse extends ValidacionResponse implements Serializable{
    //private Validacion validacion;
    private List<Categoria> categorias;

    public CategoriasResponse() {
    }

    public CategoriasResponse(List<Categoria> categorias, Validacion validacion) {
        super(validacion);
        this.categorias = categorias;
    }
    

    public CategoriasResponse(List<Categoria> categorias) {
        this.categorias = categorias;
    }
    

//    public CategoriasResponse(Validacion validacion, List<Categoria> categorias) {
//        this.validacion = validacion;
//        this.categorias = categorias;
//    }

//    public Validacion getValidacion() {
//        if(validacion == null){
//            validacion = new Validacion();
//        }
//        return validacion;
//    }
//
//    public void setValidacion(Validacion validacion) {
//        this.validacion = validacion;
//    }
    //Asi sólo instanciamos cuando utilza y no siempre en constructor, practica de desarrollo y control de nulos
    public List<Categoria> getCategorias() {
        if(categorias == null){
            this.categorias = new ArrayList<>();
        }
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    
    
}
