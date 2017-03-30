/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.services;

import cl.bennder.entitybennderwebrest.request.CategoriaByIdRequest;
import cl.bennder.entitybennderwebrest.response.BeneficiosCargadorResponse;
import cl.bennder.entitybennderwebrest.response.BeneficiosResponse;
import cl.bennder.entitybennderwebrest.response.CategoriaResponse;
import cl.bennder.entitybennderwebrest.response.CategoriasResponse;



/**
 *
 * @author dyanez
 */
public interface CategoriaServices {
    CategoriasResponse obtenerCategorias();
    BeneficiosResponse obtenerBeneficiosPorCategoria();
    CategoriasResponse obtenerCategoriasRelacionadas(String nombreCategoria);
    CategoriaResponse cargarCategoria(String nombreCategoria);
    CategoriasResponse obtenerCategoriasById(CategoriaByIdRequest request);
    BeneficiosCargadorResponse getBeneficiosByIdCat(CategoriaByIdRequest request);
    
    
}
