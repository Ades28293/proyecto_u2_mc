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

//		// 1 NativeQuery
//		Persona per1Native = this.iPersonaJpaService.buscarPorCedulaNative("1720757101");
//		LOGGER.info("Persona Typed: " + per1Native);
//
//		
//		//2  NamedNativeQuery
//		Persona per1NamedNative = this.iPersonaJpaService.buscarPorCedulaNamedNative("1720757101");
//		LOGGER.info("Persona Typed: " + per1NamedNative);
		
//		//Criteria Api
//		Persona per1CriteriaApi = this.iPersonaJpaService.buscarPorCedulaCriteriaApi("1720757101");
//		LOGGER.info("Persona Criteria Api: " + per1CriteriaApi);
		
		
		//Criteria Api Dinamicamente
//		
//		Persona per1Dinamicamente = this.iPersonaJpaService.buscarDinamicamente("Daniel", "Velez", "M");
//		LOGGER.info("Persona Criteria Api Dinamicamente: " + per1Dinamicamente);
		
//		Persona per1Dinamicamente1 = this.iPersonaJpaService.buscarDinamicamente("Andrea", "Aguirre", "F");
//		LOGGER.info("Persona Criteria Api Dinamicamente: " + per1Dinamicamente1);
		
		List<Persona> per1Dinamicamente=this.iPersonaJpaService.buscarDinamicamente("Daniel", "Velez", "M");
		for(Persona item:per1Dinamicamente) {
			LOGGER.info("Persona Criteria Api Dinamicamente: " + per1Dinamicamente);
		}
		
	LOGGER.info("--------------");	
		List<Persona> per1Dinamicamente1=this.iPersonaJpaService.buscarDinamicamente("Juana", "Aguirre", "F");
		for(Persona item2:per1Dinamicamente1) {
			LOGGER.info("Persona Criteria Api Dinamicamente: " + per1Dinamicamente1);
		}
		
		
		
		
		
		}
		
	

		
}
