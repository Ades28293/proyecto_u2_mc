package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.onetomany.Habitacion;

@Repository
@Transactional
public class HabitacionRepositoryImpl implements IHabitacionRepository {

	private static final Logger LOGGER = Logger.getLogger(HabitacionRepositoryImpl.class);
	// Interfaz anotacion paa que se inyecte (Manejador de entidades)
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		LOGGER.info("Se ha insertado la habitacion " + habitacion);

		this.entityManager.persist(habitacion);
	}

}
