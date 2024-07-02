
package com.cuatro.minga_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuatro.minga_backend.models.Comuna;

@Repository
public interface ComunaRepository extends JpaRepository<Comuna, Long> {
    
    // Métodos incluidos en JpaRepository, no es necesario declararlos
    // List<Comuna> findAll();
    // Comuna save(Comuna comuna);
    // void delete(Comuna comuna);
    // Comuna findById(Long id);
    // boolean existsById(Long id);
    // long count();
    // void deleteById(Long id);
    // void deleteAll();
    // etc...

    // Métodos personalizados

    // Buscar por nombre
    Comuna findByNombre(String nombre);

    // Comprobar si existe una comuna con ese nombre
    boolean existsByNombre(String nombre);
}
