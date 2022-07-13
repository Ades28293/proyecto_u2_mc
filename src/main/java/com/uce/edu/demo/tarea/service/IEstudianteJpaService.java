package com.uce.edu.demo.tarea.service;

import java.util.List;

import com.uce.edu.demo.tarea.repository.modelo.Estudiante;

public interface IEstudianteJpaService {
	
	public Estudiante buscar(Integer id);
	
	public void insertar(Estudiante e);
	
	public void actualizar(Estudiante e);
	
	public void eliminar(Integer id);
	
	public List<Estudiante> buscarPorNombreNative(String nombre);
	public List<Estudiante> buscarPorNombreNamedNative(String nombre);
	
	public List<Estudiante> buscarPorApellidoNative(String apellido);
	public List<Estudiante> buscarPorApellidoNamedNative(String apellido);
}
