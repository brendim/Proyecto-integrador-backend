package com.cuatro.minga_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuatro.minga_backend.models.Resena;

@Repository
public interface ResenaRepository extends JpaRepository<Resena, Long>{

    /* Buscar por valoración del 1 al 5 */
    List <Resena> findByValoracion(String valoracion);

    /*Buscar por contenido */
    List <Resena> findByContenido(String contenido);
} 