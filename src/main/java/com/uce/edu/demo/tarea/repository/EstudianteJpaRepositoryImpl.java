package com.uce.edu.demo.tarea.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.ProyectoU2McApplication;
import com.uce.edu.demo.repository.modelo.Persona;
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

		@Override
		public List<Estudiante> buscarPorNombreNative(String nombre) {
			// TODO Auto-generated method stub
			// SQL PURO
			Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM estudiante WHERE estu_nombre= :datoNombre",
					Estudiante.class);
			myQuery.setParameter("datoNombre", nombre);

			return (List<Estudiante>) myQuery.getResultList();
			
			
		}

		@Override
		public List<Estudiante> buscarPorNombreNamedNative(String nombre) {
			// TODO Auto-generated method stub
			TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorNombreNative",
					Estudiante.class);
			myQuery.setParameter("datoNombre", nombre);
			return myQuery.getResultList();
		}

		@Override
		public List<Estudiante> buscarPorApellidoNative(String apellido) {
			Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM estudiante WHERE estu_apellido= :datoApellido",
					Estudiante.class);
			myQuery.setParameter("datoApellido", apellido);

			return (List<Estudiante>) myQuery.getResultList();
		}

		@Override
		public List<Estudiante> buscarPorApellidoNamedNative(String apellido) {
			TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorApellidoNative",
					Estudiante.class);
			myQuery.setParameter("datoApellido", apellido);
			return myQuery.getResultList();
		}

		@Override
		public List<Estudiante> buscarPorNombreApellidoCriteriaApi(String nombre, String apellido) {
			// TODO Auto-generated method stub
			CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
			
			CriteriaQuery<Estudiante> myQuery = myCriteria.createQuery(Estudiante.class);
			
			Root<Estudiante> personaRoot = myQuery.from(Estudiante.class);
			
			Predicate predicadoNombre = myCriteria.equal(personaRoot.get("nombre"), nombre);
			Predicate predicadoApellido = myCriteria.equal(personaRoot.get("apellido"), apellido);
			
			Predicate miPredicadoFinal= myCriteria.and(predicadoNombre,predicadoApellido);
			myQuery.select(personaRoot).where(miPredicadoFinal);
			
			TypedQuery<Estudiante> myQueryFinal = this.entityManager.createQuery(myQuery);
			
			return myQueryFinal.getResultList();
		}

		@Override
		public List<Estudiante> buscarDinamicamentePredicados(String nombre, String apellido, String estado) {
			// TODO Auto-generated method stub
			CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();

			CriteriaQuery<Estudiante> myQuery = myCriteria.createQuery(Estudiante.class);

			Root<Estudiante> myTabla = myQuery.from(Estudiante.class);

			Predicate predicadoNombre = myCriteria.equal(myTabla.get("nombre"), nombre);

			Predicate predicadoApellido = myCriteria.equal(myTabla.get("apellido"), apellido);

			Predicate predicadoEstado  = myCriteria.equal(myTabla.get("estado"), estado);

			Predicate miPerdicadoFinal = null;

			if (estado.equals("A")) {
				miPerdicadoFinal = myCriteria.and(predicadoNombre, predicadoApellido);
				miPerdicadoFinal =myCriteria.and(miPerdicadoFinal,predicadoEstado);
				
			} else {
				miPerdicadoFinal = myCriteria.and(predicadoNombre, predicadoApellido);
				miPerdicadoFinal =myCriteria.or(miPerdicadoFinal,predicadoEstado);
			}

			myQuery.select(myTabla).where(miPerdicadoFinal);

			TypedQuery<Estudiante> myQueryFinal = this.entityManager.createQuery(myQuery);

			return myQueryFinal.getResultList();
		}
	

	
}
