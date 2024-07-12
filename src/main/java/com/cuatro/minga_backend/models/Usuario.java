package com.cuatro.minga_backend.models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
    @JsonIgnore
    private List<Mensaje> mensajes;

    //Un usuario es de una comuna y una comuna puede tener muchos usuarios
    @ManyToOne
    @JoinColumn(name = "comuna_id")
    private Comuna comuna;

    //Un usuario puede hacer muchas reseñas
    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Resena> resenas;

    public void setComuna(Comuna comuna) {
        this.comuna = comuna;
    }
    
    public Comuna getComuna() {
        return comuna;
    }
    
}
