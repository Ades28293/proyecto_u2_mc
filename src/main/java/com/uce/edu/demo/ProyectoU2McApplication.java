package com.uce.edu.demo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
	

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2McApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	

		Autor2 auto2=new Autor2();
		auto2.setNombre("Miguel de Cervantes");
		
		Autor2 auto3=new Autor2();
		auto3.setNombre("Juana Velez");
			

		Autor2 auto4=new Autor2();
		auto4.setNombre("María Juana");
		
		this.autor2Service.insertar(auto2);
		this.autor2Service.insertar(auto3);
		this.autor2Service.insertar(auto4);
			
		
		Libro2 libro2 = new Libro2();
		libro2.setTitulo("Odisea");
		libro2.setCantidadPaginas(250);
		
		Libro2 libro3 = new Libro2();
		libro3.setTitulo("Los 7 cerditos");
		libro3.setCantidadPaginas(250);
		
		Libro2 libro4 = new Libro2();
		libro4.setTitulo("JPA");
		libro4.setCantidadPaginas(250);
		
		this.libro2Service.insertar(libro2);
		this.libro2Service.insertar(libro3);
		this.libro2Service.insertar(libro4);
		
		Libro2Autor2 libro2Autor2 =new Libro2Autor2();
		libro2Autor2.setAutor2(auto4);
		libro2Autor2.setLibro2(libro2);
		
		
		
		Libro2Autor2 libro2Autor3 =new Libro2Autor2();
		libro2Autor3.setAutor2(auto3);
		libro2Autor3.setLibro2(libro2);
		
		
		Libro2Autor2 libro2Autor4 =new Libro2Autor2();
		libro2Autor4.setAutor2(auto2);
		libro2Autor4.setLibro2(libro4);
		
		
		Libro2Autor2 libro2Autor5 =new Libro2Autor2();
		libro2Autor5.setAutor2(auto2);
		libro2Autor5.setLibro2(libro4);
		
		this.autor2Service2.insertar(libro2Autor2);
		this.autor2Service2.insertar(libro2Autor3);
		this.autor2Service2.insertar(libro2Autor4);
		this.autor2Service2.insertar(libro2Autor5);
		
	}

}
