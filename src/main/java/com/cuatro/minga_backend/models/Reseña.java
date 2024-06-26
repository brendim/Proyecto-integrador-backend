package com.cuatro.minga_backend.models;


    
    import jakarta.persistence.*;
    import lombok.Data;
    import lombok.NoArgsConstructor;
    
    @Data //Crea AllArgsConstructor, Getters, Setters, Equals, HashCode and ToString
    @NoArgsConstructor
    @Entity
    @Table(name = "reseñas")
    public class Reseña{
        
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private Long id;        
        private String valoracion;
        private String contenido;
       
    
        //Falta agregar la relación con las otras tablas


    }