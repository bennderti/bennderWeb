/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.constantes;

/**
 *
 * @author dyanez
 */
public abstract class URLServiciosBennder {
    public static final String URL_CAMBIO_PASSWORD = "login/cambioPassword";
    public static final String URL_MAIL_RECUPERACION_PASSWORD = "mail/recuperacionPassword";
    public static final String URL_VALIDACION_USUARIO = "login";
    public static final String URL_GET_CATEGORIAS = "getCategorias";
    //public static final String URL_GET_CATEGORIAS_BY_ID = "obtenerCategoriasById";
    public static final String URL_GET_SUB_CATEGORIAS_BY_ID_CAT_PROV = "categoria/getSubCategoriasProveedor";
    public static final String URL_GET_CATEGORIAS_BY_PROVEEDOR = "obtenerCategoriaByProveedor";
    public static final String URL_GURDA_DATOS_GRALES_PROVEEDOR = "proveedor/guardaDatosGenerales";
    public static final String URL_UPLOAD_IMAGENES_BENEFICIOS = "uploadImagenesBeneficios";    
    public static final String URL_GET_PROVEEDORES_HABILITADOS = "obtenerProveedorHabilitados";    
    public static final String URL_GET_BENEFICIOS_BY_ID_CAT = "getBeneficiosByIdCat";
    public static final String URL_OBTENER_BENEFICIOS_POR_CATEGORIA = "obtenerBeneficiosPorCategoria";
    public static final String URL_OBTENER_CATEGORIAS_RELACIONADAS = "obtenerCategoriasRelacionadas";
    public static final String URL_CARGAR_CATEGORIA = "cargarCategoria";
    public static final String URL_OBTENER_DETALLE_BENEFICIO = "obtenerDetalleBeneficio";
    public static final String URL_BENEFICIO_GENERAR_CUPON_QR = "beneficio/generaCuponQR";
    public static final String URL_BENEFICIO_GET_CUPON_BENEFICIO = "beneficio/getCuponBeneficio";
    public static final String URL_BENEFICIO_GET_VALIDA_CANJEA_CUPON= "beneficio/validaCanjeCupon";
    public static final String URL_BENEFICIO_VALIDA_CUPON_POS= "beneficio/validacionCuponPOS";
    public static final String URL_HOME_CARGAR_HOME = "home/cargarHome";
    public static final String URL_BENEFICIO_BUSCAR_BENEFICIOS = "beneficio/buscarBeneficios";
    public static final String URL_GET_DATOS_PERFIL = "perfil/getDatos";
    public static final String URL_GUARDAR_DATOS_PERFIL = "perfil/guardarDatos";
    public static final String URL_CATEGORIA_FILTRAR_BENEFICIOS_PRECIO = "categoria/obtenerBeneficiosCategoriaFiltradosPorPrecio";
    public static final String URL_CATEGORIA_FILTRAR_BENEFICIOS_DESCUENTO = "categoria/obtenerBeneficiosCategoriaFiltradosPorDescuento";
    public static final String URL_CATEGORIA_FILTRAR_BENEFICIOS_PROVEEDOR = "categoria/filtrarBeneficiosPorProveedor";
    public static final String URL_CATEGORIA_FILTRAR_BENEFICIOS_CALIFICACION = "categoria/filtrarBeneficiosPorCalificacion";
}
