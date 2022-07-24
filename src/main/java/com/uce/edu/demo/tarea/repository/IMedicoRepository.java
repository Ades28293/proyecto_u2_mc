package com.uce.edu.demo.tarea.repository;

import com.uce.edu.demo.tarea.repository.modelo.Medico;

public interface IMedicoRepository {

	public Medico buscar(Integer id);

	public void insertar(Medico medi);

	public void actualizar(Medico medi);

	public void eliminar(Integer id);
}
