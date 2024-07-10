package com.cuatro.minga_backend.models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "colaboradores")
public class Colaborador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String rut;
    private String nombre;
    @Column(name="apellido_paterno")
    private String apellidoPaterno;
    @Column(name="apellido_materno")
    private String apellidoMaterno;
    @Column(name="fecha_nacimiento")
    private Date fechaNacimiento;
    @Column(unique = true)
    private String email;
    private String celular;
    private String password;
    private Byte disponibilidad;
    private Integer puntuacion;

    //Relaciones con entidades
    //Mensajeria
    @OneToMany(mappedBy = "colaborador")
    @JsonIgnore
    private List<Mensaje>  mensajes;
    //Resenas
    @OneToMany(mappedBy = "colaborador")
    @JsonIgnore
    private List<Resena> resenas;
    // Creacion de tabla intermedia Categoria_colaborador
    @ManyToMany
    @JoinTable(
        name = "categorias_colaboradores",
        joinColumns = @JoinColumn(name = "colaborador_id"),
        inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private List<Categoria> categorias;

    @ManyToMany
    @JoinTable(
        name = "comunas_colaboradores",
        joinColumns = @JoinColumn(name = "colaborador_id"),
        inverseJoinColumns = @JoinColumn(name = "comuna_id"))
    private List<Comuna> comunas;
};