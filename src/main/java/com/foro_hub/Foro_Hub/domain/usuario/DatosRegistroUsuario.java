package com.foro_hub.Foro_Hub.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroUsuario(
        @NotBlank
        String nombre,

        @NotBlank
        String correoElectronico,

        @NotBlank
        String contrasena
) {
}
