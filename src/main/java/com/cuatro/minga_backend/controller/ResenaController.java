package com.cuatro.minga_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cuatro.minga_backend.models.Mensaje;
import com.cuatro.minga_backend.models.Resena;
import com.cuatro.minga_backend.service.ResenaService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/resenas")
@CrossOrigin("*")
public class ResenaController {
    
    @Autowired
    private ResenaService resenaService;

    @GetMapping
    public List<Resena> getAllResenas(){
        return resenaService.getAllResenas();
    }
    
    @GetMapping("/{id}")
    public Resena getResenaById(@PathVariable Long id){
        return resenaService.getResenaById(id);
    }

    @PostMapping
    public ResponseEntity<Resena> createResena(@RequestBody Resena resena, @RequestParam Long usuarioId, @RequestParam Long colaboradorId) {
        Resena savedResena = resenaService.createResena(resena, usuarioId, colaboradorId);
        return ResponseEntity.ok(savedResena);
    }

    @DeleteMapping
    public void deleteResena(Resena resena){
        resenaService.deleteResena(resena);
    }

    /* Obtener todas las reseñas realizadas a un colaborador */
    @GetMapping("/colaborador/{id}")
    public ResponseEntity<List<Resena>> getResenasByColaboradorId(@PathVariable Long id) {
        List<Resena> resenas = resenaService.getResenasByColaboradorId(id);
        if (resenas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resenas);
    }
}
