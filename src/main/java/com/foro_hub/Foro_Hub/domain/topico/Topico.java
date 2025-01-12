package com.foro_hub.Foro_Hub.domain.topico;

import com.foro_hub.Foro_Hub.domain.curso.Curso;
import com.foro_hub.Foro_Hub.domain.respuesta.Respuesta;
import com.foro_hub.Foro_Hub.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Topico")
@Table(name = "topicos")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@Getter
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaCreacion")
    private LocalDateTime fechaCreacion;

    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor",nullable = false)
    private Usuario autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso",nullable = false)
    private Curso curso;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
    private List<Respuesta> respuestas;


    public Topico(@Valid String titulo, String mensaje, Usuario autor, Curso curso) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.autor = autor;
        this.curso = curso;
        this.status = "ABIERTO";
        this.fechaCreacion =  LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getStatus() {
        return status;
    }

    public Usuario getAutor() {
        return autor;
    }

    public Curso getCurso() {
        return curso;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }
}
