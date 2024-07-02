package com.cuatro.minga_backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cuatro.minga_backend.models.Comuna;
import com.cuatro.minga_backend.repository.ComunaRepository;

@RestController
@RequestMapping("/comunas")
public class ComunaController {

    @Autowired
    private ComunaRepository comunaRepository;

    @GetMapping
    public List<Comuna> getAllComunas() {
        return comunaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Comuna> getComunaById(@PathVariable Long id) {
        return comunaRepository.findById(id);
    }

    @PostMapping
    public Comuna createComuna(@RequestBody Comuna comuna) {
        return comunaRepository.save(comuna);
    }

    @PutMapping("/{id}")
    public Comuna updateComuna(@PathVariable Long id, @RequestBody Comuna comunaDetails) {
        Comuna comuna = comunaRepository.findById(id).orElseThrow();
        comuna.setNombre(comunaDetails.getNombre());

        return comunaRepository.save(comuna);
    }

    @DeleteMapping("/{id}")
    public void deleteComuna(@PathVariable Long id) {
        comunaRepository.deleteById(id);
    }
}
