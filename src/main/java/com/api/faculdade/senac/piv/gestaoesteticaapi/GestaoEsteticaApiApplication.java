package com.api.faculdade.senac.piv.gestaoesteticaapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class GestaoEsteticaApiApplication {

	public CommandLineRunner commandLineRunner(){
		return args -> {
			LocalTime time = LocalTime.now();
			System.out.println("Horas atual: " + time);
			LocalDate data = LocalDate.now();
			System.out.println("Data atual: "+ data);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(GestaoEsteticaApiApplication.class, args);
	}

}
