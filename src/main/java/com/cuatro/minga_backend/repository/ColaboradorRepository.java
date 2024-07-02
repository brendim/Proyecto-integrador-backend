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
    List<Colaborador> findByComunasIn(List<Comuna> comunas);
    List<Colaborador> findByComunasInAndDisponibilidad(List<Comuna> comunas, Byte disponibilidad);
    List<Colaborador> findByComunasInAndPuntuacion(List<Comuna> comunas, Integer puntuacion);
    //Busqueda por categoria
    List<Colaborador> findByCategoriasIn(List<Categoria> categorias);
    List<Colaborador> findByCategoriasInAndDisponibilidad(List<Categoria> categorias, Byte disponibilidad);
    List<Colaborador> findByCategoriasInAndPuntuacion(List<Categoria> categorias, Integer puntuacion);
    
    boolean existsByRut(String rut);
    boolean existsByEmail(String email);
    /* Comentada porque genera problemas con JPA, que aun no entendemos */
    /* boolean existByCelular(String celular); */
}
