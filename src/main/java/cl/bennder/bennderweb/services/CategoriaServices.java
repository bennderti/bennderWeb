/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.services;

import cl.bennder.entitybennderwebrest.request.CategoriaByIdRequest;
import cl.bennder.entitybennderwebrest.request.SubCategoriaProveedorRequest;
import cl.bennder.entitybennderwebrest.response.BeneficiosCargadorResponse;
import cl.bennder.entitybennderwebrest.response.BeneficiosResponse;
import cl.bennder.entitybennderwebrest.response.CategoriaResponse;
import cl.bennder.entitybennderwebrest.response.CategoriasResponse;
import cl.bennder.entitybennderwebrest.response.SubCategoriaProveedorResponse;



/**
 *
 * @author dyanez
 */
public interface CategoriaServices {
    CategoriasResponse obtenerCategorias();
    BeneficiosResponse obtenerBeneficiosPorCategoria();
    CategoriasResponse obtenerCategoriasRelacionadas(String nombreCategoria);
    CategoriaResponse cargarCategoria(String nombreCategoria);
    //CategoriasResponse obtenerCategoriasById(CategoriaByIdRequest request);
    public SubCategoriaProveedorResponse getSubCategoriasProveedor(SubCategoriaProveedorRequest request);
    BeneficiosCargadorResponse getBeneficiosByIdCat(CategoriaByIdRequest request);
    BeneficiosResponse obtenerBeneficiosCategoriaFiltradosPorPrecio(String categoriaSeleccionada, Integer precioMin, Integer precioMax);
    BeneficiosResponse obtenerBeneficiosCategoriaFiltradosPorDescuento(String categoriaSeleccionada, Integer descuentoMin, Integer descuentoMax);
}
