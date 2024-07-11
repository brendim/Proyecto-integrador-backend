package com.cuatro.minga_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuatro.minga_backend.models.Categoria;
import com.cuatro.minga_backend.models.Colaborador;
import com.cuatro.minga_backend.models.Comuna;
import com.cuatro.minga_backend.repository.ColaboradorRepository;

@Service
public class ColaboradorService {
    
    @Autowired
    private ColaboradorRepository colaboradorRepository;
    //@AutoWired private ComunaRepository comunaRepository
    // @AutoWired private CategoriasRepository categoriaRepository
    public Colaborador getColaboradorByID(long id){
        return colaboradorRepository.findById(id).orElse(null);
    }
    public Colaborador getColaboradorByRut(String rut){
        return colaboradorRepository.findByRut(rut);
    } 
    public Colaborador getColaboradorbyNombre(String nombre){
        return colaboradorRepository.findByNombre(nombre.toLowerCase());
    }
    public Colaborador getColaboradorByApellidoPaterno(String apellidoPaterno) {
        return colaboradorRepository.findByApellidoPaterno(apellidoPaterno.toLowerCase());
    }
    public Colaborador getColaboradorByApellidoMaterno(String apellidoMaterno) {
        return colaboradorRepository.findByApellidoMaterno(apellidoMaterno.toLowerCase());
    }
    public Colaborador getColaboradorByNombreAndApellidoPaterno(String nombre, String apellidoPaterno) {
        return colaboradorRepository.findByNombreAndApellidoPaterno(nombre.toLowerCase(), apellidoPaterno.toLowerCase());
    }
    public Colaborador getColaboradorByNombreAndApellidoMaterno(String nombre, String apellidoMaterno) {
        return colaboradorRepository.findByNombreAndApellidoMaterno(nombre.toLowerCase(), apellidoMaterno.toLowerCase());
    }
    public Colaborador getColaboradorByApellidoPaternoAndApellidoMaterno(String apellidoPaterno, String apellidoMaterno) {
        return colaboradorRepository.findByApellidoPaternoAndApellidoMaterno(apellidoPaterno.toLowerCase(), apellidoMaterno.toLowerCase());
    }
    public Colaborador getColaboradorByNombreAndApellidoPaternoAndApellidoMaterno(String nombre, String apellidoPaterno, String apellidoMaterno) {
        return colaboradorRepository.findByNombreAndApellidoPaternoAndApellidoMaterno(nombre.toLowerCase(), apellidoPaterno.toLowerCase(), apellidoMaterno.toLowerCase());
    }
    //Considerar uso de Index en entidad Colaborador para agilizar consultas.
    public Colaborador getColaboradorByEmail(String email){
        return colaboradorRepository.findByEmail(email.toLowerCase());
    }
    public Colaborador getColaboradorByCelular(String celular){
        return colaboradorRepository.findByCelular(celular);
    }
    public Colaborador getColaboradorByPassword(String password){
        return colaboradorRepository.findByPassword(password);
    }
    public Colaborador getColaboradorByDisponibilidad(Byte disponibilidad) {
        return colaboradorRepository.findByDisponibilidad(disponibilidad);
    }
    public Colaborador getColaboradorByPuntuacion(Integer puntuacion) {
        return colaboradorRepository.findByPuntuacion(puntuacion);
    }
    public Colaborador getColaboradorByDisponibilidadAndPuntuacion(Byte disponibilidad, Integer puntuacion) {
        return colaboradorRepository.findByDisponibilidadAndPuntuacion(disponibilidad, puntuacion);
    }
    public Colaborador getColaboradorByEmailAndPassword(String email, String password) {
        return colaboradorRepository.findByEmailAndPassword(email, password);
    }
    public List<Colaborador> getColaboradorByComunasIn(List<Comuna> comunas) {
        return colaboradorRepository.findByComunasIn(comunas);
    }
    public List<Colaborador> getColaboradorByComunaInAndDisponibilidad(List<Comuna> comunas, Byte disponibilidad) {
        return colaboradorRepository.findByComunasInAndDisponibilidad(comunas, disponibilidad);
    }
    public List<Colaborador> getColaboradorByComunaInAndPuntuacion(List<Comuna> comunas, Integer puntuacion) {
        return colaboradorRepository.findByComunasInAndPuntuacion(comunas, puntuacion);
    }
    public List<Colaborador> getColaboradorByCategoriaIn(List<Categoria> categorias) {
        return colaboradorRepository.findByCategoriasIn(categorias);
    }
    public List<Colaborador> getColaboradorByCategoriaInAndDisponibilidad(List<Categoria> categorias, Byte disponibilidad) {
        return colaboradorRepository.findByCategoriasInAndDisponibilidad(categorias, disponibilidad);
    }
    public List<Colaborador> getColaboradorByCategoriasInAndPuntuacion(List<Categoria> categorias, Integer puntuacion) {
        return colaboradorRepository.findByCategoriasInAndPuntuacion(categorias, puntuacion);
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

    /* Obtener a los colaboradores según su categoría y que se encuentren disponibles */
    public List<Colaborador> findByCategoriaAndFilters(String categoria, String comuna, Integer puntuacion, Byte disponibilidad) {
        disponibilidad = (disponibilidad == null) ? 1 : disponibilidad;
        if (comuna != null && puntuacion != null) {
            return colaboradorRepository.findByCategoriaAndComunaAndPuntuacionAndDisponibilidad(categoria, comuna, puntuacion, disponibilidad);
        } else if (comuna != null) {
            return colaboradorRepository.findByCategoriaAndComunaAndDisponibilidad(categoria, comuna, disponibilidad);
        } else if (puntuacion != null) {
            return colaboradorRepository.findByCategoriaAndPuntuacionAndDisponibilidad(categoria, puntuacion, disponibilidad);
        } else {
            return colaboradorRepository.findByCategoriaAndDisponibilidad(categoria, disponibilidad);
        }
    }

    /* Obtener colaboradores según 2 o más caracteres que se reciban que coincidan con el inicio del nombre */
    public List<Colaborador> findByNombreStartingWith(String nombre) {
        return colaboradorRepository.findByNombreStartingWithIgnoreCase(nombre);
    }

    
}



