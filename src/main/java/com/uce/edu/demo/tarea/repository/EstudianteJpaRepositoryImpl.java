package com.uce.edu.demo.tarea.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.ProyectoU2McApplication;
import com.uce.edu.demo.tarea.repository.modelo.Estudiante;


@Repository
@Transactional
public class EstudianteJpaRepositoryImpl implements IEstudianteJpaRepository{
	private static final Logger LOGGER = Logger.getLogger(EstudianteJpaRepositoryImpl.class);
	
	//Interfaz anotacion paa que se inyecte (Manejador de entidades)
		@PersistenceContext
		private EntityManager entityManager;

		@Override
		public Estudiante buscar(Integer id) {
			// TODO Auto-generated method stub
			return this.entityManager.find(Estudiante.class, id);
		}

		@Override
		public void insertar(Estudiante e) {
			// TODO Auto-generated method stub
			LOGGER.info("Se ha insertado el Estudiante: "+e);
			this.entityManager.persist(e);
			
		}

		@Override
		public void actualizar(Estudiante e) {
			// TODO Auto-generated method stub
			LOGGER.info("Se ha actualizado el Estudiante: "+e);
			this.entityManager.merge(e);
		}

		@Override
		public void eliminar(Integer id) {
			// TODO Auto-generated method stub
			Estudiante e=this.buscar(id);
			LOGGER.info("Se ha eliminado el Estudiante: "+e);
			this.entityManager.remove(e);
		}
	

	
}
