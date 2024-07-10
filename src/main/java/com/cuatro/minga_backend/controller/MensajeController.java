package com.cuatro.minga_backend.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cuatro.minga_backend.models.Mensaje;
import com.cuatro.minga_backend.service.MensajeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping ("/api/mensajes")
public class MensajeController {
    
    @Autowired
    private MensajeService mensajeService;

    @GetMapping 
    public List<Mensaje> getAllMensajes() {
        return mensajeService.getAllMensajes();
    }

    @GetMapping("/{id}")
    public Mensaje getMensajeById(@PathVariable Long id){
        return mensajeService.getMensajeById(id);
    }
    
    @PostMapping
    public Mensaje saveMensaje(Mensaje mensaje){
        return mensajeService.createMensaje(mensaje);
    }
    
    @DeleteMapping
    public void deleteMensaje (Mensaje mensaje){
        mensajeService.deleteMensaje(mensaje);
    }
}
