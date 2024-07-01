package com.cuatro.minga_backend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuatro.minga_backend.models.Colaborador;
import com.cuatro.minga_backend.models.Comuna;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long>{
    Colaborador findByRut(String rut);
    Colaborador findByNombre(String nombre);
    Colaborador findByApellidoPaterno(String apellidoPaterno);
    Colaborador findByApellidoMaterno(String apellidoMaterno);
    Colaborador findByNombreAndApellidoPaterno(String nombre, String apellidoPaterno);
    Colaborador findByNombreAndApellidoMaterno(String nombre, String apellidoMaterno);
    Colaborador findyByNombreAndApellidoPaternoAndApellidoMaterno(String nombre, String apellidoPaterno, String apellidoMaterno);
    Colaborador findByApellidoMaternoAndApellidoPaterno(String apellidoPaterno, String apellidoMaterno);
    Colaborador findByEmail(String email);
    Colaborador findByCelular(String celular);
    Colaborador findByPassword(String password);
    Colaborador findByDisponibilidad(Byte disponibilidad);
    Colaborador findByPuntuacion(Integer puntuacion);
    Colaborador findByDisponibilidadAndPuntuacion(Byte disponibilidad, Integer puntuacion);
    Colaborador findByRutAndPassword(String rut, String password);
    //Busqueda por comuna
    Colaborador findByComuna(List<Comuna> comunas);
    Colaborador findByComunaAndDisponibilidad(List<Comuna> comunas, Byte disponibilidad);
    Colaborador findByComunaAndPuntuacion(List<Comuna> comunas, Integer puntuacion);
    
    boolean existsByRut(String rut);
    boolean existsByEmail(String email);
    boolean existByCelular(String celular);
    

}
