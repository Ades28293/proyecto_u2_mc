package com.uce.edu.demo.tarea.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.PersonaJpaRepositoryImpl;
import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.tarea.repository.modelo.CiudadanoDeber;
@Repository
@Transactional
public class CiudadanoRepositoryImpl implements ICiudadanoRepository{
	private static final Logger LOGGER = Logger.getLogger(PersonaJpaRepositoryImpl.class);
	// Interfaz anotacion paa que se inyecte (Manejador de entidades)
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public CiudadanoDeber buscarId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(CiudadanoDeber.class, id);
	}

	@Override
	public void insertar(CiudadanoDeber ciudadano) {
		// TODO Auto-generated method stub
		LOGGER.info("Se ha insertado el Persona: " + ciudadano);
		this.entityManager.persist(ciudadano);
	}

	@Override
	public void actualizar(CiudadanoDeber ciudadano) {
		// TODO Auto-generated method stub
		LOGGER.info("Se ha actualizado el Persona: " + ciudadano);
		this.entityManager.merge(ciudadano);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		CiudadanoDeber ciudadano = this.buscarId(id);
		LOGGER.info("Se ha eliminado el Persona: " + ciudadano);
		this.entityManager.remove(ciudadano);
	}


}
