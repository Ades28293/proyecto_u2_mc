package com.uce.edu.demo.tarea.repository;

import com.uce.edu.demo.tarea.to.EstudianteTo;

public interface IEstudianteJdbcRepository {

	public EstudianteTo buscar(int id);
	
	public void insertar(EstudianteTo e);
	
	public void actualizar(EstudianteTo e);
	
	public void eliminar(int id);
}
