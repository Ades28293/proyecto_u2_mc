package com.uce.edu.demo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.correcion.service.IMatriculaGestorService;
import com.uce.edu.demo.correcion.service.IPropietarioService;
import com.uce.edu.demo.correcion.service.IVehiculoService;
import com.uce.edu.demo.repository.modelo.manytomany.Autor;
import com.uce.edu.demo.repository.modelo.manytomany.Libro;
import com.uce.edu.demo.service.IAutorService;
import com.uce.edu.demo.service.ICiudadanoJpaService;
import com.uce.edu.demo.service.IHabitacionService;
import com.uce.edu.demo.service.IHotelService;
import com.uce.edu.demo.service.ILibroService;
import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.service.IPersonaJpaService;
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

	@Autowired
	private ILibroService iLibroService;

	@Autowired
	private IAutorService autorService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2McApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		 * //Insertar Medico medi=new Medico(); medi.setNombre("Estefania");
		 * medi.setApellido("Lopez");
		 * 
		 * this.iMedicoService.insertar(medi);
		 * 
		 * //Actualizar Medico medi2=new Medico(); medi2.setId(1);
		 * medi2.setNombre("Michael"); medi2.setApellido("Cen");
		 * this.iMedicoService.actualizar(medi2);
		 * 
		 * //Buscar LOGGER.info("Medico: "+this.iMedicoService.buscar(2));
		 * 
		 * //Elimina this.iMedicoService.eliminar(2);
		 */

		Autor autor1 = new Autor();
		autor1.setNombre("Juan Perez");

		Set<Autor> autores = new HashSet<>();
		autores.add(autor1);

		Libro libr = new Libro();
		libr.setTitulo("JPA");
		libr.setCantidadPaginas(250);

		libr.setAutores(autores);

		this.iLibroService.insertar(libr);

	}

}
