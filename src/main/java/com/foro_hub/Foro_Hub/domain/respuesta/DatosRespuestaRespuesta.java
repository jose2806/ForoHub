package com.foro_hub.Foro_Hub.domain.respuesta;

import com.foro_hub.Foro_Hub.domain.curso.Curso;
import com.foro_hub.Foro_Hub.domain.topico.Topico;
import com.foro_hub.Foro_Hub.domain.usuario.Usuario;

import java.time.LocalDateTime;
import java.util.List;

public record DatosRespuestaRespuesta(
        Long id,
        String mensaje,
        LocalDateTime fechaCreacion,
        Usuario autor,
        Topico topico,
        boolean solucion
) {

}
