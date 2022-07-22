package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.correcion.service.IMatriculaGestorService;
import com.uce.edu.demo.correcion.service.IPropietarioService;
import com.uce.edu.demo.correcion.service.IVehiculoService;
import com.uce.edu.demo.repository.modelo.Empleado;
import com.uce.edu.demo.service.ICiudadanoJpaService;
import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.service.IPersonaJpaService;
import com.uce.edu.demo.tarea.repository.modelo.CiudadanoDeber;
import com.uce.edu.demo.tarea.repository.modelo.Pasaporte;
import com.uce.edu.demo.tarea.service.ICiudadanoService;
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

	@Autowired
	private ICiudadanoJpaService iCiudadanoJpaService;
	
	@Autowired
	private ICiudadanoService ciudadanoServiceDeber;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2McApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


//		Ciudadano c3 = new Ciudadano();
//		c3.setApellido("Cen");
//		c3.setNombre("Michael");
//		
//		Empleado empl3=new Empleado();
//		
//		empl3.setCodigoIes("98794654");
//		empl3.setSalario(new BigDecimal(600));
//		empl3.setCiudadano(c3);
//		
//		c3.setEmpleado(empl3);
//
//		this.iCiudadanoJpaService.insertar(c3);
		
	
	//Insertar	
	CiudadanoDeber ciud1 =new CiudadanoDeber();
	ciud1.setNombre("Maria");
	ciud1.setApellido("Hernandez");
	ciud1.setCedula("17207514314");
	ciud1.setFechaNacimiento(LocalDateTime.of(1998,9, 28,13,30)); 
	
	Pasaporte pasa1 =new Pasaporte();
	pasa1.setNumero("123465454341");
	pasa1.setFechaEmision(LocalDateTime.of(2005,9,28,5,30));
	pasa1.setFechaCaducidad(LocalDateTime.of(2016,9,28,5,30));
	pasa1.setCiudadano(ciud1);
	
	ciud1.setPasaporte(pasa1);
	
	this.ciudadanoServiceDeber.insertar(ciud1);
	
	
	//Actualizar
	CiudadanoDeber ciud2 =new CiudadanoDeber();
	ciud2.setId(3);
	ciud2.setNombre("Juan");
	ciud2.setApellido("Cen");
	ciud2.setCedula("1720757102");
	ciud2.setFechaNacimiento(LocalDateTime.of(1999,9, 28,13,30)); 
	this.ciudadanoServiceDeber.actualizar(ciud1);
	
	//Buscar
	 LOGGER.info("Ciudadano: "+this.ciudadanoServiceDeber.buscarId(3));
	
	 //Eliminar
	 this.ciudadanoServiceDeber.eliminar(5);
		

	}

}
