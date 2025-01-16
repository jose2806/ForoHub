package com.foro_hub.Foro_Hub.controller;

import com.foro_hub.Foro_Hub.domain.curso.Curso;
import com.foro_hub.Foro_Hub.domain.curso.CursoRepository;
import com.foro_hub.Foro_Hub.domain.topico.*;
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
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public ResponseEntity registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uriComponentsBuilder){
        Optional<Usuario> autorOpt = usuarioRepository.findById(datosRegistroTopico.autor());
        Optional<Curso> cursoOpt = cursoRepository.findById(datosRegistroTopico.curso());
        if (autorOpt.isEmpty() || cursoOpt.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        Usuario autor = autorOpt.get();
        Curso curso = cursoOpt.get();
        Topico topico = topicoRepository.save(new Topico(datosRegistroTopico.titulo(), datosRegistroTopico.mensaje(), autor, curso));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(
                topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(),
                topico.getStatus() ,topico.getAutor().getNombre(), topico.getCurso().getNombre(), topico.getRespuestas()
        );
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listarTopicos(@PageableDefault(size = 3)Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListadoTopico::new));
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> retornarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico = new DatosRespuestaTopico(topico.getId(),
                topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getStatus(),
                topico.getAutor().getNombre(), topico.getCurso().getNombre(), topico.getRespuestas());
        return ResponseEntity.ok(datosTopico);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico, usuarioRepository, cursoRepository);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getFechaCreacion(), topico.getStatus(), topico.getAutor().getNombre(), topico.getCurso().getNombre(),
                topico.getRespuestas()));
    }
}
