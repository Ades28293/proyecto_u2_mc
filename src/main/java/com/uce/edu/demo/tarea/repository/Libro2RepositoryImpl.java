package com.uce.edu.demo.tarea.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tarea.repository.modelo.onetomany.Libro2;

@Repository
@Transactional
public class Libro2RepositoryImpl implements ILibro2Repository{

	// Interfaz anotacion paa que se inyecte (Manejador de entidades)
		@PersistenceContext
		private EntityManager entityManager;

		@Override
		public void insertar(Libro2 libro2) {
			// TODO Auto-generated method stub
			this.entityManager.persist(libro2);
		}
		
}
