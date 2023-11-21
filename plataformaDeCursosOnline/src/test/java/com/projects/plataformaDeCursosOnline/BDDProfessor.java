/*package com.projects.plataformaDeCursosOnline;
import static org.junit.Assert.assertEquals;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import com.projects.plataformaDeCursosOnline.modelo.Professor;
import com.projects.plataformaDeCursosOnline.modelo.Curso;
import com.projects.plataformaDeCursosOnline.modelo.Plataforma;
import com.projects.plataformaDeCursosOnline.modelo.Trilha;

public class BDDProfessor{

    private Plataforma plataforma;
    private Professor professor1, professor2;
    private Curso curso1, curso2, curso3;
    private Trilha trilha1, trilha2;
    private double i = 0.0;

    @Before
    public void setUp() {
        plataforma = new Plataforma("Minha Plataforma de Educação");
        trilha1 = new Trilha("Desenvolvimento de Software", "Trilha de desenvolvimento de software");
        trilha2 = new Trilha("Inteligência Artificial", "Trilha de IA");
        curso1 = new Curso("Java Programming", "Curso de programação Java", "Java");
		curso2 = new Curso("Web Development", "Curso de desenvolvimento web", "Web");
		curso3 = new Curso("Machine Learning", "Curso de aprendizado de máquina", "ML");
		
		professor1 = new Professor("João","123.456.789-00", "Masculino");
		professor2 = new Professor("Josefina","133.456.789-00", "Feminino");
    }

    @Test
    public void testEditarTrilhaExistente() {
    	//ARANGE
    	curso1.adicionaProfessorLista(professor1);
    	curso1.adicionaProfessorLista(professor2);
		
    	trilha1.adicionaCursoLista(curso1);
    	trilha1.adicionaCursoLista(curso2);
    	trilha2.adicionaCursoLista(curso3);
		
    	plataforma.adicionarTrilhaLista(trilha1);
    	plataforma.adicionarTrilhaLista(trilha2);
		
    	//ACTION
    	plataforma.editarTrilhaPorNome("Inteligência Artificial", "Processamento de Sinais", "Trilha de PS");
		
    	Iterator<Trilha> iterator= plataforma.getListaTrilha().iterator();
		
    	while(iterator.hasNext()) {
    		Trilha trilha= iterator.next();
			
    		if(trilha.getNome().equals("Processamento de Sinais")) {
    			i++;
    		}
    	}
		
    	//ASSERT
    	assertEquals(i, 1.0, 0.0001);
    }
    
}*/