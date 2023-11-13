package com.projects.plataformaDeCursosOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.projects.plataformaDeCursosOnline.controller.dto.AlunoDto;
import com.projects.plataformaDeCursosOnline.controller.form.AlunoForm;
import com.projects.plataformaDeCursosOnline.modelo.Aluno;
import com.projects.plataformaDeCursosOnline.repository.AlunoRepository;

import java.net.URI;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public List<AlunoDto> lista(String nomeAluno) {
        if (nomeAluno == null) {
            List<Aluno> alunos = alunoRepository.findAll();
            return AlunoDto.converter(alunos);
        } else {
            Aluno aluno = alunoRepository.findByNome(nomeAluno);
            if (aluno != null) {
                return Collections.singletonList(AlunoDto.converter(aluno));
            } else {
                return Collections.emptyList();
            }
        }
    }

    @PostMapping
    public ResponseEntity<AlunoDto> cadastrar(@RequestBody AlunoForm form, UriComponentsBuilder uriBuilder) {
        Aluno aluno = form.converter();

        // Verifica se o aluno já existe
        Aluno alunoExistente = alunoRepository.findByCpf(aluno.getCpf());
        if (alunoExistente != null) {
            return ResponseEntity.badRequest().build(); // Aluno já existe
        }

        alunoRepository.save(aluno);

        URI uri = uriBuilder.path("/alunos/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).body(new AlunoDto(aluno));
    }

}
