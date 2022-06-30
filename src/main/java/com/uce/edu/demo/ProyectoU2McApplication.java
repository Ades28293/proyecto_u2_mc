package com.uce.edu.demo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.service.IPersonaJpaService;
import com.uce.edu.demo.tarea.repository.IEstudianteJpaRepository;
import com.uce.edu.demo.tarea.repository.modelo.Estudiante;
import com.uce.edu.demo.tarea.service.IEstudianteJdbcService;
import com.uce.edu.demo.tarea.service.IEstudianteJpaService;


@SpringBootApplication
public class ProyectoU2McApplication implements CommandLineRunner{
	private static final Logger LOGGER = Logger.getLogger(ProyectoU2McApplication.class);
	
	@Autowired
	private IPersonaJdbcService iPersonaJdbcService;
	
	@Autowired
	private IEstudianteJdbcService iEstudianteJdbcService;
	
	@Autowired
	private IPersonaJpaService iPersonaJpaService;
	
	@Autowired
	private IEstudianteJpaService iEstudianteJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2McApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		//Estudiante
		//Buscar
		//LOGGER.info(this.iEstudianteJpaService.buscar(2));		
		
		
		Estudiante e= new Estudiante();
		e.setId(4);
		e.setNombre("Maria");
		e.setApellido("Diaz");
		e.setEdad(22);
		e.setDireccion("Quito");
		
		//Insertar
		//this.iEstudianteJpaService.insertar(e);
		
		
		Estudiante e1= new Estudiante();
		e1.setId(2);
		e1.setNombre("Luisa");
		e1.setApellido("Magdalena");
		e1.setEdad(21);
		e1.setDireccion("Quito");
		
		//Actualizar
		//this.iEstudianteJpaService.actualizar(e1);
		
		
		//Eliminar
		//this.iEstudianteJpaService.eliminar(1);
		
	}

}
