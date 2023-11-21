package com.projects.plataformaDeCursosOnline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.plataformaDeCursosOnline.modelo.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

	Professor findByNome(String nome);
	
	Professor findByCpf(String cpf);
}
