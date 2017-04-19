/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.model;

import cl.bennder.entitybennderwebrest.model.Proveedor;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author dyanez
 */
public class ProveedorForm extends Proveedor{
    private MultipartFile logoImagen;
    private Integer idProveedorSelect;
    public ProveedorForm() {
    }
    
    public ProveedorForm(MultipartFile logoImagen) {
        this.logoImagen = logoImagen;
    }

    public ProveedorForm(MultipartFile logoImagen, Integer idProveedor, String nombre, Integer rut, String rutDv, String path) {
        super(idProveedor, nombre, rut, rutDv, path);
        this.logoImagen = logoImagen;
    }

    public MultipartFile getLogoImagen() {
        return logoImagen;
    }

    public void setLogoImagen(MultipartFile logoImagen) {
        this.logoImagen = logoImagen;
    }

    @Override
    public String toString() {
        return "ProveedorForm{ Proveedor=" + super.toString() + ", idProveedorSelect=" + idProveedorSelect + '}';
    }

    

    public Integer getIdProveedorSelect() {
        return idProveedorSelect;
    }

    public void setIdProveedorSelect(Integer idProveedorSelect) {
        this.idProveedorSelect = idProveedorSelect;
    }
    
    
    
    
}
