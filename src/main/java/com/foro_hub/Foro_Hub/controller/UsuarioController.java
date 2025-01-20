package com.foro_hub.Foro_Hub.controller;

import com.foro_hub.Foro_Hub.domain.perfil.Perfil;
import com.foro_hub.Foro_Hub.domain.perfil.PerfilRepository;
import com.foro_hub.Foro_Hub.domain.topico.DatosListadoTopico;
import com.foro_hub.Foro_Hub.domain.usuario.*;
import com.foro_hub.Foro_Hub.infra.security.SecurityConfigurations;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PerfilRepository perfilRepository;
    @Autowired
    private SecurityConfigurations securityConfigurations;

    @PostMapping
    public ResponseEntity registrarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario,UriComponentsBuilder uriComponentsBuilder){
        String contrasenaEncriptada= securityConfigurations.passwordEncoder().encode(datosRegistroUsuario.contrasena());
        System.out.println(contrasenaEncriptada);
        Usuario usuario =new Usuario(datosRegistroUsuario.nombre(), datosRegistroUsuario.correoElectronico(), contrasenaEncriptada);
        Perfil perfil = perfilRepository.save(new Perfil(datosRegistroUsuario.nombre()));
        usuario.getPerfiles().add(perfil);
        usuarioRepository.save(usuario);
        DatosRespuestaUsuario datosRespuestaUsuario = new DatosRespuestaUsuario(
                usuario.getId(), usuario.getNombre(), usuario.getCorreoElectronico(), usuario.getPerfiles());
        URI url = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaUsuario);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoUsuario>> listarUsuarios(@PageableDefault(size = 3)Pageable paginacion){
        return ResponseEntity.ok(usuarioRepository.findAll(paginacion).map(DatosListadoUsuario::new));
    }

}
