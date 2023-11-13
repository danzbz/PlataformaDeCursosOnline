package com.projects.plataformaDeCursosOnline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.plataformaDeCursosOnline.modelo.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	Aluno findByNome(String nome);
	
	Aluno findByCpf(String cpf);
}
