package com.foro_hub.Foro_Hub.domain.topico;

import com.foro_hub.Foro_Hub.domain.curso.Curso;
import com.foro_hub.Foro_Hub.domain.respuesta.Respuesta;
import com.foro_hub.Foro_Hub.domain.usuario.Usuario;

import java.time.LocalDateTime;
import java.util.List;

public record DatosListadoTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String status,
        String autor,
        String curso,
        List<Respuesta> respuestas
) {
    public DatosListadoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(),
                topico.getStatus(), topico.getAutor().getNombre(),topico.getCurso().getNombre(),topico.getRespuestas());
    }
}
