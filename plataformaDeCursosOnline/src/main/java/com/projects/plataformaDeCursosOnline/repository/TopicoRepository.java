package com.projects.plataformaDeCursosOnline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.plataformaDeCursosOnline.modelo.Topico;

import java.util.List;


public interface TopicoRepository extends JpaRepository<Topico, Long> {
	List<Topico> findByCursoNome(String nomeCurso);
	

}
