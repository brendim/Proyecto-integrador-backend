package com.cuatro.minga_backend.models;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
       
   // Varias reseñas pueden ser escritas por un usuario
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

   // Varias reseñas pueden ser escritas por un colaborador
    @ManyToOne
    @JoinColumn(name = "colaborador_id")
    @JsonIgnore
    private Colaborador colaborador;

}