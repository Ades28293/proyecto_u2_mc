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
		
		
		Estudiante e1=new Estudiante();
		e1.setNombre("Maria");
		e1.setApellido("Magdalena");
		e1.setEdad(22);
		e1.setDireccion("Sangolqui");
	
		//this.estudianteJpaService.insertar(e1);
		
		
		
		 //1 NativeQuery
		List<Estudiante> listaestudiante=	this.estudianteJpaService.buscarPorApellidoNative("Cen");
		for(Estudiante item:listaestudiante) {
			LOGGER.info("Estudiante NativeQuery: "+ item);
		}
		
		List<Estudiante> listaestudiante1=	this.estudianteJpaService.buscarPorNombreNative("Maria");
		for(Estudiante item:listaestudiante1) {
			LOGGER.info("Estudiante NativeQuery: "+ item);
		}
		
		//2 NamedNativeQuery
		List<Estudiante> listaestudiante2=	this.estudianteJpaService.buscarPorNombreNamedNative("Michael");
		for(Estudiante item:listaestudiante) {
			LOGGER.info("Estudiante NameNativeQuery: "+ item);
		}
		
		
		List<Estudiante> listaestudiante3=	this.estudianteJpaService.buscarPorApellidoNamedNative("Magdalena");
		for(Estudiante item:listaestudiante) {
			LOGGER.info("Estudiante NameNativeQuery: "+ item);
		}
		
		
		
		
		
		
		
		
		
	}
}
