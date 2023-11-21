package com.projects.plataformaDeCursosOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.projects.plataformaDeCursosOnline.controller.dto.ProfessorDto;
import com.projects.plataformaDeCursosOnline.controller.form.ProfessorForm;
import com.projects.plataformaDeCursosOnline.modelo.Professor;
import com.projects.plataformaDeCursosOnline.repository.ProfessorRepository;

import java.net.URI;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping
    public List<ProfessorDto> lista(String nomeProfessor) {
        if (nomeProfessor == null) {
            List<Professor> professores = professorRepository.findAll();
            return ProfessorDto.converter(professores);
        } else {
            Professor professor = professorRepository.findByNome(nomeProfessor);
            if (professor != null) {
                return Collections.singletonList(ProfessorDto.converter(professor));
            } else {
                return Collections.emptyList();
            }
        }
    }

    @PostMapping
    public ResponseEntity<ProfessorDto> cadastrar(@RequestBody ProfessorForm form, UriComponentsBuilder uriBuilder) {
        Professor professor = form.converter();

        // Verifica se o professor já existe
        Professor professorExistente = professorRepository.findByCpf(professor.getCpf());
        if (professorExistente != null) {
            return ResponseEntity.badRequest().build(); // Professor já existe
        }

        professorRepository.save(professor);

        URI uri = uriBuilder.path("/professores/{id}").buildAndExpand(professor.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProfessorDto(professor));
    }

}
