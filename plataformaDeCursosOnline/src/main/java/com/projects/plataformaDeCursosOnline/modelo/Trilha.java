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
public class Trilha {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String nome, descricao;
	@OneToMany(mappedBy = "trilha")
	private List<Curso> ListaCurso;
	/*private List<Aluno> ListaAlunoInscrito;*/
	
	@ManyToOne
	private Plataforma plataforma;
	
	@ManyToOne
	private Aluno aluno;

	public Trilha(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
		this.ListaCurso = new ArrayList<Curso>();
		/*this.ListaAlunoInscrito = new ArrayList<Aluno>();*/
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
        this.nome = nome;
    }
	
	public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
	
	public void adicionaCursoLista(Curso curso) {
        ListaCurso.add(curso);
    }
	
	public void modificarTrilha(Trilha trilha) {
        this.nome = trilha.nome;
        this.descricao = trilha.descricao;
        this.ListaCurso = trilha.ListaCurso;
	}

	/*public void inscreverAluno(Aluno aluno) {
		if (!ListaAlunoInscrito.contains(aluno)) {
			ListaAlunoInscrito.add(aluno);
			aluno.inscreverNaTrilha(this);
		}
	}*/

	/*public List<Aluno> getAlunosInscritos() {
		return ListaAlunoInscrito;
	}*/
	
	  // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
