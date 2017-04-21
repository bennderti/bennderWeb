/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.model;

/**
 *
 * @author dyanez
 */
public class ValidaCuponForm {
    private Integer idVendedor;
    private Integer idDireccionSucursal;//id direccion de sucursal
    private String passwordSucursal;//contraseña sucusal
    private String urlLogoProveedor;

    public ValidaCuponForm() {
    }

    public ValidaCuponForm(Integer idVendedor, Integer idDireccionSucursal, String passwordSucursal) {
        this.idVendedor = idVendedor;
        this.idDireccionSucursal = idDireccionSucursal;
        this.passwordSucursal = passwordSucursal;
    }

    public Integer getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    public Integer getIdDireccionSucursal() {
        return idDireccionSucursal;
    }

    public void setIdDireccionSucursal(Integer idDireccionSucursal) {
        this.idDireccionSucursal = idDireccionSucursal;
    }

    public String getPasswordSucursal() {
        return passwordSucursal;
    }

    public void setPasswordSucursal(String passwordSucursal) {
        this.passwordSucursal = passwordSucursal;
    }

    public String getUrlLogoProveedor() {
        return urlLogoProveedor;
    }

    public void setUrlLogoProveedor(String urlLogoProveedor) {
        this.urlLogoProveedor = urlLogoProveedor;
    }

    @Override
    public String toString() {
        return "ValidaCuponForm{" + "idVendedor=" + idVendedor + ", idDireccionSucursal=" + idDireccionSucursal + ", passwordSucursal=" + passwordSucursal + ", urlLogoProveedor=" + urlLogoProveedor + '}';
    }
    
    
    
}
