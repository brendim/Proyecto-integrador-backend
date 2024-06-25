package com.cuatro.minga_backend.models;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Crea AllArgsConstructor, Getters, Setters, Equals, HashCode and ToString
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rut;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private Date fecha_nacimiento;
    private String celular;

    //Falta agregar la relación con las otras tablas
}
