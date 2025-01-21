package com.new19.literalura;

import com.new19.literalura.principal.Principal;
import com.new19.literalura.repositorio.AutorRepositorio;
import com.new19.literalura.repositorio.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {
	@Autowired
	private LibroRepositorio repository;

	@Autowired
	private AutorRepositorio repositorioAutor;


	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repository, repositorioAutor);
		principal.mostrarMenu();
	}
}
