package com.uce.edu.demo.tarea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea.repository.ICiudadanoRepository;
import com.uce.edu.demo.tarea.repository.modelo.CiudadanoDeber;

@Service
public class CiudadanoServiceImpl implements ICiudadanoService{
	@Autowired
	private ICiudadanoRepository ciudadanoRepository;

	@Override
	public CiudadanoDeber buscarId(Integer id) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.buscarId(id);
	}

	@Override
	public void insertar(CiudadanoDeber ciudadano) {
		// TODO Auto-generated method stub
		this.ciudadanoRepository.insertar(ciudadano);
	}

	@Override
	public void actualizar(CiudadanoDeber ciudadano) {
		// TODO Auto-generated method stub
		this.ciudadanoRepository.actualizar(ciudadano);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.ciudadanoRepository.eliminar(id);
		
	}

}
