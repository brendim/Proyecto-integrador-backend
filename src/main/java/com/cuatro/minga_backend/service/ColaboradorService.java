package com.cuatro.minga_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuatro.minga_backend.models.Colaborador;
import com.cuatro.minga_backend.repository.ColaboradorRepository;

@Service
public class ColaboradorService {
    
    @Autowired
    private ColaboradorRepository colaboradorRepository;
    // @AutoWired private ComunaRepository comunaRepository
    // @AutoWired private CategoriasRepository categoriaRepository
    public Colaborador getColaboradorByID(long id){
        return colaboradorRepository.findById(id).orElse(null);
    }
    public Colaborador getColaboradorByRut(String rut){
        return colaboradorRepository.findByRut(rut);
    } 
    public List<Colaborador> getAllColaboradores(){
        return colaboradorRepository.findAll();
    }
    public Colaborador createColaborador(Colaborador colaborador){
        return colaboradorRepository.save(colaborador);
    }
    public void deleteColaborador(Colaborador colaborador){
        colaboradorRepository.delete(colaborador);
    }
    public Colaborador updateColaborador(Colaborador colaborador){
        return colaboradorRepository.save(colaborador);
    }
    
}



