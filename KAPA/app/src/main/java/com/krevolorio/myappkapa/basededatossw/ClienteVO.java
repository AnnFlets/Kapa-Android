package com.krevolorio.myappkapa.basededatossw;

public class ClienteVO {

    private Integer idCliente;
    private String usuarioCliente;
    private String contraCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private String nitCliente;
    private String direccionCliente;
    private String telCliente;
    private String correCliente;


    public ClienteVO() {
    }


    public ClienteVO(Integer idCliente, String usuarioCliente, String contraCliente, String nombreCliente, String apellidoCliente, String nitCliente, String direccionCliente, String telCliente, String correCliente) {
        this.idCliente = idCliente;
        this.usuarioCliente = usuarioCliente;
        this.contraCliente = contraCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.nitCliente = nitCliente;
        this.direccionCliente = direccionCliente;
        this.telCliente = telCliente;
        this.correCliente = correCliente;
    }


    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getUsuarioCliente() {
        return usuarioCliente;
    }

    public void setUsuarioCliente(String usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }

    public String getContraCliente() {
        return contraCliente;
    }

    public void setContraCliente(String contraCliente) {
        this.contraCliente = contraCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getNitCliente() {
        return nitCliente;
    }

    public void setNitCliente(String nitCliente) {
        this.nitCliente = nitCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getTelCliente() {
        return telCliente;
    }

    public void setTelCliente(String telCliente) {
        this.telCliente = telCliente;
    }

    public String getCorreCliente() {
        return correCliente;
    }

    public void setCorreCliente(String correCliente) {
        this.correCliente = correCliente;
    }
}
