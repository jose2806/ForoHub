package com.foro_hub.Foro_Hub.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    UserDetails findByCorreoElectronico(String username);
}
