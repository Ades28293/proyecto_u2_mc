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
import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;
import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.service.IPersonaJpaService;
import com.uce.edu.demo.tarea.repository.modelo.EstudianteContadorPorEstado;
import com.uce.edu.demo.tarea.repository.modelo.EstudianteSencillo;
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

		List<EstudianteSencillo> listaEstudianteSencillo = this.estudianteJpaService.buscarApellidoEstado("A");
		for (EstudianteSencillo item4 : listaEstudianteSencillo) {
			LOGGER.info("Estudiante Sencillo : " + item4);
		}

		List<EstudianteContadorPorEstado> listaEstudianteContadorPorEstado = this.estudianteJpaService
				.buscarContadorPorEstado();
		for (EstudianteContadorPorEstado item5 : listaEstudianteContadorPorEstado) {
			LOGGER.info("Estudiante Sencillo : " + item5);
		}

	}

}
