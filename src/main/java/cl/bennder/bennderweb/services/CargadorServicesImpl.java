/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.services;

import cl.bennder.bennderweb.rest.connector.RestConnector;
import cl.bennder.entitybennderwebrest.model.BeneficioImagen;
import cl.bennder.entitybennderwebrest.model.Validacion;
import cl.bennder.entitybennderwebrest.request.UploadBeneficioImagenRequest;
import cl.bennder.entitybennderwebrest.response.UploadBeneficioImagenResponse;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author dyanez
 */
@Service
public class CargadorServicesImpl implements CargadorServices{
    
    private static final Logger log = LoggerFactory.getLogger(CargadorServicesImpl.class);

    @Override
    public UploadBeneficioImagenResponse uploadImagenesBeneficios(List<MultipartFile> imagenes, Integer idBeneficio,Integer indexPrincipal, Integer idProveedor) { 
        UploadBeneficioImagenResponse response = new UploadBeneficioImagenResponse();
        response.setValidacion(new Validacion("0","1","Problemas al subir imagenes a beneficio"));
        log.info("inicio");
        try {
            if(indexPrincipal!=null && idBeneficio != null){
                if(imagenes!=null && imagenes.size() > 0){
                    log.info("completando datos request");
                    UploadBeneficioImagenRequest request = new UploadBeneficioImagenRequest();
                    request.setIdProveedor(idProveedor);
                    int ordenBase = 1;
                    int orden = 1;
                    for (MultipartFile multipartFile : imagenes) {
                            String fileName = multipartFile.getOriginalFilename();
                            log.info("imagen subida ->{}",fileName);
                            //Integer idBeneficio, Integer idImagen, String nombre, byte[] imagen, Integer orden, String imagenBase64, String path
                            //BeneficioImagen bimagen = new BeneficioImagen(idBeneficio, fileName, multipartFile.getBytes(), ordenBase);
                            BeneficioImagen bimagen = new BeneficioImagen();
                            bimagen.setNombre(fileName);
                            bimagen.setImagen(multipartFile.getBytes());
                            bimagen.setIdBeneficio(idBeneficio);
                            if(ordenBase < (indexPrincipal + 1)){
                                orden = ordenBase + 1;
                            }
                            else if ( ordenBase == (indexPrincipal + 1 )){
                                orden = 1;//ya que indexPrincipal comienza desde 0
                                log.info("La imagen ->{} se configura como principal (orden 1)",fileName);
                            }
                            else{
                                orden  = ordenBase;
                            }
                            log.info("Orden a actualizar ->{} para beneficio ->{}",orden,fileName);
                            bimagen.setOrden(orden);
                            ordenBase++;
                            request.getBeneficioImagenes().add(bimagen);
                    }
                    log.info("inicio - consultando servicio para enviar imagenes de beneficio...");
                    response = RestConnector.uploadImagenesBeneficios(request); 
                    log.info("fin - consultando servicio para enviar imagenes de beneficio...");
                }
                else{
                    response.getValidacion().setCodigoNegocio("1");
                    response.getValidacion().setMensaje("Sin imagenes para cargar a beneficio");
                    log.info("Sin imagenes para cargar a beneficio");
                }
            }
            else{
                response.getValidacion().setCodigoNegocio("1");
                response.getValidacion().setMensaje("Faltan completar datos, beneficio o selección principal.");
                log.info("Faltan completar datos, beneficio o selección principal.");
            }
        } catch (Exception e) {
            response.setValidacion(new Validacion("1","1","Error al subir imagenes"));
            log.error("Exception uploadImagenesBeneficios,",e);
        }
        log.info("fin");
                
        return response;       
    }
}
