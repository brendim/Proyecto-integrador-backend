package com.cuatro.minga_backend.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data //Crea AllArgsConstructor, Getters, Setters, Equals, HashCode and ToString
@NoArgsConstructor
@Entity
@Table(name = "categorias")

public class Categorias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String subcategoria;
    private String descripcion;


    //FALTAN RELACIONES JEJE


}
