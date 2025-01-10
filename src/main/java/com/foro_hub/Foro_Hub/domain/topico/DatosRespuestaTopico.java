package com.foro_hub.Foro_Hub.domain.topico;

import com.foro_hub.Foro_Hub.domain.curso.Curso;
import com.foro_hub.Foro_Hub.domain.respuesta.Respuesta;
import com.foro_hub.Foro_Hub.domain.usuario.Usuario;

import java.time.LocalDateTime;
import java.util.List;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String status,
        Usuario autor,
        Curso curso,
        List<Respuesta> respuestas
) {
}
