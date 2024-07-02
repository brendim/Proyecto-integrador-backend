package com.cuatro.minga_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuatro.minga_backend.models.Comuna;
import com.cuatro.minga_backend.repository.ComunaRepository;

@Service
public class ComunaService {

    @Autowired
    private ComunaRepository comunaRepository;

    // Obtener todas las comunas
    public List<Comuna> getAllComunas() {
        return comunaRepository.findAll();
    }

    // Obtener 1 comuna por ID
    public Optional<Comuna> getComunaById(Long id) {
        return comunaRepository.findById(id);
    }

    // Crear una nueva comuna
    public Comuna createComuna(Comuna comuna) {
        return comunaRepository.save(comuna);
    }

    // Actualizar una comuna existente
    public Comuna updateComuna(Long id, Comuna comunaDetails) {
        Comuna comuna = comunaRepository.findById(id).orElseThrow();
        comuna.setNombre(comunaDetails.getNombre());
        return comunaRepository.save(comuna);
    }

    // Eliminar una comuna por ID
    public void deleteComuna(Long id) {
        comunaRepository.deleteById(id);
    }

    // Buscar comuna por nombre
    public Comuna findByNombre(String nombre) {
        return comunaRepository.findByNombre(nombre);
    }

    // Comprobar si una comuna existe por nombre
    public boolean existsByNombre(String nombre) {
        return comunaRepository.existsByNombre(nombre);
    }
}
