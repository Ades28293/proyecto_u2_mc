package com.uce.edu.demo.correcion.service;

import com.uce.edu.demo.correcion.repository.modelo.Vehiculo;

public interface IVehiculoService {
	public void insertar(Vehiculo vehiculo);

	public void actualizar(Vehiculo vehiculo);

	public void eliminar(String placa);

	public Vehiculo buscar(String placa);
}
