package com.krevolorio.myappkapa.basededatossw;

import java.sql.Date;

public class FacturaVO {
    private int idFactura;
    private int numeroFactura;
    private String serieFactura;
    private Date fechaFactura;
    private double totalFactura;
    private String tipoPagoFactura;
    private String estadoFactura;
    private int idClienteFactura;

    public FacturaVO() {

    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getSerieFactura() {
        return serieFactura;
    }

    public void setSerieFactura(String serieFactura) {
        this.serieFactura = serieFactura;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
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

    public int getIdClienteFactura() {
        return idClienteFactura;
    }

    public void setIdClienteFactura(int idClienteFactura) {
        this.idClienteFactura = idClienteFactura;
    }
}
