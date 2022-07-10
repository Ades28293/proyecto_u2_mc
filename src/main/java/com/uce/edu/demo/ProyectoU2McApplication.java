package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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

		Vehiculo v = new Vehiculo();
		v.setMarca("Ferrary");
		v.setPlaca("PCT8451");
		v.setPrecio(new BigDecimal(90000));
		v.setTipo("L");

		this.iVehiculoService.insertar(v);

		Propietario p = new Propietario();
		p.setNombre("Maria");
		p.setApellido("Perez");
		p.setCedula("1720757541");
		p.setFecha(LocalDateTime.now());

		this.iPropietarioService.crear(p);

		// Actualizar
		v.setId(4);
		v.setPlaca("PCT8111");
		this.iVehiculoService.actualizar(v);

	}

}