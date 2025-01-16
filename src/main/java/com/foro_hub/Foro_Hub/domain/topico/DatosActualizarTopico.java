package com.foro_hub.Foro_Hub.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull
        Long id,
        String titulo,
        String mensaje,
        String status,
        Long autor,
        Long curso
) {
}
