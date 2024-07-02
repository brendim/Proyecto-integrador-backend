
package com.cuatro.minga_backend.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cuatro.minga_backend.models.Categoria;
import com.cuatro.minga_backend.service.CategoriaService;


@RestController
@RequestMapping("/api/categorias")

public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    //Métodos de la API

    //Obtener todos los categoria
    @GetMapping
    public List<Categoria> getAllCategorias(){
        return categoriaService.getAllCategoria();
    }

    //Obtener categoria por id
    @GetMapping("/{id}")
    public Categoria getCategoriaById(Long id){
        return categoriaService.getCategoriaById(id);
    }

    //Guardar categoria
    @PostMapping
    public Categoria saveCategoria(Categoria categoria){
        return categoriaService.createCategoria(categoria);
    }

    //Eliminar categoria
    @DeleteMapping
    public void deleteCategoria(Categoria categoria){
        categoriaService.deleteCategoria(categoria);
    }


    //UPDATE
    @PutMapping
    public Categoria updateCategoria(Long id, Categoria categoria) {
        categoria.setId(id);
        return categoriaService.updateCategoria(categoria);
    }
}
