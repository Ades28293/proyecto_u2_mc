package com.uce.edu.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@SpringBootApplication
public class ProyectoU2McApplication implements CommandLineRunner{
	private static final Logger LOGGER = LoggerFactory.getLogger(ProyectoU2McApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2McApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//System.out.println("Hola mundo");
		
		LOGGER.info("Hola Mundo");
		
		
	}

}
