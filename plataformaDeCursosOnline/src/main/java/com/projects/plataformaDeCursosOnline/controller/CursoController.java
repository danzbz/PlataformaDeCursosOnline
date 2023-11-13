package com.projects.plataformaDeCursosOnline.controller;

import com.projects.plataformaDeCursosOnline.controller.dto.CursoDto;
import com.projects.plataformaDeCursosOnline.controller.dto.TopicoDto;
import com.projects.plataformaDeCursosOnline.controller.dto.UsuarioDto;
import com.projects.plataformaDeCursosOnline.controller.form.CursoForm;
import com.projects.plataformaDeCursosOnline.modelo.Curso;
import com.projects.plataformaDeCursosOnline.modelo.Topico;
import com.projects.plataformaDeCursosOnline.modelo.Usuario;
import com.projects.plataformaDeCursosOnline.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

	@GetMapping
	public List<CursoDto> lista(String nomeCurso) {
		if (nomeCurso == null) {
			List<Curso> cursos = cursoRepository.findAll();
			return CursoDto.converter(cursos);
		} else {
			Curso curso = cursoRepository.findByNome(nomeCurso);
			if (curso != null) {
				CursoDto cursoDto = CursoDto.converter(curso);
				List<CursoDto> listaCursoDto = new ArrayList<>();
				listaCursoDto.add(cursoDto);
			
			return listaCursoDto;
			}
			else {
	            // Retorna uma lista vazia 
	            return Collections.emptyList();
	        }
		}
	}
	
	
    @PostMapping
    public ResponseEntity<CursoDto> cadastrar(@RequestBody CursoForm form, UriComponentsBuilder uriBuilder) {
        Curso curso = form.converter();

        // Verifica se o curso já existe
        Curso cursoExistente = cursoRepository.findByNome(curso.getNome());
        if (cursoExistente != null) {
            return ResponseEntity.badRequest().build(); // Curso já existe
        }

        cursoRepository.save(curso);

        URI uri = uriBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(uri).body(new CursoDto(curso));
    }

}
