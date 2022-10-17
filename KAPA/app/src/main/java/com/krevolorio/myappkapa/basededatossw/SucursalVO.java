package com.krevolorio.myappkapa.basededatossw;

/**
 * Clase que contiene los atributos de las sucursales
 */
public class SucursalVO {
    private Integer idSucursal;
    private String nombreSucursal;
    private String direccionSucursal;
    private String telefonoSucursal;

    /**
     * Constructor vacío
     */
    public SucursalVO() {
    }

    /**
     * Getters & Setters
     * @return -> Retorna el valor almacenado en las variables de sucursal
     */
    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getDireccionSucursal() {
        return direccionSucursal;
    }

    public void setDireccionSucursal(String direccionSucursal) {
        this.direccionSucursal = direccionSucursal;
    }

    public String getTelefonoSucursal() {
        return telefonoSucursal;
    }

    public void setTelefonoSucursal(String telefonoSucursal) {
        this.telefonoSucursal = telefonoSucursal;
    }
}
