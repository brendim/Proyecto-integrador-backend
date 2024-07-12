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
@Table(name = "mensajes")
public class Mensaje {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String asunto;
    private String contenido;
    @CreationTimestamp
    @Column(name="fecha_envio", updatable = false)
    private LocalDateTime fechaEnvio; 
    
    /*Varios mensajes pueden ser escritos por un usuario*/
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    /*Varias mensajes pueden ser escritas por un colaborador  */
    @ManyToOne
    @JoinColumn(name = "colaborador_id")
    private Colaborador colaborador;
}
