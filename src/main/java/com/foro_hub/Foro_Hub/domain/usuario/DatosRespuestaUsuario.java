package com.foro_hub.Foro_Hub.domain.usuario;

import com.foro_hub.Foro_Hub.domain.perfil.Perfil;

import java.util.List;

public record DatosRespuestaUsuario(
        Long id,
        String nombre,
        String correoElectronico,
        List<Perfil> perfiles
) {
}
