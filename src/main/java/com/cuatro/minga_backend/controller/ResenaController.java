package com.cuatro.minga_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cuatro.minga_backend.models.Resena;
import com.cuatro.minga_backend.service.ResenaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController


@RequestMapping("/api/resenas")
 
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
    public Resena saveResena(Resena resena){
    return resenaService.createResena(resena);
    }

    @DeleteMapping
    public void deleteResena(Resena resena){
        resenaService.deleteResena(resena);
    }
}
