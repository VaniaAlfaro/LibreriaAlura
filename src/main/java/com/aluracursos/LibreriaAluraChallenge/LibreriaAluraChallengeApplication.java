package com.aluracursos.LibreriaAluraChallenge;

import com.aluracursos.LibreriaAluraChallenge.principal.Principal;
import com.aluracursos.LibreriaAluraChallenge.repository.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibreriaAluraChallengeApplication implements CommandLineRunner {

	@Autowired
	private LibrosRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(LibreriaAluraChallengeApplication.class, args);}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repository);
		principal.muestraMenu();
	}
}
