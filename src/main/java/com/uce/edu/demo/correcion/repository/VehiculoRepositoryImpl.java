package com.uce.edu.demo.correcion.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.correcion.repository.modelo.Vehiculo;
@Repository
@Transactional
public class VehiculoRepositoryImpl implements IVehiculoRepository{
	private static final Logger LOGGER = Logger.getLogger(VehiculoRepositoryImpl.class);
	// Interfaz anotacion paa que se inyecte (Manejador de entidades)
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		LOGGER.info("Se inserta el vehiculo: "+vehiculo);
		this.entityManager.persist(vehiculo);
		
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		LOGGER.info("Se actualiza el vehiculo: "+vehiculo);
		this.entityManager.merge(vehiculo);
	}

	@Override
	public int eliminar(String placa) {
		// TODO Auto-generated method stub
		LOGGER.info("Se elimina el vehiculo: " + placa);

		Query myQuery = this.entityManager.createQuery("DELETE FROM Vehiculo v WHERE v.placa= :datoPlaca");
		myQuery.setParameter("datoPlaca", placa);

		return myQuery.executeUpdate();
	}

	@Override
	public Vehiculo buscar(String placa) {
		// TODO Auto-generated method stub
		LOGGER.info("Se busca el vehiculo: " + placa);
		
		Query jpqlQuery = this.entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.placa = :datoPlaca");
		jpqlQuery.setParameter("datoPlaca", placa);

		return (Vehiculo) jpqlQuery.getSingleResult();// Este devuelve un objeto de tipo persona;
		
	}

}
