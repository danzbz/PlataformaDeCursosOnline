package com.projects.plataformaDeCursosOnline.controller.form;

import com.projects.plataformaDeCursosOnline.modelo.Aluno;

public class AlunoForm {

    private String nome;
    private String cpf;
    private String sexo;

    // Getters
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSexo() {
        return sexo;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Aluno converter() {
        return new Aluno(nome, cpf, sexo);
    }
}