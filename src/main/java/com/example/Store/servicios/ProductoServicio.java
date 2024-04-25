package com.example.Store.servicios;

import com.example.Store.helpers.ValidacionProducto;
import com.example.Store.modelos.Producto;
import com.example.Store.modelos.Usuario;
import com.example.Store.repositorios.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductoServicio {
    @Autowired
    ValidacionProducto validacionProducto;
    @Autowired
    ProductoRepositorio productoRepositorio;

    //guardar un producto
    public Producto guardarProducto(Producto datosProducto) throws Exception{
        try {
            if (!validacionProducto.validarNombre(datosProducto.getNombreProducto())){
                throw new Exception("Nombre invalido");
            }
            if (!validacionProducto.validarCantidadBodega(datosProducto.getCantidadBodega())){
                throw new Exception("Cantidad en bodega invalida");
            }
            if (!validacionProducto.validarDescripcion(datosProducto.getDescripcion())){
                throw new Exception("Descripción invalida");
            }if (!validacionProducto.validarTalla(datosProducto.getTalla())){
                throw new Exception("Talla invalida");
            }
            if (!validacionProducto.validarReferencia(datosProducto.getReferencia())){
                throw new Exception("Referencia invalida");
            }
            if (!validacionProducto.validarFotografia(datosProducto.getFotografia())){
                throw new Exception("Fotografia invalida");
            }
            if (!validacionProducto.validarPrecioUnitario(datosProducto.getPrecioUnitario())){
                throw new Exception("Precio unitario invalido");
            }
            return productoRepositorio.save(datosProducto);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }

    //consultar un producto en BD por ID
    public Producto buscarProductoPorId(Integer idProducto) throws Exception{
        try {
            if (productoRepositorio.findById(idProducto).isPresent()){
                return productoRepositorio.findById(idProducto).get();
            }else{
            throw new Exception("Producto no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }

    //consultar todos los usuarios
    public List<Producto> buscarTodosLosProductos()throws Exception{
        try {
            return productoRepositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //editar un producto
    public Producto modificarProducto(){
        return null;
    }

    //eliminar un producto
    public boolean eliminarProducto(){
        return true;
    }
}
