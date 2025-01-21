package com.foro_hub.Foro_Hub.controller;

import com.foro_hub.Foro_Hub.domain.respuesta.*;
import com.foro_hub.Foro_Hub.domain.topico.DatosListadoTopico;
import com.foro_hub.Foro_Hub.domain.topico.Topico;
import com.foro_hub.Foro_Hub.domain.topico.TopicoRepository;
import com.foro_hub.Foro_Hub.domain.usuario.Usuario;
import com.foro_hub.Foro_Hub.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {
    @Autowired
    private RespuestaRepository respuestaRepository;
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity registrarRespuesta(@RequestBody @Valid DatosRegistroRespuesta datosRegistroRespuesta, UriComponentsBuilder uriComponentsBuilder){
        Topico topico = topicoRepository.findById(datosRegistroRespuesta.topicoId())
                        .orElseThrow(() -> new RuntimeException("Topico no encontrado"));
        Usuario autor = usuarioRepository.findById(datosRegistroRespuesta.autorId())
                .orElseThrow(()-> new RuntimeException("Autor no encontrado"));
        Respuesta respuesta = new Respuesta(datosRegistroRespuesta.mensaje(), LocalDateTime.now(), autor, topico, false);
        respuestaRepository.save(respuesta);
        DatosRespuestaRespuesta datosRespuestaRespuesta = new DatosRespuestaRespuesta(
                respuesta.getId(), respuesta.getMensaje(), respuesta.getFechaCreacion(), respuesta.getAutor(),
                respuesta.getTopico(), respuesta.getSolucion()
        );
        URI url = uriComponentsBuilder.path("/respuestas/{id}").buildAndExpand(respuesta.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaRespuesta);

    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoRespuesta>> listarRespuestas(@PageableDefault(size = 3) Pageable paginacion){
        return ResponseEntity.ok(respuestaRepository.findAll(paginacion).map(DatosListadoRespuesta::new));
    }
}
