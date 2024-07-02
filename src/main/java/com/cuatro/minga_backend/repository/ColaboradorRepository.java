package com.cuatro.minga_backend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuatro.minga_backend.models.Colaborador;
import com.cuatro.minga_backend.models.Comuna;
import com.cuatro.minga_backend.models.Categoria;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long>{
    Colaborador findByRut(String rut);
    Colaborador findByNombre(String nombre);
    Colaborador findByApellidoPaterno(String apellidoPaterno);
    Colaborador findByApellidoMaterno(String apellidoMaterno);
    Colaborador findByNombreAndApellidoPaterno(String nombre, String apellidoPaterno);
    Colaborador findByNombreAndApellidoMaterno(String nombre, String apellidoMaterno);
    Colaborador findByNombreAndApellidoPaternoAndApellidoMaterno(String nombre, String apellidoPaterno, String apellidoMaterno);
    Colaborador findByApellidoPaternoAndApellidoMaterno(String apellidoPaterno, String apellidoMaterno);
    Colaborador findByEmail(String email);
    Colaborador findByCelular(String celular);
    Colaborador findByPassword(String password);
    Colaborador findByDisponibilidad(Byte disponibilidad);
    Colaborador findByPuntuacion(Integer puntuacion);
    Colaborador findByDisponibilidadAndPuntuacion(Byte disponibilidad, Integer puntuacion);
    Colaborador findByRutAndPassword(String rut, String password);
    //Busqueda por comuna
    List<Colaborador> findByComunaIn(List<Comuna> comunas);
    List<Colaborador> findByComunaInAndDisponibilidad(List<Comuna> comunas, Byte disponibilidad);
    List<Colaborador> findByComunaInAndPuntuacion(List<Comuna> comunas, Integer puntuacion);
    //Busqueda por categoria
    List<Colaborador> findByCategoriaIn(List<Categoria> categorias);
    List<Colaborador> findByCategoriaInAndDisponibilidad(List<Categoria> categorias, Byte disponibilidad);
    List<Colaborador> findByCategoriaInAndPuntuacion(List<Categoria> categorias, Integer puntuacion);
    
    boolean existsByRut(String rut);
    boolean existsByEmail(String email);
    boolean existByCelular(String celular);
    

}
