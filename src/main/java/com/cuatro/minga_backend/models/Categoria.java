package com.cuatro.minga_backend.models;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data //Crea AllArgsConstructor, Getters, Setters, Equals, HashCode and ToString
@NoArgsConstructor
@Entity
@Table(name = "categorias")

public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String subcategoria;
    private String descripcion;


    //FALTAN RELACIONES JEJE


}
