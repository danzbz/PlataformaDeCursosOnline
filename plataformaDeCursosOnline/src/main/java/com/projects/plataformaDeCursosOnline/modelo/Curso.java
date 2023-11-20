package com.projects.plataformaDeCursosOnline.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Curso {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String categoria;
	
	private String nome, descricao, materia;
	
	@OneToMany(mappedBy = "curso")
	private List<Aluno> ListaAluno;
	
	@ManyToOne
	private Trilha trilha;
	

    public void setListaAluno(List<Aluno> listaAluno) {
        this.listaAluno = listaAluno;
    }
	    
	public Curso() {
	
	}
	
	public Curso(String nome, String descricao, String materia) {
		this.nome = nome;
		this.descricao = descricao;
		this.materia= materia;
		this.ListaAluno = new ArrayList<Aluno>();
	}
	
	public void adicionaAlunoLista(Aluno aluno) {
        ListaAluno.add(aluno);
    }
	
	public void modificarCurso(Curso curso) {
        this.nome = curso.nome;
        this.descricao = curso.descricao;
        this.materia = curso.materia;
        this.ListaAluno = curso.ListaAluno;
    }
	

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getDescricao() {
		return descricao;
	}

	public String getCategoria() {
		return categoria;
	}
	
	  public String getMateria() {
	        return materia;
	    }
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	   @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Aluno> listaAluno = new ArrayList<>();

	    // Getters e Setters
	    public List<Aluno> getListaAluno() {
	        return listaAluno;
	    }

}
