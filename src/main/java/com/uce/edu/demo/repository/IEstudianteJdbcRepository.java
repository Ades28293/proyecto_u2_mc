package com.uce.edu.demo.repository;

import com.uce.edu.demo.to.Estudiante;

public interface IEstudianteJdbcRepository {

	public Estudiante buscar(int id);
	
	public void insertar(Estudiante e);
	
	public void actualizar(Estudiante e);
	
	public void eliminar(int id);
}
