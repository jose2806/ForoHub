package com.foro_hub.Foro_Hub.domain.respuesta;

import java.time.LocalDateTime;

public record DatosListadoRespuesta(
        Long id,
        String mensaje,
        String autor,
        String topico,
        LocalDateTime fechaCreacion,
        Boolean solucion
) {
    public DatosListadoRespuesta(Respuesta respuesta) {
        this(respuesta.getId(), respuesta.getMensaje(),
                respuesta.getAutor().getNombre(),
                respuesta.getTopico().getTitulo(),
                respuesta.getFechaCreacion(),
                respuesta.getSolucion());
    }
}
