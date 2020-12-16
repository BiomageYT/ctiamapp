package com.ufps.ctiam20.modelo;

public class Producto {

    public String id;
    public String id_tienda;
    public String id_categoria;
    public String id_marca;
    public String id_estado;
    public String titulo;
    public String descripcion;
    public String detalle;
    public String precio;
    public String fecha;
    public String stock;
    public String imagen;

    public Producto(String id, String id_tienda, String id_categoria, String id_marca, String id_estado, String titulo, String descripcion, String detalle, String precio, String fecha, String stock, String imagen) {
        this.id = id;
        this.id_tienda = id_tienda;
        this.id_categoria = id_categoria;
        this.id_marca = id_marca;
        this.id_estado = id_estado;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.precio = precio;
        this.fecha = fecha;
        this.stock = stock;
        this.imagen = imagen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_tienda() {
        return id_tienda;
    }

    public void setId_tienda(String id_tienda) {
        this.id_tienda = id_tienda;
    }

    public String getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(String id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getId_marca() {
        return id_marca;
    }

    public void setId_marca(String id_marca) {
        this.id_marca = id_marca;
    }

    public String getId_estado() {
        return id_estado;
    }

    public void setId_estado(String id_estado) {
        this.id_estado = id_estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
