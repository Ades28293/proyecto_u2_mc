package com.uce.edu.demo.correcion.service;

import com.uce.edu.demo.correcion.repository.modelo.Propietario;

public interface IPropietarioService {
	public void crear(Propietario propietario);
	public void eliminar(String cedula);
	
	
}
