package com.projects.plataformaDeCursosOnline.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.projects.plataformaDeCursosOnline.modelo.Aluno;
import com.projects.plataformaDeCursosOnline.modelo.Curso;

public class AlunoDto {

    private Long id;
    private String nome;
    private String cpf;
    private String sexo;
    
    public AlunoDto(Aluno aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.cpf = aluno.getCpf();
        this.sexo = aluno.getSexo();
    }

    // Método estático para converter um Aluno em AlunoDto
    public static AlunoDto converter(Aluno aluno) {
        return new AlunoDto(aluno);
    }
    
    // Método estático para converter uma lista de Aluno em uma lista de AlunoDto
    public static List<AlunoDto> converter(List<Aluno> alunos) {
        return alunos.stream().map(AlunoDto::new).collect(Collectors.toList());
    }
    

    // Getters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSexo() {
        return sexo;
    }


}
