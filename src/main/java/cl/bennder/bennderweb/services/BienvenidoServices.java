/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.services;

import cl.bennder.entitybennderwebrest.request.BienvenidoRequest;
import cl.bennder.entitybennderwebrest.request.GuardarDatosBienvenidaRequest;
import cl.bennder.entitybennderwebrest.response.BienvenidoResponse;
import cl.bennder.entitybennderwebrest.response.GuardarDatosBienvenidaResponse;

/**
 *
 * @author Marcos
 */
public interface BienvenidoServices {
    
    /**
     * Obtener datos para proyectar en la bienvenida. Estos datos son una lista de categorias para que el usuario seleccione sus preferidas
     * @param request
     * @return Respuesta de beneficios encontrados
     * @author mgutierrez
     */
    BienvenidoResponse obtenerDatosBienvenida(BienvenidoRequest request);
    GuardarDatosBienvenidaResponse guardarDatosBienvenida(GuardarDatosBienvenidaRequest request);
}
