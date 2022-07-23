package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.correcion.service.IMatriculaGestorService;
import com.uce.edu.demo.correcion.service.IPropietarioService;
import com.uce.edu.demo.correcion.service.IVehiculoService;
import com.uce.edu.demo.repository.modelo.onetomany.Habitacion;
import com.uce.edu.demo.repository.modelo.onetomany.Hotel;
import com.uce.edu.demo.service.ICiudadanoJpaService;
import com.uce.edu.demo.service.IHabitacionService;
import com.uce.edu.demo.service.IHotelService;
import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.service.IPersonaJpaService;
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

	@Autowired
	private IHotelService hotelService;

	@Autowired
	private IHabitacionService habitacionService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2McApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Hotel hotel1 = new Hotel();
//
//		hotel1.setNombre("Hilton Colon UID");
//		hotel1.setDireccion("Patria y Amazonas");
//		this.hotelService.insertar(hotel1);

		// Buscar numero del hotel
		Hotel hote = new Hotel();
		hote.setId(1);

		Habitacion habi1 = new Habitacion();
		habi1.setNumero("A234");
		habi1.setPiso("10");
		habi1.setTipo("Familiar");
		habi1.setHotel(hote);
		
		Habitacion habi2 = new Habitacion();
		habi2.setNumero("A235");
		habi2.setPiso("1");
		habi2.setTipo("Matrimonial");
		habi2.setHotel(hote);
		
		
		this.habitacionService.insertar(habi1);
		this.habitacionService.insertar(habi2);

	}

}
