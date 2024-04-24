package com.example.Store.servicios;

import com.example.Store.helpers.ValidacionUsuario;
import com.example.Store.modelos.Usuario;
import com.example.Store.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UsuarioServicio {

    //en los servicios debo inyectar las dependencias de
    //1. las validaciones
    //2. las consultas o repositorios

    @Autowired
    ValidacionUsuario validacionUsuario;
    @Autowired
    UsuarioRepositorio usuarioRepositorio;


    //en el servicio se crea un metodo para
    //cada una de las consultas a realizar en BD

    //guardar un usuario
    public Usuario guardarUsuario(Usuario datosUsuario) throws Exception{
        try {
            if (!validacionUsuario.validarNombres(datosUsuario.getNombres())) {
                throw new Exception("Nombres invalidos, revise por favor");
            }
            if (!validacionUsuario.validarCedula(datosUsuario.getCedula())){
                throw new Exception("Cedula invalida");
            }
            if (!validacionUsuario.validarCorreo(datosUsuario.getCorreo())){
                throw new Exception("Correo invalido");
            }
            if (!validacionUsuario.validarSexo(datosUsuario.getSexo())){
                throw new Exception("Sexo invalido");
            }
            if (!validacionUsuario.validarCodigoPostal(datosUsuario.getCodigoPostal())){
                throw new Exception("Codigo postal invalido");
            }
            return usuarioRepositorio.save(datosUsuario);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //consultar un usuario en BD por ID
    public Usuario buscarUsuarioPorId(Integer idUsuario) throws Exception{
        try {
            if (usuarioRepositorio.findById(idUsuario).isPresent()){
                return usuarioRepositorio.findById(idUsuario).get();
            }else{
                throw new Exception("Usuario no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //consultar todos los usuarios
    public List<Usuario> buscarTodosLosUsuario()throws Exception{
        try {
            return usuarioRepositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //editar un usuario
    public Usuario modificarUsuario(){
        return null;
    }

    //eliminar un usuario
    public boolean eliminarUsuario(){
        return true;
    }
}
