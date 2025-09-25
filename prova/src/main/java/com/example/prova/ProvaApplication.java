package com.example.prova;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.prova.models.Diretor;
import com.example.prova.models.Filme;
import com.example.prova.repositories.FilmeRepository;
import com.example.prova.repositories.DiretorRepository;
import java.util.List;

@SpringBootApplication
public class ProvaApplication {

	@Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private DiretorRepository diretorRepository;

@Bean
    public CommandLineRunner init() {
        return args -> {

                                            //inserir diretores
             Diretor d1 = new Diretor(null, "Steven Spielberg", null);
             Diretor d2 = new Diretor(null, "Stan Lee", null);
             Diretor d3 = new Diretor(null, "Sofia Coppola", null);

                                            //salvar os diretor
             diretorRepository.save(d1);
             diretorRepository.save(d2);
             diretorRepository.save(d3);

                                            //inserir filmes
            Filme f1 = new Filme(null, "O Rei Leão", 120, d3);
            Filme f2 = new Filme(null, "Vingadores: Ultimato", 180, d1);
            Filme f3 = new Filme(null, "Frozen", 90, d2);

                                            //salvar filmes
            filmeRepository.save(f1);
            filmeRepository.save(f2);
            filmeRepository.save(f3);
            
                                        //testes com filmes
            System.out.println("Cursos que tem mais de 90 min");
            filmeRepository.findByDuraçaoGreaterThan(90)
					.forEach(System.out::println);

                    System.out.println("Cursos que tem menos de 130 min");
            filmeRepository.findByDuraçaoLessThan(130)
					.forEach(System.out::println);

                    System.out.println("Cursos que começam com a letra 'F'");
            filmeRepository.findByTituloStartingWith("F")
					.forEach(System.out::println);

                                        //testes com diretores
            System.out.println("\nDiretores que começam com 'St':");
            diretorRepository.findByNomeStartingWith("St")
                    .forEach(System.out::println);

                    System.out.println("\nBuscar diretor pelo seu ID junto com seus filmess");
            List<Diretor> diretorComFilmes = diretorRepository.findByIdWithFilmes(d2.getId());
        };

    }

    

	public static void main(String[] args) {
		SpringApplication.run(ProvaApplication.class, args);
	}
}
