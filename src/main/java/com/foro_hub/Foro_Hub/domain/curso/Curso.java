package com.foro_hub.Foro_Hub.domain.curso;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Curso")
@Table(name = "cursos")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String categoria;

    public Curso() {
    }

    public Curso(@Valid DatosRegistroCurso datosRegistroCurso) {
        this.nombre = datosRegistroCurso.nombre();
        this.categoria = datosRegistroCurso.categoria();
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }
}
