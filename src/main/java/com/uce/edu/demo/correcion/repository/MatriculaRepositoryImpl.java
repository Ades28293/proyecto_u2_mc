package com.uce.edu.demo.correcion.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.correcion.repository.modelo.Matricula;
import com.uce.edu.demo.repository.PersonaJpaRepositoryImpl;

//@Repository
//@Transactional
public class MatriculaRepositoryImpl implements IMatriculaRepository{
	/*private static final Logger LOGGER = Logger.getLogger(MatriculaRepositoryImpl.class);

	// Interfaz anotacion paa que se inyecte (Manejador de entidades)
		@PersistenceContext
		private EntityManager entityManager;
	
	@Override
	public void crear(Matricula ma) {
		// TODO Auto-generated method stub
		LOGGER.info("Se crea la matricula: "+ma);
		this.entityManager.persist(ma);
		
	}
*/
}
