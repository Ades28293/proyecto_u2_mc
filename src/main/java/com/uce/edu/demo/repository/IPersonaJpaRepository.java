package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Persona;

public interface IPersonaJpaRepository {

	public Persona buscarId(Integer id);

	public void insertar(Persona persona);

	public void actualizar(Persona persona);

	public void eliminar(Integer id);

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
	
	//
	public List<Persona> buscarPorGeneroTyped(String genero);
	public List<Persona> buscarPorGeneroNamed(String genero);
	public List<Persona> buscarPorGeneroTypedNamed(String genero);
	
	
	public Persona buscarPorCedulaApellidoTyped(String cedula,String apellido);
	public Persona buscarPorCedulaApellidoNamed(String cedula,String apellido);
	public Persona buscarPorCedulaApellidoTypedNamed(String cedula,String apellido);
	
	
}
