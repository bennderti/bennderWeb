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
    private Integer idSucursal;//id direccion de sucursal
    private String passwordSucursal;//contraseña sucusal
    private String urlLogoProveedor;

    public ValidaCuponForm() {
    }

    public ValidaCuponForm(Integer idVendedor, Integer idSucursal, String passwordSucursal) {
        this.idVendedor = idVendedor;
        this.idSucursal = idSucursal;
        this.passwordSucursal = passwordSucursal;
    }

    public Integer getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
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
        return "ValidaCuponForm{" + "idVendedor=" + idVendedor + ", idSucursal=" + idSucursal + ", passwordSucursal=" + passwordSucursal + ", urlLogoProveedor=" + urlLogoProveedor + '}';
    }
    
    
    
}
