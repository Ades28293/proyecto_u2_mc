package com.uce.edu.demo.tarea.repository;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.tarea.repository.modelo.CiudadanoDeber;

public interface ICiudadanoRepository {
	
	public CiudadanoDeber buscarId(Integer id);

	public void insertar(CiudadanoDeber ciudadano);

	public void actualizar(CiudadanoDeber ciudadano);

	public void eliminar(Integer id);
}
