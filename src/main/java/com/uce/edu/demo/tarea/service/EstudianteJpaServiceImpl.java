package com.uce.edu.demo.tarea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPersonaJpaRepository;
import com.uce.edu.demo.tarea.repository.IEstudianteJpaRepository;
import com.uce.edu.demo.tarea.repository.modelo.Estudiante;
import com.uce.edu.demo.tarea.repository.modelo.EstudianteContadorPorEstado;
import com.uce.edu.demo.tarea.repository.modelo.EstudianteSencillo;

@Service
public class EstudianteJpaServiceImpl implements IEstudianteJpaService{
	@Autowired
	private IEstudianteJpaRepository iEstudianteJpaRepository;

	
	@Override
	public Estudiante buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscar(id);
	}

	@Override
	public void insertar(Estudiante e) {
		// TODO Auto-generated method stub
		this.iEstudianteJpaRepository.insertar(e);
	}

	@Override
	public void actualizar(Estudiante e) {
		// TODO Auto-generated method stub
		this.iEstudianteJpaRepository.actualizar(e);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iEstudianteJpaRepository.eliminar(id);
	}

	@Override
	public List<Estudiante> buscarPorNombreNative(String nombre) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorNombreNamedNative(nombre);
	}

	@Override
	public List<Estudiante> buscarPorNombreNamedNative(String nombre) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorNombreNamedNative(nombre);
	}

	@Override
	public List<Estudiante> buscarPorApellidoNative(String apellido) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorApellidoNamedNative(apellido);
	}

	@Override
	public List<Estudiante> buscarPorApellidoNamedNative(String apellido) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorApellidoNamedNative(apellido);
	}

	@Override
	public List<Estudiante> buscarPorNombreApellidoCriteriaApi(String nombre, String apellido) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorNombreApellidoCriteriaApi(nombre, apellido);
	}

	@Override
	public List<Estudiante> buscarDinamicamentePredicados(String nombre, String apellido, String estado) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarDinamicamentePredicados(nombre, apellido, estado);
	}

	@Override
	public List<EstudianteSencillo> buscarApellidoEstado( String estado) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarApellidoEstado( estado);
	}

	@Override
	public List<EstudianteContadorPorEstado> buscarContadorPorEstado() {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarContadorPorEstado();
	}

}
