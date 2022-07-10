package com.uce.edu.demo.correcion.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.correcion.repository.modelo.Propietario;

@Repository
@Transactional
public class PropietarioRepositoryImpl implements IPropietarioRepository {
	private static final Logger LOGGER = Logger.getLogger(PropietarioRepositoryImpl.class);
	// Interfaz anotacion paa que se inyecte (Manejador de entidades)
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void crear(Propietario propietario) {
		// TODO Auto-generated method stub
		LOGGER.info("Se ha insertado el propietario: " + propietario);
		this.entityManager.persist(propietario);
	}

	@Override
	public int eliminar(String cedula) {
		// TODO Auto-generated method stub
		LOGGER.info("Se elimina el propietario: " + cedula);

		Query myQuery = this.entityManager.createQuery("DELETE FROM Propietario p WHERE p.cedula= :datoCedula");
		myQuery.setParameter("datoCedula", cedula);

		return myQuery.executeUpdate();
	}

	@Override
	public Propietario consultar(String cedula) {
		// TODO Auto-generated method stub
		Query jpqlQuery = this.entityManager.createQuery("SELECT p FROM Propietario p WHERE p.cedula = :datoCedula");
		jpqlQuery.setParameter("datoCedula", cedula);

		return (Propietario) jpqlQuery.getSingleResult();// Este devuelve un objeto de tipo persona;
	
	}

}
