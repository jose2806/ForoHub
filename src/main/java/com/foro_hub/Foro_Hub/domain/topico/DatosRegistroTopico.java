package com.foro_hub.Foro_Hub.domain.topico;

import com.foro_hub.Foro_Hub.domain.curso.Curso;
import com.foro_hub.Foro_Hub.domain.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,

        @NotBlank
        String mensaje,

        @NotNull
        Usuario autor,

        @NotNull
        Curso curso
) {}
