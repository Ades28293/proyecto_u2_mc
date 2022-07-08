package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.tarea.repository.EstudianteJpaRepositoryImpl;

@Repository
@Transactional
public class PersonaJpaRepositoryImpl implements IPersonaJpaRepository{
	private static final Logger LOGGER = Logger.getLogger(PersonaJpaRepositoryImpl.class);
	//Interfaz anotacion paa que se inyecte (Manejador de entidades)
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
		LOGGER.info("Se ha insertado el Persona: "+persona);
	 this.entityManager.persist(persona);
	}

	@Override
	public void actualizar(Persona persona) {
		// TODO Auto-generated method stub
		LOGGER.info("Se ha actualizado el Persona: "+persona);
		this.entityManager.merge(persona);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Persona persona=this.buscarId(id);
		LOGGER.info("Se ha eliminado el Persona: "+persona);
		this.entityManager.remove(persona);
	}

	@Override
	public Persona buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		//SELECT * FROM persona where pers_cedula='1720757101';
		Query jpqlQuery=this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.cedula = :datoCedula");
		jpqlQuery.setParameter("datoCedula", cedula);
		
		return (Persona)jpqlQuery.getSingleResult();//Este devuelve un objeto de tipo persona;
	}

	@Override
	public List<Persona> buscarApellido(String apellido) {
		// TODO Auto-generated method stub
		Query myQuery=this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.apellido = :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}

	@Override
	public List<Persona> buscarGenero(String genero) {
		// TODO Auto-generated method stub
		Query myQuery=this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.genero = :datoGenero");
		myQuery.setParameter("datoGenero", genero);
		
		return  myQuery.getResultList();
	}

	@Override
	public List<Persona> buscarNombre(String nombre) {
		Query myQuery=this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.nombre = :datoNombre");
		myQuery.setParameter("datoNombre", nombre);
		return  myQuery.getResultList();
	}

	

}
