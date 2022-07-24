package com.uce.edu.demo.tarea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea.repository.IMedicoRepository;
import com.uce.edu.demo.tarea.repository.modelo.Medico;

@Service
public class MedicoServiceImpl implements IMedicoService {

	@Autowired
	private IMedicoRepository iMedicoRepository;

	@Override
	public Medico buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iMedicoRepository.buscar(id);
	}

	@Override
	public void insertar(Medico medi) {
		// TODO Auto-generated method stub
		this.iMedicoRepository.insertar(medi);
	}

	@Override
	public void actualizar(Medico medi) {
		// TODO Auto-generated method stub
		this.iMedicoRepository.actualizar(medi);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iMedicoRepository.eliminar(id);
	}

}
