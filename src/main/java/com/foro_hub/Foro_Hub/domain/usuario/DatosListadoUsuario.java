package com.foro_hub.Foro_Hub.domain.usuario;

import com.foro_hub.Foro_Hub.domain.perfil.Perfil;

import java.util.List;

public record DatosListadoUsuario(
        Long id,
        String nombre,
        String correoElectronico,
        List<Perfil> perfiles
) {
    public DatosListadoUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getNombre(), usuario.getCorreoElectronico(),
                usuario.getPerfiles().stream().toList());
    }
}
