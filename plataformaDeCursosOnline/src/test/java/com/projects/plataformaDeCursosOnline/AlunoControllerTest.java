package com.projects.plataformaDeCursosOnline;

import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.projects.plataformaDeCursosOnline.modelo.Aluno;
import com.projects.plataformaDeCursosOnline.repository.AlunoRepository;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.Arrays;


@RunWith(SpringRunner.class)
@ComponentScan(basePackages = {"com.projects.plataformaDeCursosOnline"})
@SpringBootTest
@AutoConfigureMockMvc


public class AlunoControllerTest  {
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private AlunoRepository alunoRepository;
    
    /*@Test
    public void testListarAlunoPorNomeFalhando() throws Exception {
        final String expectedNome = "Danilo de Paula Vieira";
        final String expectedCpf = "12345678912";
        final String expectedSexo = "M";
        
        Aluno alunoMock = new Aluno(expectedNome, expectedCpf, expectedSexo);
        when(alunoRepository.findByNome(expectedNome)).thenReturn(alunoMock);
        
        mockMvc.perform(MockMvcRequestBuilders.get("/alunos").param("nomeAluno", expectedNome).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect((ResultMatcher) jsonPath("nome").value(expectedNome))
                .andExpect((ResultMatcher) jsonPath("cpf").value(expectedCpf))
                .andExpect((ResultMatcher) jsonPath("sexo").value(expectedSexo));
    }*/
    
    @Test
    public void testListarAlunoPorNome() throws Exception {
        final String expectedNome = "Danilo de Paula Vieira";
        final String expectedCpf = "12345678912";
        final String expectedSexo = "M";
        
        Aluno alunoMock = new Aluno(expectedNome, expectedCpf, expectedSexo);
        when(alunoRepository.findByNome(expectedNome)).thenReturn(alunoMock);
        
        /*Precisa retornar a primeira posicao*/
        mockMvc.perform(MockMvcRequestBuilders.get("/alunos").param("nomeAluno", expectedNome).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect((ResultMatcher) jsonPath("$[0].nome").value(expectedNome))
                .andExpect((ResultMatcher) jsonPath("$[0].cpf").value(expectedCpf))
                .andExpect((ResultMatcher) jsonPath("$[0].sexo").value(expectedSexo));
    }
    
    
    @Test
    public void testCreateAluno() throws Exception{
    	final String expectedNome = "Danilo de Paula Vieira";
    	final String expectedCpf = "12345678912";
        final String expectedSexo = "M";
        mockMvc
            .perform(MockMvcRequestBuilders.post("/alunos").contentType(MediaType.APPLICATION_JSON).content("{\"nome\":\"Danilo de Paula Vieira\",\"cpf\":\"12345678912\",\"sexo\":\"M\"}"))
            .andExpect(MockMvcResultMatchers.status().is(201))
            .andExpect((ResultMatcher) jsonPath("nome").value(expectedNome))
            .andExpect((ResultMatcher) jsonPath("cpf").value(expectedCpf))
            .andExpect((ResultMatcher) jsonPath("sexo").value(expectedSexo));
    }
    
}