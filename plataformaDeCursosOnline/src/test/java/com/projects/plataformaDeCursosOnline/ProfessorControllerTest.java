package com.projects.plataformaDeCursosOnline;

import static org.mockito.Mockito.when;

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

import com.projects.plataformaDeCursosOnline.modelo.Professor;
import com.projects.plataformaDeCursosOnline.repository.ProfessorRepository;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringRunner.class)
@ComponentScan(basePackages = {"com.projects.plataformaDeCursosOnline"})
@SpringBootTest
@AutoConfigureMockMvc


public class ProfessorControllerTest  {
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private ProfessorRepository professorRepository;
    
    @Test
    public void testListarProfessorPorNome() throws Exception {
        final String expectedNome = "Felipe Moraes Marcello";
        final String expectedCpf = "58421985990";
        final String expectedSexo = "M";
        
        Professor professorMock = new Professor(expectedNome, expectedCpf, expectedSexo);
        when(professorRepository.findByNome(expectedNome)).thenReturn(professorMock);
        
        /*Precisa retornar a primeira posicao*/
        mockMvc.perform(MockMvcRequestBuilders.get("/professores").param("nomeProfessor", expectedNome).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect((ResultMatcher) jsonPath("$[0].nome").value(expectedNome))
                .andExpect((ResultMatcher) jsonPath("$[0].cpf").value(expectedCpf))
                .andExpect((ResultMatcher) jsonPath("$[0].sexo").value(expectedSexo));
    }
    
    
    @Test
    public void testCreateProfessor() throws Exception{
    	final String expectedNome = "Felipe Moraes Marcello";
    	final String expectedCpf = "58421985990";
        final String expectedSexo = "M";
        mockMvc
            .perform(MockMvcRequestBuilders.post("/professores").contentType(MediaType.APPLICATION_JSON).content("{\"nome\":\"Felipe Moraes Marcello\",\"cpf\":\"58421985990\",\"sexo\":\"M\"}"))
            .andExpect(MockMvcResultMatchers.status().is(201))
            .andExpect((ResultMatcher) jsonPath("nome").value(expectedNome))
            .andExpect((ResultMatcher) jsonPath("cpf").value(expectedCpf))
            .andExpect((ResultMatcher) jsonPath("sexo").value(expectedSexo));
    }
    
}