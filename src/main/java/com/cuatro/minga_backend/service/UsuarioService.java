package com.cuatro.minga_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuatro.minga_backend.models.Usuario;
import com.cuatro.minga_backend.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    //Métodos personalizados
    //Pensando en CRUD (Create, Read, Update, Delete)

    //Obtener usuario por id
    public Usuario getUsuarioById(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }

    //Obtener todos los usuarios
    public List<Usuario> getAllUsuarios(){
        return usuarioRepository.findAll();
    }

    //Guardar usuario
    public Usuario createUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    //Eliminar usuario
    public void deleteUsuario(Usuario usuario){
        usuarioRepository.delete(usuario);
    }

    //Actualizar usuario
    public Usuario updateUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    //Obtener usuario por email y password
    public Usuario getUsuarioByEmailAndPassword(String email, String password){
        return usuarioRepository.findByEmailAndPassword(email, password);
    }

}
