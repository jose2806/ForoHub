package com.foro_hub.Foro_Hub.domain.curso;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroCurso(
        @NotBlank
        String nombre,

        @NotBlank
        String categoria
) {}
