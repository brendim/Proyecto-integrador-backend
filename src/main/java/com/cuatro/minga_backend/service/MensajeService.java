package com.cuatro.minga_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuatro.minga_backend.models.Mensaje;
import com.cuatro.minga_backend.repository.MensajeRepository;

@Service

public class MensajeService {

   
    @Autowired
    private MensajeRepository mensajeRepository;

    //Métodos personalizados
    //Pensando en CRUD (Create, Read, Update, Delete)

    /*Obtener mensaje por nombre y apellidos
    public Mensaje getMensajeByNombre(Long ){
        return mensajeRepository.findById(id).orElse(null);
    } */

    
    //Obtener mensaje por su id
    public Mensaje getMensajeById(Long id){
        return mensajeRepository.findById(id).orElse(null);
    }




    //Obtener todos los mensajes?
    public List<Mensaje> getAllMensajes(){
        return mensajeRepository.findAll();
    }

    //crear mensaje? 
    public Mensaje createMensaje(Mensaje mensaje){
        return mensajeRepository.save(mensaje);
    }

    //Eliminar mensaje
    public void deleteMensaje(Mensaje mensaje){
        mensajeRepository.delete(mensaje);
    }

    

}
    

