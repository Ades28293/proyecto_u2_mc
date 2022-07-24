package com.uce.edu.demo.tarea.service;

import com.uce.edu.demo.tarea.repository.modelo.RecetaMedica;

public interface IRecetaMedicaService {
	
	public RecetaMedica buscar(Integer id);

	public void insertar(RecetaMedica rece);

	public void actualizar(RecetaMedica rece);

	public void eliminar(Integer id);
}
