package com.uce.edu.demo.tarea.service;

import com.uce.edu.demo.tarea.repository.modelo.Estudiante;

public interface IEstudianteJpaService {
	
	public Estudiante buscar(Integer id);
	
	public void insertar(Estudiante e);
	
	public void actualizar(Estudiante e);
	
	public void eliminar(Integer id);
}
