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
import cl.bennder.entitybennderwebrest.request.BeneficiosRequest;
import cl.bennder.entitybennderwebrest.request.CategoriaByIdRequest;
import cl.bennder.entitybennderwebrest.request.CategoriasRequest;
import cl.bennder.entitybennderwebrest.request.SubCategoriaProveedorRequest;
import cl.bennder.entitybennderwebrest.response.BeneficiosCargadorResponse;
import cl.bennder.entitybennderwebrest.response.BeneficiosResponse;
import cl.bennder.entitybennderwebrest.response.CategoriaResponse;
import cl.bennder.entitybennderwebrest.response.CategoriasResponse;
import cl.bennder.entitybennderwebrest.response.SubCategoriaProveedorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;


/**
 *
 * @author dyanez
 */
@Service
public class CategoriaServicesImpl implements CategoriaServices{

    private static final Logger log = LoggerFactory.getLogger(CategoriaServicesImpl.class);

    @Autowired
    UsuarioSession usuarioSession;
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

    @Override
    public BeneficiosResponse obtenerBeneficiosPorCategoria() {
        BeneficiosResponse response = new BeneficiosResponse();
        response.getValidacion().setCodigo("NOK");
        response.getValidacion().setMensaje("Problemas al obtener categorías");
        log.info("INICIO");
        try {

            response = RestConnector.clientRestGeneric(Properties.URL_SERVIDOR + URLServiciosBennder.URL_OBTENER_BENEFICIOS_POR_CATEGORIA, new BeneficiosRequest(), BeneficiosResponse.class, usuarioSession.getToken());
            if(response == null){
                response = new BeneficiosResponse();
                response.getValidacion().setCodigo("NOK");
                response.getValidacion().setMensaje("Problemas al obtener categorías");
                log.error("No se pudo obtener respuesta en URL_OBTENER_BENEFICIOS_POR_CATEGORIA");
            }
        } catch (Exception e) {
            log.error("[Exception] Error al obtenerBeneficiosPorCategoria", e);
            response.getValidacion().setCodigo("NOK");
            response.getValidacion().setMensaje("Error al obtener categorías");
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
     * @param nombreCategoria
     * @return Categoria con sus beneficios
     */
    @Override
    public CategoriaResponse cargarCategoria(String nombreCategoria) {
        CategoriaResponse response = new CategoriaResponse();
        response.getValidacion().setCodigo("NOK");
        response.getValidacion().setMensaje("Problemas al obtener categorías");
        log.info("INICIO");
        try {

            CategoriasRequest categoriasRequest = new CategoriasRequest(usuarioSession.getToken());
            categoriasRequest.setNombreCategoria(nombreCategoria);

            response = RestConnector.clientRestGeneric(Properties.URL_SERVIDOR + URLServiciosBennder.URL_CARGAR_CATEGORIA, categoriasRequest , CategoriaResponse.class, usuarioSession.getToken());
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

}
