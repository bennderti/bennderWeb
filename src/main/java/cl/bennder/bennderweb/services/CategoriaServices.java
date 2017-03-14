/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.services;

import cl.bennder.bennderweb.rest.response.BeneficiosResponse;
import cl.bennder.bennderweb.rest.response.CategoriaResponse;
import cl.bennder.bennderweb.rest.response.CategoriasResponse;


/**
 *
 * @author dyanez
 */
public interface CategoriaServices {
    CategoriasResponse obtenerCategorias();
    BeneficiosResponse obtenerBeneficiosPorCategoria();
    CategoriasResponse obtenerCategoriasRelacionadas(String nombreCategoria);
    CategoriaResponse cargarCategoria(String nombreCategoria);
}
