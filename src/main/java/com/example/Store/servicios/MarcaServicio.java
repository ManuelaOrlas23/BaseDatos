package com.example.Store.servicios;

import com.example.Store.helpers.ValidacionMarca;
import com.example.Store.modelos.Marca;
import com.example.Store.modelos.Usuario;
import com.example.Store.repositorios.MarcaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class MarcaServicio {
    @Autowired
    ValidacionMarca validacionMarca;
    @Autowired
    MarcaRepositorio marcaRepositorio;

    //guardar una marca
    public Marca guardarmarca(Marca datosMarca) throws Exception{
        try {
            if (!validacionMarca.validarAno(datosMarca.getAnoCreacion())){
                throw new Exception("Año invalido");
            }
            if (!validacionMarca.validarNombreMarca(datosMarca.getNombreMarca())){
                throw new Exception("Nombre de marca invalido");
            }
            if (!validacionMarca.validarNit(datosMarca.getNit())){
                throw new Exception("Nit invalido");
            }
            return marcaRepositorio.save(datosMarca);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }

    //consultar una marca en BD por ID
    public Marca buscarMarcaPorId(Integer idMarca) throws Exception{
        try {
            if (marcaRepositorio.findById(idMarca).isPresent()){
                return marcaRepositorio.findById(idMarca).get();
            }else {
                throw new Exception("Marca no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }

    //consultar todos las marcas
    public List<Marca> buscarTodosLasMarcas()throws Exception{
        try {
            return marcaRepositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //editar una marca
    public Marca modificarMarca(){
        return null;
    }

    //eliminar una marca
    public boolean eliminarMarca(){
        return true;
    }
}
