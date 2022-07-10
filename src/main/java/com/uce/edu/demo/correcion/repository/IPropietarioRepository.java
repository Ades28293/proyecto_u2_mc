package com.uce.edu.demo.correcion.repository;

import com.uce.edu.demo.correcion.repository.modelo.Propietario;

public interface IPropietarioRepository {

	public void crear(Propietario propietario);
	public int eliminar(String cedula);
	public Propietario consultar(String cedula);
}
