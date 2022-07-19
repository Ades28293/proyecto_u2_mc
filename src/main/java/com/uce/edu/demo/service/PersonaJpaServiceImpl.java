package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPersonaJpaRepository;
import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;

@Service
public class PersonaJpaServiceImpl implements IPersonaJpaService {
	@Autowired
	private IPersonaJpaRepository iPersonaJpaRepository;

	@Override
	public void guardar(Persona persona) {
		// TODO Auto-generated method stub
		this.iPersonaJpaRepository.insertar(persona);
	}

	@Override
	public void actualizar(Persona persona) {
		// TODO Auto-generated method stub
		this.iPersonaJpaRepository.actualizar(persona);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		this.iPersonaJpaRepository.eliminar(id);
	}

	@Override
	public Persona buscar(int id) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarId(id);
	}

	@Override
	public Persona buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorCedula(cedula);
	}

	@Override
	public Persona buscarPorCedulaTyped(String cedula) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorCedulaTyped(cedula);
	}

	@Override
	public Persona buscarPorCedulaNamed(String cedula) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorCedulaNamed(cedula);
	}

	@Override
	public Persona buscarPorCedulaTypedNamed(String cedula) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorCedulaTypedNamed(cedula);
	}
	
	@Override
	public Persona buscarPorCedulaNative(String cedula) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorCedulaNative(cedula);
	}
	
	@Override
	public Persona buscarPorCedulaNamedNative(String cedula) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorCedulaNamedNative(cedula);
	}
	
	@Override
	public Persona buscarPorCedulaCriteriaApi(String cedula) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorCedulaCriteriaApi(cedula);
	}
	
	@Override
	public List<Persona> buscarDinamicamente(String nombre, String apellido, String genero) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarDinamicamente(nombre, apellido, genero);
	}

	

	@Override
	public List<Persona> buscarApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarApellido(apellido);
	}
	
	@Override
	public List<PersonaSencilla> buscarApellidoSencillo(String apellido) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarApellidoSencillo(apellido);
	}
	
	@Override
	public List<PersonaContadorGenero> consultarCantidadPorGenero() {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.consultarCantidadPorGenero();
	}

	@Override
	public List<Persona> buscarNombreApellido(String nombre, String apellido) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarNombreApellido(nombre, apellido);
	}

	@Override
	public List<Persona> buscarGenero(String genero) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarGenero(genero);
	}
	
	@Override
	public List<Persona> buscarPorGeneroTyped(String genero) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorGeneroTyped(genero);
	}

	@Override
	public List<Persona> buscarPorGeneroNamed(String genero) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorGeneroNamed(genero);
	}

	@Override
	public List<Persona> buscarPorGeneroTypedNamed(String genero) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorGeneroTypedNamed(genero);
	}
	

	@Override
	public List<Persona> buscarNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarNombre(nombre);
	}

	@Override
	public int actualizarPorApellido(String genero, String apellido) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.actualizarPorApellido(genero, apellido);
	}

	@Override
	public int eliminarPorGenero(String genero) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.eliminarPorGenero(genero);
	}

	@Override
	public Persona buscarPorCedulaApellidoTyped(String cedula, String apellido) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorCedulaApellidoTyped(cedula, apellido);
	}

	@Override
	public Persona buscarPorCedulaApellidoNamed(String cedula, String apellido) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorCedulaApellidoNamed(cedula, apellido);
	}

	@Override
	public Persona buscarPorCedulaApellidoTypedNamed(String cedula, String apellido) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorCedulaApellidoTypedNamed(cedula, apellido);
	}

	

	



	


	

	

}
