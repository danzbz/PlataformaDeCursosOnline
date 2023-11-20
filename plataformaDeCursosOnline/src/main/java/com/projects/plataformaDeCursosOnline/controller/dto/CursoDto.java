package com.projects.plataformaDeCursosOnline.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.projects.plataformaDeCursosOnline.modelo.Curso;

public class CursoDto {
    
    private Long id;
    private String nome;
    private String descricao;
    private String materia;
    private String categoria;

    public CursoDto(Curso curso) {
        /*this.id = curso.getId();*/
        this.nome = curso.getNome();
        this.descricao = curso.getDescricao();
        this.categoria = curso.getCategoria();
        this.materia = curso.getMateria();
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getMateria() {
        return materia;
    }

    public String getCategoria() {
        return categoria;
    }


    // Método estático para converter uma lista de Cursos em uma lista de CursoDto
    public static List<CursoDto> converter(List<Curso> cursos) {
        return cursos.stream().map(CursoDto::new).collect(Collectors.toList());
    }
    
    public static CursoDto converter(Curso curso) {
        return new CursoDto(curso);
    }
}
