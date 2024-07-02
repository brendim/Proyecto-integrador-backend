package com.cuatro.minga_backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuatro.minga_backend.models.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    


    //Buscar por id
    

    //Buscar por nombre
    Categoria findByName(String nombre);

    //Buscar por subcategoria
    Categoria findBySubCategoria(String subcategoria);

   
}
