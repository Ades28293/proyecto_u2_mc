package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.correcion.repository.modelo.Propietario;
import com.uce.edu.demo.correcion.repository.modelo.Vehiculo;
import com.uce.edu.demo.correcion.service.IMatriculaGestorService;
import com.uce.edu.demo.correcion.service.IPropietarioService;
import com.uce.edu.demo.correcion.service.IVehiculoService;
import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.service.IPersonaJpaService;

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

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2McApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		// Deber
		// 1 TypedQuery
		List<Persona> listapersona1 = this.iPersonaJpaService.buscarPorGeneroTyped("M");
		for (Persona item : listapersona1) {
			LOGGER.info("Persona: " + item);
		}

		// 2 NamedQuery
		List<Persona> listapersona2 = this.iPersonaJpaService.buscarPorGeneroNamed("M");
		for (Persona item : listapersona2) {
			LOGGER.info("Persona: " + item);
		}
		// 3 TypedQuery y NamedQuery
		List<Persona> listapersona3 = this.iPersonaJpaService.buscarPorGeneroTypedNamed("M");
		for (Persona item : listapersona3) {
			LOGGER.info("Persona: " + item);

		}

		// 1 TypedQuery
		Persona per1Typed = this.iPersonaJpaService.buscarPorCedulaApellidoTyped("1720757432", "Aguirre");
		LOGGER.info("Persona Typed: " + per1Typed);
		
		// 2 NamedQuery
		Persona per1Named = this.iPersonaJpaService.buscarPorCedulaApellidoNamed("1720757432", "Aguirre");
		LOGGER.info("Persona Named: " + per1Named);
		
		// 3 TypedQuery y NamedQuery
		Persona per1TypedNamed = this.iPersonaJpaService.buscarPorCedulaApellidoTypedNamed("1720757432", "Aguirre");
		LOGGER.info("Persona TypedNamed: " + per1TypedNamed);
	}
}
