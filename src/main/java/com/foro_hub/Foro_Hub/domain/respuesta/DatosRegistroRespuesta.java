package com.foro_hub.Foro_Hub.domain.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroRespuesta(
        @NotBlank
        String mensaje,
        @NotNull
        Long autorId,
        @NotNull
        Long topicoId
) {
}
