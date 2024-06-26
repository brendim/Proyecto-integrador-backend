package com.cuatro.minga_backend.models;

import java.sql.Date;

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
    private Long rut;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private String correoElectronico;
    private String celular;
    private String contrasena;
    private Byte disponibilidad;
    private Integer puntuacion;

    
}
