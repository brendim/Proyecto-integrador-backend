package com.cuatro.minga_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuatro.minga_backend.models.Resena;
import com.cuatro.minga_backend.models.Usuario;

@Repository
public interface ResenaRepository extends JpaRepository<Resena, Long>{


/* Buscar por valoración del 1 al 5 */
    List <Resena> finByValoracion(String valoracion);


/*Buscar por contenido */
List <Resena> finByContenido(String contenido);


} 