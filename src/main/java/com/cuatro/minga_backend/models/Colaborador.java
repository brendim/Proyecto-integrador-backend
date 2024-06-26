package com.cuatro.minga_backend.models;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
@Table(name = "colaboradores")
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private Long rut;
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

    
}
