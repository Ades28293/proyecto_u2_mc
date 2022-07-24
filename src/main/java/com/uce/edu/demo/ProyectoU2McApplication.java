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
import com.uce.edu.demo.tarea.repository.modelo.Medico;
import com.uce.edu.demo.tarea.service.ICiudadanoService;
import com.uce.edu.demo.tarea.service.IEstudianteJpaService;
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
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2McApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Insertar
		Medico medi=new Medico();
		medi.setNombre("Estefania");
		medi.setApellido("Lopez");
		
		this.iMedicoService.insertar(medi);
		
		//Actualizar
		Medico medi2=new Medico();
		medi2.setId(1);
		medi2.setNombre("Michael");
		medi2.setApellido("Cen");
		this.iMedicoService.actualizar(medi2);
		
		//Buscar
		LOGGER.info("Medico: "+this.iMedicoService.buscar(2));
		
		//Elimina
		this.iMedicoService.eliminar(2);
		
		
		
		
		

	}

}
