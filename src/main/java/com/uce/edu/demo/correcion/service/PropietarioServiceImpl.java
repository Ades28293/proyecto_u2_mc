package com.uce.edu.demo.correcion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.correcion.repository.IPropietarioRepository;
import com.uce.edu.demo.correcion.repository.modelo.Propietario;
@Service
public class PropietarioServiceImpl implements IPropietarioService{
	
	@Autowired
	private IPropietarioRepository iPropietarioRepository;

	@Override
	public void crear(Propietario propietario) {
		// TODO Auto-generated method stub
		this.iPropietarioRepository.crear(propietario);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		this.iPropietarioRepository.eliminar(cedula);
	}

}
