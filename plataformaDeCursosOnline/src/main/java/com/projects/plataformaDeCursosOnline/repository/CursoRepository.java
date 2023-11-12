package com.projects.plataformaDeCursosOnline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.plataformaDeCursosOnline.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	Curso findByNome(String nome);

}