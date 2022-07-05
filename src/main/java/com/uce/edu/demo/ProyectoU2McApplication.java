package com.uce.edu.demo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Persona;

import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.service.IPersonaJpaService;


@SpringBootApplication
public class ProyectoU2McApplication implements CommandLineRunner{
	private static final Logger LOGGER = Logger.getLogger(ProyectoU2McApplication.class);
	
	@Autowired
	private IPersonaJdbcService iPersonaJdbcService;

	@Autowired
	private IPersonaJpaService iPersonaJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2McApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	//	LOGGER.info("Lista:"+this.iPersonaJdbcService.buscarTodos());
		
		//Buscar
		//LOGGER.info("Dato con Jpa: "+this.iPersonaJpaService.buscar(2));
		
		Persona per=new Persona();
		//per.setId(1);
		per.setNombre("Pepito");
		per.setApellido("Perez");
		
		//Guardar
		this.iPersonaJpaService.guardar(per);
		
		Persona per1=new Persona();
		per1.setId(2);
		per1.setNombre("Andre");
		per1.setApellido("Solis");
		
		//Actualizacion
		//this.iPersonaJpaService.actualizar(per1);

		//Eliminar
		//this.iPersonaJpaService.eliminar(1);
		
		
		
		
	}

}