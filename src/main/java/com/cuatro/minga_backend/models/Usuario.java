package com.cuatro.minga_backend.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Crea AllArgsConstructor, Getters, Setters, Equals, HashCode and ToString
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //rut unico para cada usuario
    @Column(unique = true)
    private String rut;
    private String nombre;
    @Column(name="apellido_paterno")
    private String apellidoPaterno;
    @Column(name="apellido_materno")
    private String apellidoMaterno;
    @Column(unique = true)
    private String email;
    private String password;
    @Column(name="fecha_nacimiento")
    private Date fechaNacimiento;
    private String celular;

    //Relaciones con otras entidades

    //Un usuario puede mandar muchos mensajes
    @OneToMany(mappedBy = "usuario")
    private List<Mensaje> mensajes;

    //Un usuario es de una comuna y una comuna puede tener muchos usuarios
    @ManyToOne
    @JoinColumn(name = "comuna_id")
    private Comuna comuna;

    //Un usuario puede hacer muchas reseñas
    @OneToMany(mappedBy = "usuario")
    private List<Resena> resenas;
    
}
