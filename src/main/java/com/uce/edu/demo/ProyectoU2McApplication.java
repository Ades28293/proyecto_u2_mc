package com.uce.edu.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.to.Persona;


@SpringBootApplication
public class ProyectoU2McApplication implements CommandLineRunner{
	private static final Logger LOGGER = LoggerFactory.getLogger(ProyectoU2McApplication.class);
	
	@Autowired
	private IPersonaJdbcService iPersonaJdbcService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2McApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Persona p1=new Persona();
		p1.setId(2);
		p1.setNombre("Juan");
		p1.setApellido("Perez");
		
		//this.iPersonaJdbcService.guardar(p1);
		
		
		
		Persona p2=new Persona();
		p2.setId(2);
		p2.setNombre("Pepito");
		p2.setApellido("Velez");
	
		//Actualizar
		//	this.iPersonaJdbcService.actualizar(p2);
		
		//elimianr
		//this.iPersonaJdbcService.eliminar(1);
		
		
		//buscar
		this.iPersonaJdbcService.buscar(2);
		
		
		
	}

}
