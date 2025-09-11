package com.example.ex;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ex.models.Aluno;
import com.example.ex.models.Cursos;
import com.example.ex.repositories.AlunoRepository;
import com.example.ex.repositories.CursoRepository;

@SpringBootApplication
public class ExApplication {

	
	@Bean
	public CommandLineRunner init(
			@Autowired CursoRepository cursoRepository,
			@Autowired AlunoRepository alunoRepository) {
				
				return args -> {
					
					Cursos curso1 = cursoRepository.inserir(new Cursos(0, "Engenharia de Software"));
					Cursos curso2 = cursoRepository.inserir(new Cursos(0, "Medicina"));
					
					
					alunoRepository.inserir(new Aluno(0, "jubileu", 2025, 1));
					alunoRepository.inserir(new Aluno(1, "jair", 2025, 2));
					
			
			System.out.println("Cursos cadastrados:");
			List<Cursos> cursos = cursoRepository.listarTodos();
			cursos.forEach(c -> System.out.println(c.getNomeCurso()));

			System.out.println("\nAlunos cadastrados:");
			List<Aluno> alunos = alunoRepository.listarTodos();
			alunos.forEach(a -> System.out.println("Aluno: " + a.getNome() + ", Curso: " + a.getCursos().getNomeCurso()));
			
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(ExApplication.class, args);
	}
}