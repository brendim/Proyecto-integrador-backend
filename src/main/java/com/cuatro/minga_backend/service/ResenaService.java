package com.cuatro.minga_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuatro.minga_backend.models.Resena;
import com.cuatro.minga_backend.repository.ResenaRepository;

@Service

public class ResenaService {

    @Autowired
    private ResenaRepository resenaRepository;

    //Métodos personalizados
    //Pensando en CRUD (Create, Read, Update, Delete)

    //Obtener reseña por id
    public Resena getResenaById(Long id){
        return resenaRepository.findById(id).orElse(null);
    }

    //Obtener todas las reseñas
    public List<Resena> getAllResenas(){
        return resenaRepository.findAll();
    }

    //Guardar reseña
    public Resena createResena(Resena resena){
        return resenaRepository.save(resena);
    }

    //Eliminar reseña
    public void deleteResena(Resena resena){
        resenaRepository.delete(resena);
    }

    //Obtener reseñas por colaborador
    public List<Resena> getResenasByColaboradorId(Long colaboradorId) {
        return resenaRepository.findByColaboradorId(colaboradorId);
    }
}


    
