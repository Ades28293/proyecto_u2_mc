package com.uce.edu.demo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.cajero.repository.modelo.DetalleFactura;
import com.uce.edu.demo.cajero.repository.modelo.Factura;
import com.uce.edu.demo.cajero.service.IFacturaService;
import com.uce.edu.demo.correcion.service.IMatriculaGestorService;
import com.uce.edu.demo.correcion.service.IPropietarioService;
import com.uce.edu.demo.correcion.service.IVehiculoService;
import com.uce.edu.demo.service.IAutorService;
import com.uce.edu.demo.service.ICiudadanoJpaService;
import com.uce.edu.demo.service.IHabitacionService;
import com.uce.edu.demo.service.IHotelService;
import com.uce.edu.demo.service.ILibroService;
import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.service.IPersonaJpaService;
import com.uce.edu.demo.tarea.repository.modelo.onetomany.Autor2;
import com.uce.edu.demo.tarea.repository.modelo.onetomany.Libro2;
import com.uce.edu.demo.tarea.repository.modelo.onetomany.Libro2Autor2;
import com.uce.edu.demo.tarea.service.IAutor2Service;
import com.uce.edu.demo.tarea.service.ICiudadanoService;
import com.uce.edu.demo.tarea.service.IEstudianteJpaService;
import com.uce.edu.demo.tarea.service.ILibro2Autor2Service;
import com.uce.edu.demo.tarea.service.ILibro2Service;
import com.uce.edu.demo.tarea.service.IMedicoService;
import com.uce.edu.demo.tarea.service.IRecetaMedicaService;

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

	@Autowired
	private IHotelService hotelService;

	@Autowired
	private IHabitacionService habitacionService;

	@Autowired
	private IMedicoService iMedicoService;

	@Autowired
	private IRecetaMedicaService iRecetaMedicaService;

	@Autowired
	private ILibroService iLibroService;

	@Autowired
	private IAutorService autorService;
	
	
	@Autowired
	private IAutor2Service autor2Service;
	
	@Autowired
	private ILibro2Service libro2Service;
	
	@Autowired
	private ILibro2Autor2Service autor2Service2;
	
	@Autowired
	private IFacturaService facturaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2McApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

/*	Factura fact= this.facturaService.consultar(1);

	LOGGER.info(fact.getNumero());
	LOGGER.info("Fecha: "+fact.getFecha());	
	LOGGER.info("Cliente: "+fact.getCliente().getNumeroTarjeta());	
	
	List<DetalleFactura> detalles=fact.getDetalles();
	for(DetalleFactura deta:detalles) {
		LOGGER.info("Detalle: "+ deta);
	}
	*/
	
	LOGGER.info("hola mundo ");
	
	
	}

}
