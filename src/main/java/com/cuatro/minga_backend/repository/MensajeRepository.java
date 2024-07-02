
package com.cuatro.minga_backend.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuatro.minga_backend.models.Mensaje;

@Repository

public interface MensajeRepository extends JpaRepository<Mensaje, Long>{


/* Buscar por fecha de envio */

      
       Mensaje findByFechaEnvio (LocalDateTime fechaEnvio);

       /*  Buscar por contenido */
    Mensaje findByContenido (String contenido);

}
