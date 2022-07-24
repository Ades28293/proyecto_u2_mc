package com.uce.edu.demo.tarea.repository;

import com.uce.edu.demo.tarea.repository.modelo.RecetaMedica;

public interface IRecetaMedicaRepository {
	
	public RecetaMedica buscar(Integer id);

	public void insertar(RecetaMedica rece);

	public void actualizar(RecetaMedica rece);

	public void eliminar(Integer id);
}
