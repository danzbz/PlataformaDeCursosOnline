package com.projects.plataformaDeCursosOnline.controller.form;

import com.projects.plataformaDeCursosOnline.modelo.Curso;

public class CursoForm {

    private String nome;
    private String descricao;
    private String materia;
    private String categoria;

    // Getters
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

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Curso converter() {
        Curso curso = new Curso();
        curso.setNome(this.nome);
        curso.setDescricao(this.descricao);
        curso.setCategoria(this.categoria);
        return curso;
    }
}
