package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.correcion.service.IMatriculaGestorService;
import com.uce.edu.demo.correcion.service.IPropietarioService;
import com.uce.edu.demo.correcion.service.IVehiculoService;
import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.service.IPersonaJpaService;
import com.uce.edu.demo.tarea.repository.modelo.Estudiante;
import com.uce.edu.demo.tarea.service.IEstudianteJpaService;

@SpringBootApplication
public class ProyectoU2McApplication implements CommandLineRunner {
	private static final Logger LOGGER = Logger.getLogger(ProyectoU2McApplication.class);

	@Autowired
	private IPersonaJdbcService iPersonaJdbcService;

	@Autowired
	private IPersonaJpaService iPersonaJpaService;

	@Autowired
	private IVehiculoService iVehiculoService;

	@Autowired
	private IPropietarioService iPropietarioService;

	@Autowired
	private IMatriculaGestorService gestorService;
	
	@Autowired
	private IEstudianteJpaService estudianteJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2McApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		
		List<Estudiante> per1Dinamicamente=this.estudianteJpaService.buscarPorNombreApellidoCriteriaApi("Andrea", "Carrera");
		for(Estudiante item:per1Dinamicamente) {
			LOGGER.info("Persona Criteria Api Dinamicamente: " + per1Dinamicamente);
		}
		
	LOGGER.info("--------------");	
		List<Estudiante> per1Dinamicamente1=this.estudianteJpaService.buscarDinamicamentePredicados("Zhong", "Cen", "A");
		for(Estudiante item2:per1Dinamicamente1) {
			LOGGER.info("Estudiante Criteria Api Dinamicamente: " + per1Dinamicamente1);
		}
		

		
		
		}
		
	

		
}
