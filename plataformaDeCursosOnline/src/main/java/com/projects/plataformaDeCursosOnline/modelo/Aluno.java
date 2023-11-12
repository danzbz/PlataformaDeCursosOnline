package com.projects.plataformaDeCursosOnline.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Aluno {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String nome, cpf, sexo;

	public Aluno(String nome, String cpf, String sexo) {
		this.nome = nome;
		this.cpf = cpf;
		this.sexo= sexo;
		this.ListaTrilhasInscrita = new ArrayList<Trilha>();
	}

	public void modificarAluno(Aluno aluno) {
        this.nome = aluno.nome;
        this.cpf = aluno.cpf;
        this.sexo = aluno.sexo;
    }
	
	public void inscreverNaTrilha(Trilha trilha) {
		if (!ListaTrilhasInscrita.contains(trilha)) {
			ListaTrilhasInscrita.add(trilha);
	        trilha.inscreverAluno(this);
		}
	}

	public List<Trilha> getTrilhasInscritas() {
		return ListaTrilhasInscrita;
	}
	

    
	 @ManyToMany(mappedBy = "alunos")
	 private List<Trilha> ListaTrilhasInscrita;
    
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
	

    // Getters e Setters
    public Curso getCurso() {
        return curso;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
