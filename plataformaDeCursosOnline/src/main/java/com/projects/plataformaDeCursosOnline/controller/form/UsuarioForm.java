package com.projects.plataformaDeCursosOnline.controller.form;

import com.projects.plataformaDeCursosOnline.modelo.Curso;
import com.projects.plataformaDeCursosOnline.modelo.Topico;
import com.projects.plataformaDeCursosOnline.modelo.Usuario;
import com.projects.plataformaDeCursosOnline.repository.CursoRepository;
import com.projects.plataformaDeCursosOnline.repository.UsuarioRepository;

public class UsuarioForm {
	
	private String nome;
	private String email;
	private String senha;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Usuario converter(UsuarioRepository usuarioRepository) {
		
		return new Usuario(nome, email, senha);
	}
}
