package com.cuatro.minga_backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cuatro.minga_backend.models.Comuna;
import com.cuatro.minga_backend.service.ComunaService;

@RestController
@RequestMapping("/api/comunas")
@CrossOrigin("*")
public class ComunaController {

    @Autowired
    private ComunaService comunaService;

    @GetMapping
    public List<Comuna> getAllComunas() {
        return comunaService.getAllComunas();
    }

    @GetMapping("/{id}")
    public Optional<Comuna> getComunaById(@PathVariable Long id) {
        return comunaService.getComunaById(id);
    }

    @PostMapping
    public Comuna createComuna(@RequestBody Comuna comuna) {
        return comunaService.createComuna(comuna);
    }

    @PutMapping("/{id}")
    public Comuna updateComuna(@PathVariable Long id, @RequestBody Comuna comunaDetails) {
        return comunaService.updateComuna(id, comunaDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteComuna(@PathVariable Long id) {
        comunaService.deleteComuna(id);
    }
}
