package com.cuatro.minga_backend.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
    
@Data //Crea AllArgsConstructor, Getters, Setters, Equals, HashCode and ToString
@NoArgsConstructor
@Entity
@Table(name = "resenas")
public class Resena{
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;        
    private String valoracion;
    private String contenido;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime fecha;
       
    
    //Falta agregar la relación con las otras tablas

}