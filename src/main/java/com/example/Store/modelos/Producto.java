package com.example.Store.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_producto;
    @Column(name = "nombreProducto",nullable = false, length = 60)
    private String nombreProducto; // no vacio, solo letras y espacios- longitud 60
    @Column(name = "referencia",nullable = false, length = 50)
    private String referencia; // no vacio longitud 14
    @Column(name = "talla",nullable = false, length = 5)
    private String talla; // maximo 3 caracteres
    @Column(name = "cantidadBodega",nullable = false)
    private Integer cantidadBodega; // solo numeros positivos
    @Column(name = "precioUnitario",nullable = false)
    private Integer precioUnitario; // solo numeros positivos
    @Column(name = "descripcion",nullable = true, length = 100)
    private String descripcion; // longitud maxima 100
    @Column(name = "fotografia")
    private String fotografia; // no vacio, maximo 255

    @ManyToOne
    @JoinColumn(name = "id_detalle", referencedColumnName = "id_detalle")
    Detalle detalle;


    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_marca", referencedColumnName = "id_marca")
    Marca marca;

    @ManyToOne
    @JoinColumn(name = "id_tipo_prenda", referencedColumnName = "id_tipo_prenda")
    TipoPrenda tipoPrenda;

    public Producto() {
    }

    public Producto(Integer id_producto, String nombreProducto, String referencia, String talla, Integer cantidadBodega, Integer precioUnitario, String descripcion, String fotografia, Detalle detalle, Marca marca, TipoPrenda tipoPrenda) {
        this.id_producto = id_producto;
        this.nombreProducto = nombreProducto;
        this.referencia = referencia;
        this.talla = talla;
        this.cantidadBodega = cantidadBodega;
        this.precioUnitario = precioUnitario;
        this.descripcion = descripcion;
        this.fotografia = fotografia;
        this.detalle = detalle;
        this.marca = marca;
        this.tipoPrenda = tipoPrenda;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public Integer getCantidadBodega() {
        return cantidadBodega;
    }

    public void setCantidadBodega(Integer cantidadBodega) {
        this.cantidadBodega = cantidadBodega;
    }

    public Integer getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Integer precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public Detalle getDetalle() {
        return detalle;
    }

    public void setDetalle(Detalle detalle) {
        this.detalle = detalle;
    }

    public TipoPrenda getTipoPrenda() {
        return tipoPrenda;
    }

    public void setTipoPrenda(TipoPrenda tipoPrenda) {
        this.tipoPrenda = tipoPrenda;
    }
}
