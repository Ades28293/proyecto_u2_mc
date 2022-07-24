package com.uce.edu.demo.tarea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea.repository.IRecetaMedicaRepository;
import com.uce.edu.demo.tarea.repository.modelo.RecetaMedica;

@Service	
public class RecetaMedicaServiceImpl implements IRecetaMedicaService{

	@Autowired
	private IRecetaMedicaRepository iRecetaMedicaRepository;
	
	@Override
	public RecetaMedica buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iRecetaMedicaRepository.buscar(id);
	}

	@Override
	public void insertar(RecetaMedica rece) {
		// TODO Auto-generated method stub
		this.iRecetaMedicaRepository.insertar(rece);
		
	}

	@Override
	public void actualizar(RecetaMedica rece) {
		// TODO Auto-generated method stub
		this.iRecetaMedicaRepository.actualizar(rece);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iRecetaMedicaRepository.eliminar(id);
	}

}
