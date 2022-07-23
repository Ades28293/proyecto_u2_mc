package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.onetomany.Habitacion;
import com.uce.edu.demo.repository.modelo.onetomany.Hotel;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository {

	private static final Logger LOGGER = Logger.getLogger(HotelRepositoryImpl.class);
	// Interfaz anotacion paa que se inyecte (Manejador de entidades)
	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private HabitacionRepositoryImpl habitacionRepositoryImpl;

	@Override
	public void insertar(Hotel hotel) {
		// TODO Auto-generated method stub
		LOGGER.info("Se ha insertado el Hotel: " + hotel);

		List<Habitacion> habitaciones = hotel.getHabitaciones();
		this.entityManager.persist(hotel);

		/*
		  // Buscar El Hotel
		  String numero = hotel.getNombre(); Hotel hotelBuscado = null; for (Habitacion
		  habiItem : habitaciones) { //calculos habiItem.setHotel(hotelBuscado);
		  this.habitacionRepositoryImpl.insertar(habiItem); }
		 */
	}
}
