package com.cuatro.minga_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cuatro.minga_backend.models.Colaborador;
import com.cuatro.minga_backend.models.Resena;
import com.cuatro.minga_backend.models.Usuario;
import com.cuatro.minga_backend.repository.ColaboradorRepository;
import com.cuatro.minga_backend.repository.ResenaRepository;
import com.cuatro.minga_backend.repository.UsuarioRepository;

@Service

public class ResenaService {

    @Autowired
    private ResenaRepository resenaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ColaboradorRepository colaboradorRepository;

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
    @Transactional
    public Resena createResena(Resena resena, Long usuarioId, Long colaboradorId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Colaborador colaborador = colaboradorRepository.findById(colaboradorId).orElseThrow(() -> new RuntimeException("Colaborador no encontrado"));
        
        resena.setUsuario(usuario);
        resena.setColaborador(colaborador);
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


    
