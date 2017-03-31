package cl.bennder.bennderweb.controller;



import cl.bennder.bennderweb.model.FileUploadForm;
import cl.bennder.bennderweb.model.UsuarioSession;
import cl.bennder.bennderweb.services.CargadorServices;
import cl.bennder.bennderweb.services.CategoriaServices;
import cl.bennder.bennderweb.services.ProveedorServices;
import cl.bennder.entitybennderwebrest.model.Validacion;
import cl.bennder.entitybennderwebrest.request.CategoriaByIdRequest;
import cl.bennder.entitybennderwebrest.request.ProveedorIdRequest;
import cl.bennder.entitybennderwebrest.response.BeneficiosCargadorResponse;
import cl.bennder.entitybennderwebrest.response.BeneficiosResponse;
import cl.bennder.entitybennderwebrest.response.CategoriasResponse;
import cl.bennder.entitybennderwebrest.response.UploadBeneficioImagenResponse;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Diego on 01-03-2017.
 */
@Controller
public class CargadorController {

    private static final Logger log = LoggerFactory.getLogger(CargadorController.class);

    @Autowired
    private CategoriaServices categoriaServices;
    
    @Autowired
    private ProveedorServices proveedorServices;
    
    @Autowired
    private CargadorServices cargadorServices;

    @Autowired
    private UsuarioSession usuarioSession;

    @ExceptionHandler
    @RequestMapping(value = "/cargaBeneficiosProveedores.html", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public ModelAndView cargaBeneficiosProveedores() {
        log.info("INICIO");
        log.info("Usuario connected ->{}",usuarioSession.getIdUsuario());
        ModelAndView modelAndView = new ModelAndView("cargadorImagenes");
        modelAndView.addObject("proveedores", proveedorServices.obtenerProveedorHabilitados(new ProveedorIdRequest()).getProveedores());
        log.info("FIN");
        return modelAndView;
    }
    
    @RequestMapping(value="obtenerCategoriaByProveedor.html", method=RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public @ResponseBody String obtenerCategoriaByProveedor(@RequestParam("id") Integer idProveedor, HttpSession session){
        log.info("INICIO - idProveedor ->{}",idProveedor);
        CategoriasResponse response = new CategoriasResponse();
        response.setValidacion(new Validacion("0", "1", "Sin categorias encontradas"));
        if(idProveedor!=null){
            response = proveedorServices.obtenerCategoriaByProveedor(new ProveedorIdRequest(idProveedor));
        }
        String respJson =  new Gson().toJson(response);
        log.info("FIN");
        return respJson;
    }
    
    @RequestMapping(value="getSubCatById.html", method=RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public @ResponseBody String getSubCatById(@RequestParam("id") Integer idCategoria, HttpSession session){
        log.info("INICIO - idCategoria ->{}",idCategoria);
        CategoriasResponse response = new CategoriasResponse();
        response.setValidacion(new Validacion("0", "1", "Sin categorias encontradas"));
        if(idCategoria!=null){
            response = categoriaServices.obtenerCategoriasById(new CategoriaByIdRequest(idCategoria));
        }
        String respJson =  new Gson().toJson(response);
        log.info("FIN");
        return respJson;
    }
    
    @RequestMapping(value="getBeneficiosByIdCat.html", method=RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public @ResponseBody String getBeneficiosByIdCat(@RequestParam("id") Integer idCategoria, HttpSession session){
        log.info("INICIO - idBeneficio ->{}",idCategoria);
        BeneficiosCargadorResponse response = new BeneficiosCargadorResponse();
        response.setValidacion(new Validacion("0", "1", "Sin beneficios encontradas"));
        if(idCategoria!=null){
            response = categoriaServices.getBeneficiosByIdCat(new CategoriaByIdRequest(idCategoria));
        }
        String respJson =  new Gson().toJson(response);
        log.info("FIN");
        return respJson;
    }
    @RequestMapping(value = "/uploadImagesBeneficios.html", method = RequestMethod.POST)
    public ModelAndView uploadImagesBeneficios(@ModelAttribute("uploadForm") FileUploadForm uploadForm,
                                               @RequestParam("idBeneficio") Integer idBeneficio,
                                               @RequestParam("indexPrincipal") Integer indexPrincipal) {
        log.info("INICIO");
        log.info("idBeneficio ->{}",idBeneficio);
        log.info("indexPrincipal ->{}",indexPrincipal);
        UploadBeneficioImagenResponse response =  cargadorServices.uploadImagenesBeneficios(uploadForm.getFiles(), idBeneficio, indexPrincipal);
        ModelAndView modelAndView = new ModelAndView("cargadorImagenes");
        modelAndView.addObject("proveedores", proveedorServices.obtenerProveedorHabilitados(new ProveedorIdRequest()).getProveedores());
        modelAndView.addObject("respuesta",response.getValidacion());
        
        log.info("FIN");
        //return new ModelAndView("redirect:cargaBeneficiosProveedores.html");
        return modelAndView;
	}
     
        @RequestMapping(value = "/files/{file_name}.html", method = RequestMethod.GET)
        public void getFile(
            @PathVariable("file_name") String fileName, 
            HttpServletResponse response) {
            try {
              // get your file as InputStream
              //InputStream is = ...;
              // copy it to response's OutputStream
              log.info("file_name-->{}",fileName);
              File initialFile = new File("C:\\Users\\dyanez\\AppData\\Local\\Temp\\sample1.pdf");
              //InputStream is = new ByteArrayInputStream(decodedBytes);
              InputStream targetStream = FileUtils.openInputStream(initialFile);
              org.apache.commons.io.IOUtils.copy(targetStream, response.getOutputStream());
              response.flushBuffer();
              response.setContentType("application/pdf");
            } catch (IOException ex) {
              log.info("Error writing file to output stream. Filename was '{}'", fileName, ex);
              throw new RuntimeException("IOError writing file to output stream");
            }

        }
    
    
}
