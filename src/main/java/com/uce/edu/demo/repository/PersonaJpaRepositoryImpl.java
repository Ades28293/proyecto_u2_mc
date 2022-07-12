package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.tarea.repository.EstudianteJpaRepositoryImpl;

@Repository
@Transactional
public class PersonaJpaRepositoryImpl implements IPersonaJpaRepository {
	private static final Logger LOGGER = Logger.getLogger(PersonaJpaRepositoryImpl.class);
	// Interfaz anotacion paa que se inyecte (Manejador de entidades)
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Persona buscarId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Persona.class, id);
	}

	@Override
	public void insertar(Persona persona) {
		// TODO Auto-generated method stub
		LOGGER.info("Se ha insertado el Persona: " + persona);
		this.entityManager.persist(persona);
	}

	@Override
	public void actualizar(Persona persona) {
		// TODO Auto-generated method stub
		LOGGER.info("Se ha actualizado el Persona: " + persona);
		this.entityManager.merge(persona);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Persona persona = this.buscarId(id);
		LOGGER.info("Se ha eliminado el Persona: " + persona);
		this.entityManager.remove(persona);
	}

	@Override
	public Persona buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		// SELECT * FROM persona where pers_cedula='1720757101';
		Query jpqlQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.cedula = :datoCedula");
		jpqlQuery.setParameter("datoCedula", cedula);

		return (Persona) jpqlQuery.getSingleResult();// Este devuelve un objeto generico;
	}

	@Override
	public Persona buscarPorCedulaTyped(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Persona> miTypedQuery = this.entityManager
				.createQuery("SELECT p FROM Persona p WHERE p.cedula = :datoCedula", Persona.class); // MANEJA
																										// GENERICOS(Tipo
																										// de dato)
		miTypedQuery.setParameter("datoCedula", cedula);
		return miTypedQuery.getSingleResult(); // Este devuelve un objeto persona xq le especificamos
	}

	@Override
	public Persona buscarPorCedulaNamed(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedula");// Trabaja con Query
		myQuery.setParameter("datoCedula", cedula);
		return (Persona) myQuery.getSingleResult();
	}

	@Override
	public Persona buscarPorCedulaTypedNamed(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Persona> myQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedula", Persona.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Persona> buscarApellido(String apellido) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.apellido = :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}

	@Override
	public List<Persona> buscarNombreApellido(String nombre, String apellido) {
		// TODO Auto-generated method stub

		TypedQuery<Persona> myQuery = this.entityManager.createNamedQuery("Persona.buscarNombreApellido",
				Persona.class);
		myQuery.setParameter("datoNombre", nombre);
		myQuery.setParameter("datoApellido", apellido);

		return myQuery.getResultList();

	}

	@Override
	public List<Persona> buscarGenero(String genero) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.genero = :datoGenero");
		myQuery.setParameter("datoGenero", genero);

		return myQuery.getResultList();
	}

	@Override
	public List<Persona> buscarNombre(String nombre) {
		Query myQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.nombre = :datoNombre");
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getResultList();
	}

	@Override
	public int actualizarPorApellido(String genero, String apellido) {
		// TODO Auto-generated method stub
		// update persona set pers_genero='F' where pers_apellido='Perez'
		Query myQuery = this.entityManager
				.createQuery("UPDATE Persona p SET p.genero= :datoGenero  WHERE p.apellido= :datoApellido");
		myQuery.setParameter("datoGenero", genero);
		myQuery.setParameter("datoApellido", apellido);

		return myQuery.executeUpdate();
	}

	@Override
	public int eliminarPorGenero(String genero) {
		// TODO Auto-generated method stub
		// delete from persona where pers_genero='Perez'
		Query myQuery = this.entityManager.createQuery("DELETE FROM Persona p WHERE p.genero= :datoGenero");
		myQuery.setParameter("datoGenero", genero);

		return myQuery.executeUpdate();
	}

}
