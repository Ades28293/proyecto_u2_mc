package com.uce.edu.demo.tarea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea.repository.IAutor2Repository;
import com.uce.edu.demo.tarea.repository.modelo.onetomany.Autor2;

@Service
public class Autor2ServiceImpl implements IAutor2Service{

	@Autowired
	private IAutor2Repository autor2Repository;
	
	@Override
	public void insertar(Autor2 autor2) {
		// TODO Auto-generated method stub
		this.autor2Repository.insertar(autor2);
	}

}
