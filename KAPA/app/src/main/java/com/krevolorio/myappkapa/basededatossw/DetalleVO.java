package com.krevolorio.myappkapa.basededatossw;

public class DetalleVO {
    private int cantidad;
    private String descripcion;
    private double precio;
    private double subtotal;
    private double total;

    public DetalleVO() {

    }

    public DetalleVO(int cantidad, String descripcion, int precio, int subtotal, int total) {
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.precio = precio;
        this.subtotal = subtotal;
        this.total = total;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
