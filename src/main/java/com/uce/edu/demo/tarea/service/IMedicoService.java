package com.uce.edu.demo.tarea.service;

import com.uce.edu.demo.tarea.repository.modelo.Medico;

public interface IMedicoService {

	public Medico buscar(Integer id);

	public void insertar(Medico medi);

	public void actualizar(Medico medi);

	public void eliminar(Integer id);
}
