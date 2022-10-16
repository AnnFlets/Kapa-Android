package com.krevolorio.myappkapa.basededatossw;

public class ProductoVO {
    private Integer idProducto;
    private String descripcionProducto;
    private String marcaProducto;
    private String presentacionProducto;
    private String categoriaProducto;
    private double precioCompraProducto;
    private double precioVentaProducto;
    private Integer existenciaProducto;
    private String imgProducto;
    private Integer idProveedorFK;

    //CONSTRUCTOR VACIO
    public ProductoVO() {
    }

    //COMPLETO
    public ProductoVO(Integer idProducto, String descripcionProducto, String marcaProducto, String presentacionProducto, String categoriaProducto, double precioCompraProducto, double precioVentaProducto, Integer existenciaProducto, String imgProducto, Integer idProveedorFK) {
        this.idProducto = idProducto;
        this.descripcionProducto = descripcionProducto;
        this.marcaProducto = marcaProducto;
        this.presentacionProducto = presentacionProducto;
        this.categoriaProducto = categoriaProducto;
        this.precioCompraProducto = precioCompraProducto;
        this.precioVentaProducto = precioVentaProducto;
        this.existenciaProducto = existenciaProducto;
        this.imgProducto = imgProducto;
        this.idProveedorFK = idProveedorFK;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public String getPresentacionProducto() {
        return presentacionProducto;
    }

    public void setPresentacionProducto(String presentacionProducto) {
        this.presentacionProducto = presentacionProducto;
    }

    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public double getPrecioCompraProducto() {
        return precioCompraProducto;
    }

    public void setPrecioCompraProducto(double precioCompraProducto) {
        this.precioCompraProducto = precioCompraProducto;
    }

    public double getPrecioVentaProducto() {
        return precioVentaProducto;
    }

    public void setPrecioVentaProducto(double precioVentaProducto) {
        this.precioVentaProducto = precioVentaProducto;
    }

    public Integer getExistenciaProducto() {
        return existenciaProducto;
    }

    public void setExistenciaProducto(Integer existenciaProducto) {
        this.existenciaProducto = existenciaProducto;
    }

    public String getImgProducto() {
        return imgProducto;
    }

    public void setImgProducto(String imgProducto) {
        this.imgProducto = imgProducto;
    }

    public Integer getIdProveedorFK() {
        return idProveedorFK;
    }

    public void setIdProveedorFK(Integer idProveedorFK) {
        this.idProveedorFK = idProveedorFK;
    }
}
