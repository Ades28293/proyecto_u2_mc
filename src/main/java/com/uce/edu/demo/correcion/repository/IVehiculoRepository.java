package com.uce.edu.demo.correcion.repository;

import com.uce.edu.demo.correcion.repository.modelo.Vehiculo;

public interface IVehiculoRepository {

	public void insertar(Vehiculo vehiculo);

	public void actualizar(Vehiculo vehiculo);

	public int eliminar(String placa);

	public Vehiculo buscar(String placa);

}
