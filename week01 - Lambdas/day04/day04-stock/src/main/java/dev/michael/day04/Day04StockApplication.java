package dev.michael.day04;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dev.michael.day04.model.Produto;
import dev.michael.day04.model.repository.ProdutoRepository;

@SpringBootApplication
public class Day04StockApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day04StockApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ProdutoRepository produtoRepository) {
		return args -> {
			produtoRepository.save(new Produto("Notebook", 5, 3500.0));
			produtoRepository.save(new Produto("Mouse", 50, 80.0));
			produtoRepository.save(new Produto("Teclado", 2, 150.0));
			produtoRepository.save(new Produto("Monitor", 8, 1200.0));
			produtoRepository.save(new Produto("Cadeira Gamer", 1, 900.0));

			System.out.println("=== PRODUTOS NO BANCO ===");
			produtoRepository.findAll()
				.forEach(System.out::println);
		};
	}

}
