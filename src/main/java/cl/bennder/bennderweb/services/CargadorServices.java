/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.services;

import cl.bennder.entitybennderwebrest.request.UploadBeneficioImagenRequest;
import cl.bennder.entitybennderwebrest.response.UploadBeneficioImagenResponse;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author dyanez
 */
public interface CargadorServices {
    
    
    /***
     * Método que permite cargar una lista de imagenes a un beneficio en particular, en donde orden 1 indica que es imagen
     * @param imagenes listados de imagenes
     * @param idBeneficio
     * @param indexPrincipal
     * @param idProveedor identificador de proveedor
     * @return 
     */
    public UploadBeneficioImagenResponse uploadImagenesBeneficios(List<MultipartFile> imagenes, Integer idBeneficio,Integer indexPrincipal, Integer idProveedor);
}
