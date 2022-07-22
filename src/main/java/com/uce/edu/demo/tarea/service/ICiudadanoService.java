package com.uce.edu.demo.tarea.service;

import com.uce.edu.demo.tarea.repository.modelo.CiudadanoDeber;

public interface ICiudadanoService {
	public CiudadanoDeber buscarId(Integer id);

	public void insertar(CiudadanoDeber ciudadano);

	public void actualizar(CiudadanoDeber ciudadano);

	public void eliminar(Integer id);
}
