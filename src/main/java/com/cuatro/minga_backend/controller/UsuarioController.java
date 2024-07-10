package com.cuatro.minga_backend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cuatro.minga_backend.models.Comuna;
import com.cuatro.minga_backend.service.ComunaService;
import com.cuatro.minga_backend.models.Usuario;
import com.cuatro.minga_backend.service.UsuarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin("*")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ComunaService comunaService;

    //Métodos de la API

    //Obtener todos los usuarios
    @GetMapping
    public List<Usuario> getAllUsuarios(){
        return usuarioService.getAllUsuarios();
    }

    //Obtener usuario por id
    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable Long id){
        return usuarioService.getUsuarioById(id);
    }

    //Guardar usuario
    @PostMapping("/nuevo")
    public Usuario saveUsuario(@RequestBody Usuario usuario, @RequestParam String comuna){
        usuario.setComuna(comunaService.findByNombre(comuna));
        return usuarioService.createUsuario(usuario);
    }

    //Eliminar usuario
    @DeleteMapping("/deleteUsuario")
    public void deleteUsuarioById(@RequestParam Usuario usuario){
        usuarioService.deleteUsuario(usuario);
    }

    //Inicio de sesion
    @GetMapping("/usuarioLogin")
    public Usuario getUsuarioByEmailAndPassword(
        @RequestParam String email, 
        @RequestParam String password){
            return usuarioService.getUsuarioByEmailAndPassword(email, password);
    }
}