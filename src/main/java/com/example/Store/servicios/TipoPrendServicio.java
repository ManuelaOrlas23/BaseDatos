package com.example.Store.servicios;

import com.example.Store.helpers.ValidacionTipoPrenda;
import com.example.Store.modelos.TipoPrenda;
import com.example.Store.modelos.Usuario;
import com.example.Store.repositorios.TipoPrendaRepositorio;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TipoPrendServicio {

    @Autowired
    ValidacionTipoPrenda validacionTipoPrenda;
    @Autowired
    TipoPrendaRepositorio tipoPrendaRepositorio;

    //guardar tipo prenda
    public TipoPrenda guardarTipoPrenda(TipoPrenda datosTipoPrenda)throws Exception{
        try {
           if (!validacionTipoPrenda.validarNombre(datosTipoPrenda.getNombre())==false){
               throw new Exception("Nombre invalido");
           }
            return tipoPrendaRepositorio.save(datosTipoPrenda);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //consultar un tipo prenda en BD por ID
    public TipoPrenda buscarTipoPrendaPorId(Integer idTipoPrenda) throws Exception{
      try {
          if (tipoPrendaRepositorio.findById(idTipoPrenda).isPresent()){
              return tipoPrendaRepositorio.findById(idTipoPrenda).get();
          }else{
              throw new Exception("Prenda no encontrada");
          }
      }catch (Exception error){
          throw new Exception(error.getMessage());
      }

    }

    //consultar todos las tipo prenda
    public List<TipoPrenda> buscarTodosLasTipoPrenda()throws Exception{
        try {
            return tipoPrendaRepositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //editar un tipo prenda
    public TipoPrenda modificarTipoPrenda(){
        return null;
    }

    //eliminar un usuario
    public boolean eliminarTipoPrenda(){
        return true;
    }
}
