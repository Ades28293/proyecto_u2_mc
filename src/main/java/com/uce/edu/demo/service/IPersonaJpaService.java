package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Persona;

public interface IPersonaJpaService {

	public void guardar(Persona persona);

	public void actualizar(Persona persona);

	public void eliminar(int id);

	public Persona buscar(int id);

	public Persona buscarPorCedula(String cedula);

	public List<Persona> buscarApellido(String apellido);

	public List<Persona> buscarGenero(String genero);

	public List<Persona> buscarNombre(String nombre);

	public int actualizarPorApellido(String genero, String apellido);

	public int eliminarPorGenero(String genero);

   /////////Typed
	public Persona buscarPorCedulaTyped(String cedula);
	public Persona buscarPorCedulaNamed(String cedula);
	public Persona buscarPorCedulaTypedNamed(String cedula);
	
	public List<Persona> buscarNombreApellido(String nombre,String apellido);
}
