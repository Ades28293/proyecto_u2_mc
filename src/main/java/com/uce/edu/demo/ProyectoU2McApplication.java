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
		
		
	Persona p1=new Persona();
	p1.setApellido("Cen");
	p1.setNombre("Michael");
	p1.setCedula("1711169183");
	p1.setGenero("M");

	//this.iPersonaJpaService.guardar(p1);
	
	//1 TypedQuery
	Persona perTyped=this.iPersonaJpaService.buscarPorCedulaTyped("1720757101");
	LOGGER.info("Persona Typed: "+perTyped);
	
	//2 NamedQuery
	Persona perNamed=this.iPersonaJpaService.buscarPorCedulaNamed("1720757101");
	LOGGER.info("Persona Named: "+perNamed);
	
	
	//3 TypedQuery y  NamedQuery
	Persona perTypedNamed=this.iPersonaJpaService.buscarPorCedulaTypedNamed("1720757101");
	LOGGER.info("Persona TypedNamed: "+perTypedNamed);
	
	
	//4 Varios NamedQuery
	List<Persona> listapersona=	this.iPersonaJpaService.buscarNombreApellido("Michael", "Cen");
	
	for(Persona item:listapersona) {
		LOGGER.info("Persona: "+ item);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	}

}