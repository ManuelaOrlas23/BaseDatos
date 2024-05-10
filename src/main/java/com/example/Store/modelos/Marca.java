package com.example.Store.modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "marcas")

public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_marca;
    @Column(name = "nombreMarca",nullable = false, length = 50)
    private String nombreMarca; // no vacio obligario y maximo 50
    @Column(name = "nit",nullable = false, length = 20)
    private String nit; //  solo numeros y maximo 10
    @Column(name = "anoCreacion",nullable = true)
    private String  anoCreacion;// obligario
    @Column(name = "sedePrincipal",nullable = true, length = 30)
    private String sedePrincipal; // no se valida

    @OneToMany(mappedBy = "marca")
    @JsonManagedReference
    private List<Producto> productos = new ArrayList<Producto>();


    public Marca() {
    }

    public Marca(Integer id_marca, String nombreMarca, String nit, String anoCreacion, String sedePrincipal, List<Producto> productos) {
        this.id_marca = id_marca;
        this.nombreMarca = nombreMarca;
        this.nit = nit;
        this.anoCreacion = anoCreacion;
        this.sedePrincipal = sedePrincipal;
        this.productos = productos;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getAnoCreacion() {
        return anoCreacion;
    }

    public void setAnoCreacion(String anoCreacion) {
        this.anoCreacion = anoCreacion;
    }

    public String getSedePrincipal() {
        return sedePrincipal;
    }

    public void setSedePrincipal(String sedePrincipal) {
        this.sedePrincipal = sedePrincipal;
    }

    public Integer getId_marca() {
        return id_marca;
    }

    public void setId_marca(Integer id_marca) {
        this.id_marca = id_marca;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
