package com.cuatro.minga_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cuatro.minga_backend.models.Colaborador;
import com.cuatro.minga_backend.models.Mensaje;
import com.cuatro.minga_backend.models.Usuario;
import com.cuatro.minga_backend.repository.ColaboradorRepository;
import com.cuatro.minga_backend.repository.MensajeRepository;
import com.cuatro.minga_backend.repository.UsuarioRepository;

@Service
public class MensajeService {
   
    @Autowired
    private MensajeRepository mensajeRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    //Métodos personalizados
    //Pensando en CRUD (Create, Read, Update, Delete)

    //Obtener mensaje por su id
    public Mensaje getMensajeById(Long id){
        return mensajeRepository.findById(id).orElse(null);
    }

    //Obtener todos los mensajes?
    public List<Mensaje> getAllMensajes(){
        return mensajeRepository.findAll();
    }

    
   @Transactional
    public Mensaje createMensaje(Mensaje mensaje, Long usuarioId, Long colaboradorId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Colaborador colaborador = colaboradorRepository.findById(colaboradorId).orElseThrow(() -> new RuntimeException("Colaborador no encontrado"));
        
        mensaje.setUsuario(usuario);
        mensaje.setColaborador(colaborador);
        return mensajeRepository.save(mensaje);
    }

    //Eliminar mensaje
    public void deleteMensaje(Mensaje mensaje){
        mensajeRepository.delete(mensaje);
    }

    public List<Mensaje> getMessagesByUsuarioId(Long usuarioId) {
        return mensajeRepository.findByUsuarioId(usuarioId);
    }

    public List<Mensaje> getMessagesByColaboradorId(Long colaboradorId) {
        return mensajeRepository.findByColaboradorId(colaboradorId);
    }

}
    

