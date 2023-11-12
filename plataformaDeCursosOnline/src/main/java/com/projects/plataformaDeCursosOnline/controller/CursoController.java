package com.projects.plataformaDeCursosOnline.controller;

import com.projects.plataformaDeCursosOnline.controller.dto.CursoDto;
import com.projects.plataformaDeCursosOnline.controller.form.CursoForm;
import com.projects.plataformaDeCursosOnline.modelo.Curso;
import com.projects.plataformaDeCursosOnline.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

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
