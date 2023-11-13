package com.projects.plataformaDeCursosOnline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.plataformaDeCursosOnline.modelo.Curso;
import com.projects.plataformaDeCursosOnline.modelo.Topico;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	Curso findByNome(String nome);

}