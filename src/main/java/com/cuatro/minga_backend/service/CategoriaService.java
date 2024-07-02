package com.cuatro.minga_backend.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuatro.minga_backend.models.Categoria;
import com.cuatro.minga_backend.repository.CategoriaRepository;

@Service
public class CategoriaService {

        @Autowired
        private CategoriaRepository categoriaRepository;

    //Métodos personalizados
    //Pensando en CRUD (Create, Read, Update, Delete)

    //Obtener categoria por id
    public Categoria getCategoriaById(Long id){
        return categoriaRepository.findById(id).orElse(null);
    }

    //Obtener todas los categorias
    public List<Categoria> getAllCategoria(){
        return categoriaRepository.findAll();
    }

    //Guardar categoria
    public Categoria createCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    //Eliminar categoria
    public void deleteCategoria(Categoria categoria){
        categoriaRepository.delete(categoria);
    }

    //Actualizar categoria
    public Categoria updateCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }



    
}
