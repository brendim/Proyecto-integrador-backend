package com.cuatro.minga_backend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cuatro.minga_backend.models.Usuario;
import com.cuatro.minga_backend.service.UsuarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    //Métodos de la API

    //Obtener todos los usuarios
    @GetMapping
    public List<Usuario> getAllUsuarios(){
        return usuarioService.getAllUsuarios();
    }

    //Obtener usuario por id
    @GetMapping("/{id}")
    public Usuario getUsuarioById(Long id){
        return usuarioService.getUsuarioById(id);
    }

    //Guardar usuario
    @PostMapping
    public Usuario saveUsuario(Usuario usuario){
        return usuarioService.createUsuario(usuario);
    }

    //Eliminar usuario
    @DeleteMapping
    public void deleteUsuario(Usuario usuario){
        usuarioService.deleteUsuario(usuario);
    }
}
