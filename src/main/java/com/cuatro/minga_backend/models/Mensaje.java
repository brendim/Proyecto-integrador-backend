package com.cuatro.minga_backend.models;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data //Crea AllArgsConstructor, Getters, Setters, Equals, HashCode and ToString
@NoArgsConstructor
@Entity
@Table(name = "mensajes")
public class Mensaje {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contenido;
    @CreationTimestamp
    @Column(name="fecha_envio", updatable = false)
    private LocalDateTime fechaEnvio; 
    
    /*Varios mensajes pueden ser escritos por un usuario*/
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnore
    private Usuario usuario;

    /*Varias mensajes pueden ser escritas por un colaborador  */
    @ManyToOne
    @JoinColumn(name = "colaborador_id")
    @JsonIgnore
    private Colaborador colaborador;
}
