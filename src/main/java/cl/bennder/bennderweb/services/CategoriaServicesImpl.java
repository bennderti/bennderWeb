/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.services;

import cl.bennder.bennderweb.constantes.URLServiciosBennder;
import cl.bennder.bennderweb.properties.Properties;
import cl.bennder.bennderweb.rest.connector.RestConnector;
import cl.bennder.bennderweb.session.UsuarioSession;
import cl.bennder.entitybennderwebrest.model.Producto;
import cl.bennder.entitybennderwebrest.model.TipoBeneficio;
import cl.bennder.entitybennderwebrest.request.*;
import cl.bennder.entitybennderwebrest.response.BeneficiosCargadorResponse;
import cl.bennder.entitybennderwebrest.response.BeneficiosResponse;
import cl.bennder.entitybennderwebrest.response.CategoriaResponse;
import cl.bennder.entitybennderwebrest.response.CategoriasResponse;
import cl.bennder.entitybennderwebrest.response.PaginadorBeneficioResponse;
import cl.bennder.entitybennderwebrest.response.SubCategoriaProveedorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.Map;


/**
 *
 * @author dyanez
 */
@Service
public class CategoriaServicesImpl implements CategoriaServices{

    private static final Logger log = LoggerFactory.getLogger(CategoriaServicesImpl.class);

    @Autowired
    UsuarioSession usuarioSession;

    @Override
    public PaginadorBeneficioResponse obtenerBeneficiosPaginados(PaginadorBeneficioRequest request) {
        return RestConnector.clientRestGeneric(Properties.URL_SERVIDOR + URLServiciosBennder.URL_GET_BENEFICIOS_PAGINADOS, request, PaginadorBeneficioResponse.class, usuarioSession.getToken());
    }
    
    /***
     * Obtiene las categorias por id de categoria
     * @param request
     * @return 
     */
    @Override
//    public CategoriasResponse obtenerCategoriasById(CategoriaByIdRequest request) {
    public SubCategoriaProveedorResponse getSubCategoriasProveedor(SubCategoriaProveedorRequest request){
        return RestConnector.clientRestGeneric(Properties.URL_SERVIDOR + URLServiciosBennder.URL_GET_SUB_CATEGORIAS_BY_ID_CAT_PROV, request, SubCategoriaProveedorResponse.class, usuarioSession.getToken());
    }

    @Override
    public BeneficiosCargadorResponse getBeneficiosByIdCat(CategoriaByIdRequest request) {
        return RestConnector.clientRestGeneric(Properties.URL_SERVIDOR + URLServiciosBennder.URL_GET_BENEFICIOS_BY_ID_CAT, request, BeneficiosCargadorResponse.class, usuarioSession.getToken());
    }

    @Override
    public BeneficiosResponse obtenerBeneficiosCategoriaFiltradosPorPrecio(Integer categoriaSeleccionada, Integer precioMin, Integer precioMax) {
        BeneficiosResponse response = new BeneficiosResponse();

        log.info("INICIO");
        try {
            FiltrarBeneficiosRangoRequest request = new FiltrarBeneficiosRangoRequest();
            request.setIdCategoria(categoriaSeleccionada);
            request.setRangoMin(precioMin);
            request.setRangoMax(precioMax);

            response = RestConnector.clientRestGeneric(Properties.URL_SERVIDOR + URLServiciosBennder.URL_CATEGORIA_FILTRAR_BENEFICIOS_PRECIO, request, BeneficiosResponse.class, usuarioSession.getToken());

            if(response == null){
                response = new BeneficiosResponse();
                response.getValidacion().setCodigo("NOK");
                response.getValidacion().setMensaje("Problemas al filtrar beneficios");
            }
        }
        catch (Exception e) {
            log.error("[Exception] Error al obtener beneficios", e);
            response.getValidacion().setCodigo("NOK");
            response.getValidacion().setMensaje("Error al obtener beneficios");
        }
        log.info("FIN");
        return response;
    }

    @Override
    public BeneficiosResponse obtenerBeneficiosCategoriaFiltradosPorDescuento(Integer categoriaSeleccionada, Integer descuentoMin, Integer descuentoMax) {
        BeneficiosResponse response = new BeneficiosResponse();

        log.info("INICIO");
        try {
            FiltrarBeneficiosRangoRequest request = new FiltrarBeneficiosRangoRequest();
            request.setIdCategoria(categoriaSeleccionada);
            request.setRangoMin(descuentoMin);
            request.setRangoMax(descuentoMax);

            response = RestConnector.clientRestGeneric(Properties.URL_SERVIDOR + URLServiciosBennder.URL_CATEGORIA_FILTRAR_BENEFICIOS_DESCUENTO, request, BeneficiosResponse.class, usuarioSession.getToken());

            if(response == null){
                response = new BeneficiosResponse();
                response.getValidacion().setCodigo("NOK");
                response.getValidacion().setMensaje("Problemas al filtrar beneficios");
            }
        }
        catch (Exception e) {
            log.error("[Exception] Error al obtener beneficios", e);
            response.getValidacion().setCodigo("NOK");
            response.getValidacion().setMensaje("Error al obtener beneficios");
        }
        log.info("FIN");
        return response;
    }

    @Override
    public CategoriasResponse obtenerCategorias() {
        CategoriasResponse response = new CategoriasResponse();
        response.getValidacion().setCodigo("NOK");
        response.getValidacion().setMensaje("Problemas al obtener categorías");
        log.info("INICIO");
//        try {

            response = RestConnector.clientRestGeneric(Properties.URL_SERVIDOR + URLServiciosBennder.URL_GET_CATEGORIAS, new CategoriasRequest(), CategoriasResponse.class, usuarioSession.getToken());

            if(response == null){
                response = new CategoriasResponse();
                response.getValidacion().setCodigo("NOK");
                response.getValidacion().setMensaje("Problemas al obtener categorías");
                log.info("INICIO");
            }
//        }
//        catch (Exception e) {
//            log.error("[Exception] Error al obtener categorías", e);
//            response.getValidacion().setCodigo("NOK");
//            response.getValidacion().setMensaje("Error al obtener categorías");
//        }
        log.info("FIN");
        return response;
    }

//    @Override
//    public BeneficiosResponse obtenerBeneficiosPorCategoria() {
//        BeneficiosResponse response = new BeneficiosResponse();
//        response.getValidacion().setCodigo("NOK");
//        response.getValidacion().setMensaje("Problemas al obtener categorías");
//        log.info("INICIO");
//        try {
//
//            response = RestConnector.clientRestGeneric(Properties.URL_SERVIDOR + URLServiciosBennder.URL_OBTENER_BENEFICIOS_POR_CATEGORIA, new BeneficiosRequest(), BeneficiosResponse.class, usuarioSession.getToken());
//            if(response == null){
//                response = new BeneficiosResponse();
//                response.getValidacion().setCodigo("NOK");
//                response.getValidacion().setMensaje("Problemas al obtener categorías");
//                log.error("No se pudo obtener respuesta en URL_OBTENER_BENEFICIOS_POR_CATEGORIA");
//            }
//        } catch (Exception e) {
//            log.error("[Exception] Error al obtenerBeneficiosPorCategoria", e);
//            response.getValidacion().setCodigo("NOK");
//            response.getValidacion().setMensaje("Error al obtener categorías");
//        }
//        log.info("FIN");
//        return response;
//    }


    @Override
    public BeneficiosResponse filtrarBeneficiosPorProveedor(String proveedor, Integer categoriaSeleccionada) {
        BeneficiosResponse response = new BeneficiosResponse();
        response.getValidacion().setCodigo("NOK");
        response.getValidacion().setMensaje("Problemas al obtener beneficios por Categoria ");
        log.info("INICIO");

        FiltrarBeneficiosRequest request = new FiltrarBeneficiosRequest();
        request.setIdCategoria(categoriaSeleccionada);
        request.setCampoAFiltrar(proveedor);
        try {

            response = RestConnector.clientRestGeneric(Properties.URL_SERVIDOR + URLServiciosBennder.URL_CATEGORIA_FILTRAR_BENEFICIOS_PROVEEDOR, request, BeneficiosResponse.class, usuarioSession.getToken());
            if(response == null){
                response = new BeneficiosResponse();
                response.getValidacion().setCodigo("NOK");
                response.getValidacion().setMensaje("Problemas al filtrar beneficios");
                log.error("No se pudo obtener respuesta en URL_CATEGORIA_FILTRAR_BENEFICIOS_PROVEEDOR");
            }
        } catch (Exception e) {
            log.error("[Exception] Error al filtrarBeneficiosPorProveedor", e);
            response.getValidacion().setCodigo("NOK");
            response.getValidacion().setMensaje("Error al obtener beneficios");
        }
        log.info("FIN");
        return response;
    }

    @Override
    public BeneficiosResponse filtrarBeneficiosPorCalificacion(String calificacion, Integer categoriaSeleccionada) {
        BeneficiosResponse response = new BeneficiosResponse();
        response.getValidacion().setCodigo("NOK");
        response.getValidacion().setMensaje("Problemas al obtener beneficios por Categoria ");
        log.info("INICIO");

        FiltrarBeneficiosRequest request = new FiltrarBeneficiosRequest();
        request.setIdCategoria(categoriaSeleccionada);
        request.setCampoAFiltrar(calificacion);
        try {

            response = RestConnector.clientRestGeneric(Properties.URL_SERVIDOR + URLServiciosBennder.URL_CATEGORIA_FILTRAR_BENEFICIOS_CALIFICACION, request, BeneficiosResponse.class, usuarioSession.getToken());
            if(response == null){
                response = new BeneficiosResponse();
                response.getValidacion().setCodigo("NOK");
                response.getValidacion().setMensaje("Problemas al filtrar beneficios");
                log.error("No se pudo obtener respuesta en URL_CATEGORIA_FILTRAR_BENEFICIOS_CALIFICACION");
            }
        } catch (Exception e) {
            log.error("[Exception] Error al filtrarBeneficiosPorCalificacion", e);
            response.getValidacion().setCodigo("NOK");
            response.getValidacion().setMensaje("Error al obtener beneficios");
        }
        log.info("FIN");
        return response;
    }

    @Override
    public CategoriasResponse obtenerCategoriasRelacionadas(String nombreCategoria) {
        CategoriasResponse response = new CategoriasResponse();
        response.getValidacion().setCodigo("NOK");
        response.getValidacion().setMensaje("Problemas al obtener categorías");
        log.info("INICIO");
        try {

            CategoriasRequest categoriasRequest = new CategoriasRequest(usuarioSession.getToken());
            categoriasRequest.setNombreCategoria(nombreCategoria);

            response = RestConnector.clientRestGeneric(Properties.URL_SERVIDOR + URLServiciosBennder.URL_OBTENER_CATEGORIAS_RELACIONADAS, categoriasRequest , CategoriasResponse.class, usuarioSession.getToken());
            if(response == null){
                response = new CategoriasResponse();
                response.getValidacion().setCodigo("NOK");
                response.getValidacion().setMensaje("Problemas al obtener categorías relacionadas");
                log.error("No se pudo obtener categorías relacionadas");
            }
        } catch (Exception e) {
            log.error("[Exception] Error al obtener categorías", e);
            response.getValidacion().setCodigo("NOK");
            response.getValidacion().setMensaje("Error al obtener categorías");
        }
        log.info("FIN");
        return response;
    }

    /**
     * @author Diego
     * @param idCategoria
     * @return Categoria con sus beneficios
     */
    @Override
    public CategoriaResponse cargarCategoria(Integer idCategoria) {
        CategoriaResponse response = new CategoriaResponse();
        response.getValidacion().setCodigo("NOK");
        response.getValidacion().setMensaje("Problemas al obtener categorías");
        log.info("INICIO");
        try {

            CategoriaByIdRequest categoriaByIdRequest = new CategoriaByIdRequest();
            categoriaByIdRequest.setIdCategoria(idCategoria);

            response = RestConnector.clientRestGeneric(Properties.URL_SERVIDOR + URLServiciosBennder.URL_CARGAR_CATEGORIA, categoriaByIdRequest , CategoriaResponse.class, usuarioSession.getToken());
            obtenerRangoPrecios(response);

            if(response == null){
                response = new CategoriaResponse();
                response.getValidacion().setCodigo("NOK");
                response.getValidacion().setMensaje("Problemas al obtener categorías relacionadas");
                log.error("No se pudo obtener categorías relacionadas");
            }


        } catch (Exception e) {
            log.error("[Exception] Error al obtener categorías", e);
            response.getValidacion().setCodigo("NOK");
            response.getValidacion().setMensaje("Error al obtener categorías");
        }
        log.info("FIN");
        return response;
    }

    private void obtenerRangoPrecios(CategoriaResponse response) {

        IntSummaryStatistics summaryStatistics = response.getBeneficios().stream()
                .filter(beneficio -> beneficio instanceof Producto)
                .mapToInt(beneficio -> ((Producto) beneficio).getPrecioOferta())
                .summaryStatistics();

        Map<String, Integer> rango = new HashMap<>();
        if (summaryStatistics.getMin() != Integer.MIN_VALUE)
            rango.put("precioMin", summaryStatistics.getMin());
        if (summaryStatistics.getMax() != Integer.MAX_VALUE)
            rango.put("precioMax", summaryStatistics.getMax());

        response.setRango(rango);
    }

}
