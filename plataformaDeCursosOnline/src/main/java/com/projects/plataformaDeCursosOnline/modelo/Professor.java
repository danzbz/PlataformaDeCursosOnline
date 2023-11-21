package com.projects.plataformaDeCursosOnline.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Professor {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String nome, cpf, sexo;
	@OneToMany(mappedBy = "professor")
	private List<Trilha> ListaTrilhasInscrita;
	@ManyToOne
	private Curso curso;
	
	public Professor() {
		
	}

	public Professor(String nome, String cpf, String sexo) {
		this.nome = nome;
		this.cpf = cpf;
		this.sexo= sexo;
		this.ListaTrilhasInscrita = new ArrayList<Trilha>();
	}

	public void modificarProfessor(Professor professor) {
        this.nome = professor.nome;
        this.cpf = professor.cpf;
        this.sexo = professor.sexo;
    }
	

	public List<Trilha> getTrilhasInscritas() {
		return ListaTrilhasInscrita;
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
