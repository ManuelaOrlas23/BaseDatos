package com.example.Store.servicios;

import com.example.Store.helpers.ValidacionPedido;
import com.example.Store.modelos.Pedido;
import com.example.Store.modelos.Usuario;
import com.example.Store.repositorios.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PedidoServicio {
    @Autowired
    ValidacionPedido validacionPedido;
    @Autowired
    PedidoRepositorio pedidoRepositorio;

    //guardar un Pedido
    public Pedido guardarPedido(Pedido datosPedido) throws Exception{
        try {
            if (!validacionPedido.validarFechaYHora(datosPedido.getFechaYHora().toLocalDate())){
                throw new Exception("Fecha y hora invalidos");
            }
            return pedidoRepositorio.save(datosPedido);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }

    //consultar un pedido en BD por ID
    public Pedido buscarPedidoPorId(Integer idPedido)throws Exception{
        try {
            if (pedidoRepositorio.findById(idPedido).isPresent()){
                return pedidoRepositorio.findById(idPedido).get();
            }else {
                throw new Exception("pedido no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }

    //consultar todos los pedidos
    public List<Pedido> buscarTodosLosPedidos()throws Exception{
        try {
            return pedidoRepositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //editar un pedido
    public Pedido modificarPedido(){
        return null;
    }

    //eliminar un pedido
    public boolean eliminarPedido(){
        return true;
    }
}
