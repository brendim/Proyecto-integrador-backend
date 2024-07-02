package com.cuatro.minga_backend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cuatro.minga_backend.models.Colaborador;
import com.cuatro.minga_backend.models.Comuna;
import com.cuatro.minga_backend.models.Categoria;
import com.cuatro.minga_backend.service.ColaboradorService;
/**import com.cuatro.minga_backend.repository.ComunaRepository;
import com.cuatro.minga_backend.repository.CategoriaRepository; **/

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity; // Considerar uso de ResponseEntity para almacenar solicitudes HTTP
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/colaborador")
public class ColaboradorController {
    
    @Autowired
    private ColaboradorService colaboradorService;

    //Las mil y una busquedas
    @GetMapping("/{id}")
    public Colaborador getColaboradorByID(@PathVariable Long id) {
        return colaboradorService.getColaboradorByID(id);
    }
    @GetMapping("/rut/{rut}")
    public Colaborador getColaboradorByRut(@PathVariable String rut) {
        return colaboradorService.getColaboradorByRut(rut);
    }
    @GetMapping("/nombre/{nombre}")
    public Colaborador getColaboradorByNombre(@PathVariable String nombre){
        return colaboradorService.getColaboradorbyNombre(nombre);
    };
    @GetMapping("/apellidoPaterno/{apellidoPaterno}")
    public Colaborador getColaboradorByApellidoPaterno(@PathVariable String apellidoPaterno){
        return colaboradorService.getColaboradorByApellidoPaterno(apellidoPaterno);
    }
    @GetMapping("/apellidoMaterno/{apellidoMaterno}")
    public Colaborador getColaboradorByApellidoMaterno(@PathVariable String apellidoMaterno){
        return colaboradorService.getColaboradorByApellidoMaterno(apellidoMaterno);
    }
    @GetMapping("/nombreApellidoPaterno")
    public Colaborador getColaboradorByNombreAndApellidoPaterno(
            @RequestParam String nombre,
            @RequestParam String apellidoPaterno) {
        return colaboradorService.getColaboradorByNombreAndApellidoPaterno(nombre, apellidoPaterno);
    }

    @GetMapping("/nombreApellidoMaterno")
    public Colaborador getColaboradorByNombreAndApellidoMaterno(
            @RequestParam String nombre,
            @RequestParam String apellidoMaterno) {
        return colaboradorService.getColaboradorByNombreAndApellidoMaterno(nombre, apellidoMaterno);
    }

    @GetMapping("/apellidoPaternoApellidoMaterno")
    public Colaborador getColaboradorByApellidoPaternoAndApellidoMaterno(
            @RequestParam String apellidoPaterno,
            @RequestParam String apellidoMaterno) {
        return colaboradorService.getColaboradorByApellidoPaternoAndApellidoMaterno(apellidoPaterno, apellidoMaterno);
    }
    @GetMapping("/nombreApellidoPaternoApellidoMaterno")
    public Colaborador getColaboradorByNombreAndApellidoPaternoAndApellidoMaterno(
            @RequestParam String nombre,
            @RequestParam String apellidoPaterno,
            @RequestParam String apellidoMaterno) {
        return colaboradorService.getColaboradorByNombreAndApellidoPaternoAndApellidoMaterno(nombre, apellidoPaterno, apellidoMaterno);
    }
    @GetMapping("/email/{email}")
    public Colaborador getColaboradorByEmail(@PathVariable String email){
        return colaboradorService.getColaboradorByEmail(email);
    }
    @GetMapping("/celular/{celular}")
    public Colaborador getColaboradorByCelular(@PathVariable String celular){
        return colaboradorService.getColaboradorByCelular(celular);
    }
    @GetMapping("/password/{password}")
    public Colaborador getColaboradorByPassword(@PathVariable String password){
        return colaboradorService.getColaboradorByPassword(password);
    }
    @GetMapping("/disponibilidad/{disponibilidad}")
    public Colaborador getColaboradorByDisponibilidad(@PathVariable Byte disponibilidad){
        return colaboradorService.getColaboradorByDisponibilidad(disponibilidad);
    }
    @GetMapping("/puntuacion/{puntuacion}")
    public Colaborador getColaboradorByPuntuacion(@PathVariable Integer puntuacion){
        return colaboradorService.getColaboradorByPuntuacion(puntuacion);
    }
    @GetMapping("/disponibilidadPuntuacion")
    public Colaborador getColaboradorByDisponibilidadAndPuntuacion(@RequestParam Byte disponibilidad,@RequestParam Integer puntuacion){
    return colaboradorService.getColaboradorByDisponibilidadAndPuntuacion(disponibilidad, puntuacion);
    }
    @GetMapping("/colaboradorPassword")
    public Colaborador getColaboradorByRutAndPassword(
        @RequestParam String rut, 
        @RequestParam String password){
            return colaboradorService.getColaboradorByRutAndPassword(rut, password);
        }
    @PostMapping("/colaboradorComunas")
        public List<Colaborador> getColaboradorPorComuna(@RequestBody List<Comuna> comunas) {  
            return colaboradorService.getColaboradorByComunasIn(comunas); 
        }
     @PostMapping("/comunaDisponibilidad")
     public List<Colaborador> getColaboradorByComunaAndDisponibilidad(@RequestBody List<Comuna> comunas, 
     @RequestParam Byte disponibilidad) {
        return colaboradorService.getColaboradorByComunaInAndDisponibilidad(comunas, disponibilidad);   
    }
    @PostMapping("/comunaPuntuacion")
    public List<Colaborador> getColaboradorByComunaInAndPuntuacion(@RequestBody List<Comuna> comunas,
    @RequestParam Integer puntuacion) {
        return colaboradorService.getColaboradorByComunaInAndPuntuacion(comunas, puntuacion);
    }
    @PostMapping("/colaboradorCategoria")
    public List<Colaborador> getColaboradorByCategoriaIn(@RequestBody List<Categoria> categorias){
        return colaboradorService.getColaboradorByCategoriaIn(categorias);
    }
    @PostMapping("/colaboradorCetegoriaDisponibilidad")
    public List<Colaborador> getColaboradorByCategoriaInAndDisponibilidad(@RequestBody List<Categoria> categorias, @RequestParam Byte disponibilidad){
        return colaboradorService.getColaboradorByCategoriaInAndDisponibilidad(categorias, disponibilidad);
    }
    @PostMapping("/colaboradorCategoriaPuntacion")
    public List<Colaborador> getColaboradorByCategoriasInAndPuntuacion(@RequestBody List<Categoria> categorias, @RequestParam Integer puntuacion) {
        return colaboradorService.getColaboradorByCategoriasInAndPuntuacion(categorias, puntuacion);
    }
    //Otros servicios
    @GetMapping
    public List<Colaborador> getAllColaboradores() {
        return colaboradorService.getAllColaboradores();
    }
    @PostMapping
    public Colaborador createColaborador(@RequestBody Colaborador colaborador) {
        return colaboradorService.createColaborador(colaborador);
    }
     @PutMapping("/{id}")
    public Colaborador updateColaborador(@PathVariable Long id, @RequestBody Colaborador colaborador) {
        colaborador.setId(id);
        return colaboradorService.updateColaborador(colaborador);
    }
    @DeleteMapping("/{id}")
    public void deleteColaborador(@PathVariable Long id) {
        Colaborador colaborador = colaboradorService.getColaboradorByID(id);
        if (colaborador != null) {
            colaboradorService.deleteColaborador(colaborador);
        }
    }
}
