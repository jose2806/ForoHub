package com.foro_hub.Foro_Hub.domain.respuesta;

import com.foro_hub.Foro_Hub.domain.topico.Topico;
import com.foro_hub.Foro_Hub.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Respuesta")
@Table(name = "respuestas")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaCreacion")
    private LocalDateTime fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor",nullable = false)
    private Usuario autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico",nullable = false)
    private Topico topico;

    private Boolean solucion;


    public Respuesta() {
    }

    public Respuesta( String mensaje, LocalDateTime fecha, Usuario autor, Topico topico, boolean solucion) {
        this.mensaje = mensaje;
        this.fechaCreacion = fecha;
        this.autor = autor;
        this.topico = topico;
        this.solucion = solucion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public Usuario getAutor() {
        return autor;
    }

    public Topico getTopico() {
        return topico;
    }

    public Boolean getSolucion() {
        return solucion;
    }

    public Long getId() {
        return id;
    }
}
