package com.uce.edu.demo.tarea.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tarea.repository.modelo.RecetaMedica;

@Repository
@Transactional
public class RecetaMedicaRepositoryImpl implements IRecetaMedicaRepository {
	private static final Logger LOGGER = Logger.getLogger(RecetaMedicaRepositoryImpl.class);
	@Autowired
	private EntityManager entityManager;

	@Override
	public RecetaMedica buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(RecetaMedica.class, id);
	}

	@Override
	public void insertar(RecetaMedica rece) {
		// TODO Auto-generated method stub
		LOGGER.info("Se ha insertado la receta: " + rece);
		this.entityManager.persist(rece);
	}

	@Override
	public void actualizar(RecetaMedica rece) {
		// TODO Auto-generated method stub
		LOGGER.info("Se ha actulizado la receta: " + rece);
		this.entityManager.merge(rece);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		RecetaMedica rece=this.buscar(id);
		LOGGER.info("Se ha eliminado la receta: " + id);
		this.entityManager.remove(id);
	}

}
