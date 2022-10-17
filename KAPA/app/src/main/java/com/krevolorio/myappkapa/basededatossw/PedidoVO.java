package com.krevolorio.myappkapa.basededatossw;

/**
 * Clase que contiene los atributos de los pedidos
 */
public class PedidoVO {
    private Integer idFactura;
    private Integer numeroFactura;
    private String serieFactura;
    private String fechaFactura;
    private double totalFactura;
    private String tipoPagoFactura;
    private String estadoFactura;
    private Integer idClienteFK;

    /**
     * Constructor vacío
     */
    public PedidoVO() {
    }

    /**
     * Getters & Setters
     * @return -> Retorna el valor almacenado en las variables de pedido
     */
    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Integer getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Integer numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getSerieFactura() {
        return serieFactura;
    }

    public void setSerieFactura(String serieFactura) {
        this.serieFactura = serieFactura;
    }

    public String getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public double getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(double totalFactura) {
        this.totalFactura = totalFactura;
    }

    public String getTipoPagoFactura() {
        return tipoPagoFactura;
    }

    public void setTipoPagoFactura(String tipoPagoFactura) {
        this.tipoPagoFactura = tipoPagoFactura;
    }

    public String getEstadoFactura() {
        return estadoFactura;
    }

    public void setEstadoFactura(String estadoFactura) {
        this.estadoFactura = estadoFactura;
    }

    public Integer getIdClienteFK() {
        return idClienteFK;
    }

    public void setIdClienteFK(Integer idClienteFK) {
        this.idClienteFK = idClienteFK;
    }
}
