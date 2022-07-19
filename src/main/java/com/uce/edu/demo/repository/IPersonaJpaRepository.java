package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;

public interface IPersonaJpaRepository {

	public Persona buscarId(Integer id);

	public void insertar(Persona persona);

	public void actualizar(Persona persona);

	public void eliminar(Integer id);

	public Persona buscarPorCedula(String cedula);

	public List<Persona> buscarApellido(String apellido);
	
	public List<PersonaSencilla> buscarApellidoSencillo(String apellido);

	public List<Persona> buscarGenero(String genero);

	public List<Persona> buscarNombre(String nombre);

	public int actualizarPorApellido(String genero, String apellido);

	public int eliminarPorGenero(String genero);

	/////////Typed
	public Persona buscarPorCedulaTyped(String cedula);
	public Persona buscarPorCedulaNamed(String cedula);
	public Persona buscarPorCedulaTypedNamed(String cedula);
	public Persona buscarPorCedulaNative(String cedula);
	public Persona buscarPorCedulaNamedNative(String cedula);
	public Persona buscarPorCedulaCriteriaApi(String cedula);
	public List<Persona> buscarDinamicamente(String nombre,String apellido,String genero);
	
	public List<Persona> buscarNombreApellido(String nombre,String apellido);
	
	//
	public List<Persona> buscarPorGeneroTyped(String genero);
	public List<Persona> buscarPorGeneroNamed(String genero);
	public List<Persona> buscarPorGeneroTypedNamed(String genero);
	
	
	
	public Persona buscarPorCedulaApellidoTyped(String cedula,String apellido);
	public Persona buscarPorCedulaApellidoNamed(String cedula,String apellido);
	public Persona buscarPorCedulaApellidoTypedNamed(String cedula,String apellido);

	public List<Persona> buscarDinamicamentePredicados(String nombre, String apellido, String genero);
	
	public List<PersonaContadorGenero> consultarCantidadPorGenero();
	
	
}
