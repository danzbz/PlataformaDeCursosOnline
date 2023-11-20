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

import com.projects.plataformaDeCursosOnline.modelo.Curso;
import com.projects.plataformaDeCursosOnline.repository.CursoRepository;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.Arrays;


@RunWith(SpringRunner.class)
@ComponentScan(basePackages = {"com.projects.plataformaDeCursosOnline"})
@SpringBootTest
@AutoConfigureMockMvc


public class CursoControllerTest  {
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private CursoRepository cursoRepository;
    
    
    @Test
    public void testListarAlunoPorNome() throws Exception {
    	final String expectedNome = "Programação Orientada a Objetos";
    	final String expectedDescricao = "Programação orientada a objetos é um paradigma de programação baseado no conceito de objetos...";
        final String expectedCategoria = "Programação";
        
        Curso cursoMock = new Curso(expectedNome, expectedDescricao, expectedCategoria);
        when(cursoRepository.findByNome(expectedNome)).thenReturn(cursoMock);
        
        /*Precisa retornar a primeira posicao*/
        mockMvc.perform(MockMvcRequestBuilders.get("/cursos").param("nomeCurso", expectedNome).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect((ResultMatcher) jsonPath("$[0].nome").value(expectedNome))
                .andExpect((ResultMatcher) jsonPath("$[0].descricao").value(expectedDescricao));
    }
    
    
    @Test
    public void testCreateCurso() throws Exception{
    	final String expectedNome = "Programação Orientada a Objetos";
    	final String expectedDescricao = "Programação orientada a objetos é um paradigma de programação baseado no conceito de objetos...";
        final String expectedCategoria = "Programação";
        mockMvc
            .perform(MockMvcRequestBuilders.post("/cursos").contentType(MediaType.APPLICATION_JSON).content("{\"nome\":\"Programação Orientada a Objetos\",\"descricao\":\"Programação orientada a objetos é um paradigma de programação baseado no conceito de objetos...\",\"categoria\":\"Programação\"}"))
            .andExpect(MockMvcResultMatchers.status().is(201))
            .andExpect((ResultMatcher) jsonPath("nome").value(expectedNome))
            .andExpect((ResultMatcher) jsonPath("descricao").value(expectedDescricao))
            .andExpect((ResultMatcher) jsonPath("categoria").value(expectedCategoria));
    }
    
}