package com.cuatro.minga_backend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuatro.minga_backend.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    //Métodos incluidos en JpaRepository, no es necesario declararlos
    //List<Usuario> findAll();
    //Usuario save(Usuario usuario);
    //void delete(Usuario usuario);
    //Usuario findById(Long id);
    //boolean existsById(Long id);
    //long count();
    //void deleteById(Long id);
    //void deleteAll();
    //etc...

    //Métodos personalizados

    //Buscar por rut
    Usuario findByRut(String rut);

    //Buscar por email
    Usuario findByEmail(String email);

    //Buscar por rut y password
    Usuario findByRutAndPassword(String rut, String password);

    //Buscar por nombre, apellido paterno y apellido materno
    List<Usuario> findByNombreAndApellidoPaternoAndApellidoMaterno(String nombre, String apellidoPaterno, String apellidoMaterno);

    //Comprobar si existe un usuario con ese rut
    boolean existsByRut(String rut);

    //Comprobar si existe un usuario con ese email
    boolean existsByEmail(String email);
}
