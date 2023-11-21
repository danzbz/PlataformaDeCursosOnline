package com.projects.plataformaDeCursosOnline.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.projects.plataformaDeCursosOnline.modelo.Professor;
import com.projects.plataformaDeCursosOnline.modelo.Curso;

public class ProfessorDto {

    private Long id;
    private String nome;
    private String cpf;
    private String sexo;
    
    public ProfessorDto(Professor professor) {
        this.id = professor.getId();
        this.nome = professor.getNome();
        this.cpf = professor.getCpf();
        this.sexo = professor.getSexo();
    }

    // Método estático para converter um Professor em ProfessorDto
    public static ProfessorDto converter(Professor professor) {
        return new ProfessorDto(professor);
    }
    
    // Método estático para converter uma lista de Professor em uma lista de ProfessorDto
    public static List<ProfessorDto> converter(List<Professor> professores) {
        return professores.stream().map(ProfessorDto::new).collect(Collectors.toList());
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
