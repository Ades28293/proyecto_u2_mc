package com.uce.edu.demo.tarea.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tarea.repository.modelo.Medico;

@Repository
@Transactional
public class MedicoRepositoryImpl implements IMedicoRepository {
	private static final Logger LOGGER = Logger.getLogger(MedicoRepositoryImpl.class);

	@Autowired
	private EntityManager entityManager;

	@Override
	public Medico buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Medico.class, id);
	}

	@Override
	public void insertar(Medico medi) {
		// TODO Auto-generated method stub
		LOGGER.info("Se ha insertado el Medico: " + medi);
		this.entityManager.persist(medi);

	}

	@Override
	public void actualizar(Medico medi) {
		// TODO Auto-generated method stub
		LOGGER.info("Se ha actualizado el Medico: " + medi);
		this.entityManager.merge(medi);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Medico medi = this.buscar(id);
		LOGGER.info("Se ha eliminado el Medico: " + medi);
		this.entityManager.remove(medi);
	}

}
