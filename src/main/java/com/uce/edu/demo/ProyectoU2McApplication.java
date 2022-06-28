package com.uce.edu.demo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.IEstudianteJdbcService;
import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.to.Estudiante;
import com.uce.edu.demo.to.Persona;


@SpringBootApplication
public class ProyectoU2McApplication implements CommandLineRunner{
	private static final Logger LOGGER = Logger.getLogger(ProyectoU2McApplication.class);
	
	@Autowired
	private IPersonaJdbcService iPersonaJdbcService;
	
	@Autowired
	private IEstudianteJdbcService iEstudianteJdbcService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2McApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		Persona p1=new Persona();
//		p1.setId(2);
//		p1.setNombre("Juan");
//		p1.setApellido("Perez");
//		
//		//this.iPersonaJdbcService.guardar(p1);
//		
//		Persona p2=new Persona();
//		p2.setId(2);
//		p2.setNombre("Pepito");
//		p2.setApellido("Velez");
//	
//		//Actualizar
//		//	this.iPersonaJdbcService.actualizar(p2);
//		
//		//elimianr
//		//this.iPersonaJdbcService.eliminar(1);
//		
//		
//		//buscar
//		LOGGER.info(this.iPersonaJdbcService.buscar(2));
		
		Estudiante e =new Estudiante();
		e.setId(2);
		e.setNombre("Erick");
		e.setApellido("Quishpe");
		e.setEdad(22);
		e.setDireccion("Quito");
	//	this.iEstudianteJdbcService.guardar(e);
		
		Estudiante e1=new Estudiante();
		e1.setId(2);
		e1.setNombre("Luis");
		e1.setApellido("Quishpe");
		e1.setEdad(22);
		e1.setDireccion("Quito");
		//Actualizar
		//this.iEstudianteJdbcService.actualizar(e1);
		
		
		//Eliminar
		//this.iEstudianteJdbcService.eliminar(1);
		
		//Buscar
		LOGGER.info(this.iEstudianteJdbcService.buscar(2));
		

		
		
		
		
	}

}
