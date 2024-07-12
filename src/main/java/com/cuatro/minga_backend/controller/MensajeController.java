package com.cuatro.minga_backend.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cuatro.minga_backend.models.Mensaje;
import com.cuatro.minga_backend.service.MensajeService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping ("/api/mensajes")
@CrossOrigin("*")
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
    public ResponseEntity<Mensaje> createMensaje(@RequestBody Mensaje mensaje, @RequestParam Long usuarioId, @RequestParam Long colaboradorId) {
        Mensaje savedMensaje = mensajeService.createMensaje(mensaje, usuarioId, colaboradorId);
        return ResponseEntity.ok(savedMensaje);
    }
    
    @DeleteMapping
    public void deleteMensaje (Mensaje mensaje){
        mensajeService.deleteMensaje(mensaje);
    }

    @GetMapping("/{userType}/{userId}")
    public ResponseEntity<List<Mensaje>> getMessages(@PathVariable String userType, @PathVariable Long userId) {
        List<Mensaje> mensajes;
        if ("usuario".equals(userType)) {
            mensajes = mensajeService.getMessagesByUsuarioId(userId);
        } else if ("colaborador".equals(userType)) {
            mensajes = mensajeService.getMessagesByColaboradorId(userId);
        } else {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(mensajes);
    }
    
}
