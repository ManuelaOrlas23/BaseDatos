package com.example.Store.servicios;

import com.example.Store.helpers.ValidacionDetalle;
import com.example.Store.modelos.Detalle;
import com.example.Store.modelos.Usuario;
import com.example.Store.repositorios.DetalleRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DetalleServicio {
    @Autowired
    ValidacionDetalle validacionDetalle;
    @Autowired
    DetalleRepositorio detalleRepositorio;

    //guardar un detalle
    public Detalle guardarDetalle(Detalle datosDetalle) throws Exception{
        try {
            if (!validacionDetalle.validarCantidadProductos(datosDetalle.getCantidadProductos())){
                throw new Exception("Cantidad de productos invalida");
            }
            if (!validacionDetalle.validarCostoTotal(datosDetalle.getCostoTotal())){
                throw new Exception("Costo total invalido");
            }
            return detalleRepositorio.save(datosDetalle);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }

    //consultar un detalle en BD por ID
    public Detalle buscarDetallePorId(Integer idDetalle)throws Exception{
        try {
            if (detalleRepositorio.findById(idDetalle).isPresent()){
                return detalleRepositorio.findById(idDetalle).get();
            }else {
                throw new Exception("Detalle no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //consultar todos los detalles
    public List<Detalle> buscarTodosLosDetalles()throws Exception{
        try {
            return detalleRepositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //editar un detalle
    public Detalle modificarDetalle(){
        return null;
    }

    //eliminar un detalle
    public boolean eliminarDetalle(){
        return true;
    }
}
