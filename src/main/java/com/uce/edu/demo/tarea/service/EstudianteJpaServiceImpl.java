package com.uce.edu.demo.tarea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea.repository.IEstudianteJpaRepository;
import com.uce.edu.demo.tarea.repository.modelo.Estudiante;

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

}
