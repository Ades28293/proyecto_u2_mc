package com.uce.edu.demo.tarea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea.repository.ILibro2Autor2Repository;
import com.uce.edu.demo.tarea.repository.modelo.onetomany.Libro2Autor2;

@Service
public class Libro2Autor2ServiceImpl implements ILibro2Autor2Service{
	
	@Autowired
	private ILibro2Autor2Repository autor2Repository;
	@Override
	public void insertar(Libro2Autor2 libro2Autor2) {
		// TODO Auto-generated method stub
		this.autor2Repository.insertar(libro2Autor2);
	}

}
