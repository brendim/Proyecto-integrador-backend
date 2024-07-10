package com.cuatro.minga_backend.DTO;

import java.util.Date;
import java.util.List;

import com.cuatro.minga_backend.models.Mensaje;
import com.cuatro.minga_backend.models.Resena;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class ColaboradorDTO {
    private String rut;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private String email;
    private String celular;
    private String password;
    private Byte disponibilidad;
    private Integer puntuacion;
    //Relaciones con entidades
    //Mensajeria
    private List<Mensaje>  mensajes;
    //Resenas
    private List<Resena> resenas;
    // Creacion de tabla intermedia Categoria_colaborador
    private List<String> categorias;

    private List<String> comunas;
};

