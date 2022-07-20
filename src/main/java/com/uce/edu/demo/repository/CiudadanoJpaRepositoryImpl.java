package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Ciudadano;
@Repository
@Transactional
public class CiudadanoJpaRepositoryImpl implements ICiudadanoJpaRepository{
	
	private static final Logger LOGGER = Logger.getLogger(PersonaJpaRepositoryImpl.class);
	// Interfaz anotacion paa que se inyecte (Manejador de entidades)
	@PersistenceContext
	private EntityManager entityManager;
	

	@Override
	public void insertar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		LOGGER.info("Se ha insertado el Ciudadano: " + ciudadano);
		this.entityManager.persist(ciudadano);
		
	}

}
