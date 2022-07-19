package com.uce.edu.demo.tarea.service;

import java.util.List;

import com.uce.edu.demo.tarea.repository.modelo.Estudiante;
import com.uce.edu.demo.tarea.repository.modelo.EstudianteContadorPorEstado;
import com.uce.edu.demo.tarea.repository.modelo.EstudianteSencillo;

public interface IEstudianteJpaService {
	
	public Estudiante buscar(Integer id);
	
	public void insertar(Estudiante e);
	
	public void actualizar(Estudiante e);
	
	public void eliminar(Integer id);
	
	public List<Estudiante> buscarPorNombreNative(String nombre);
	public List<Estudiante> buscarPorNombreNamedNative(String nombre);
	
	public List<Estudiante> buscarPorApellidoNative(String apellido);
	public List<Estudiante> buscarPorApellidoNamedNative(String apellido);
	
	public List<Estudiante> buscarPorNombreApellidoCriteriaApi(String nombre,String apellido);
	public List<Estudiante> buscarDinamicamentePredicados(String nombre, String apellido, String estado);
	
	public List<EstudianteSencillo> buscarApellidoEstado( String estado);
	public List<EstudianteContadorPorEstado> buscarContadorPorEstado();
}
