package com.krevolorio.myappkapa.basededatossw;

public class ProductoVO {
    private Integer idProducto;
    private String descripcionProducto;
    private String marcaProducto;
    private String presentacionProducto;
    private String categoriaProducto;
    private Double precioCompraProducto;
    private Double precioVentaProducto;
    private Integer existenciaProducto;
    private String imgProducto;
    private Integer idProveedor_fk;
    private String nombreProveedorProducto;

    //CONSTRUCTOR VACIO
    public ProductoVO() {
    }

    //COMPLETO
    public ProductoVO(Integer idProducto, String descripcionProducto, String marcaProducto,
                      String presentacionProducto, String categoriaProducto, Double precioCompraProducto,
                      Double precioVentaProducto, Integer existenciaProducto, String imgProducto,
                      Integer idProveedor_fk, String nombreProveedorProducto) {
        this.idProducto = idProducto;
        this.descripcionProducto = descripcionProducto;
        this.marcaProducto = marcaProducto;
        this.presentacionProducto = presentacionProducto;
        this.categoriaProducto = categoriaProducto;
        this.precioCompraProducto = precioCompraProducto;
        this.precioVentaProducto = precioVentaProducto;
        this.existenciaProducto = existenciaProducto;
        this.imgProducto = imgProducto;
        this.idProveedor_fk = idProveedor_fk;
        this.nombreProveedorProducto = nombreProveedorProducto;
    }

    //CONSTRUCTOR VISTA RAPIDA  EN MAIN


    public ProductoVO(Integer idProducto, String descripcionProducto, String presentacionProducto,
                      String categoriaProducto, Double precioVentaProducto) {
        this.idProducto = idProducto;
        this.descripcionProducto = descripcionProducto;
        this.presentacionProducto = presentacionProducto;
        this.categoriaProducto = categoriaProducto;
        this.precioVentaProducto = precioVentaProducto;
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

    public Double getPrecioCompraProducto() {
        return precioCompraProducto;
    }

    public void setPrecioCompraProducto(Double precioCompraProducto) {
        this.precioCompraProducto = precioCompraProducto;
    }

    public Double getPrecioVentaProducto() {
        return precioVentaProducto;
    }

    public void setPrecioVentaProducto(Double precioVentaProducto) {
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

    public Integer getIdProveedor_fk() {
        return idProveedor_fk;
    }

    public void setIdProveedor_fk(Integer idProveedor_fk) {
        this.idProveedor_fk = idProveedor_fk;
    }

    public String getNombreProveedorProducto() {
        return nombreProveedorProducto;
    }

    public void setNombreProveedorProducto(String nombreProveedorProducto) {
        this.nombreProveedorProducto = nombreProveedorProducto;
    }
}
