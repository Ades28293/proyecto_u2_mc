package com.uce.edu.demo.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.to.Persona;

@Repository
public class PersonaJdbcRepositoryImpl implements IPersonaJdbcRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonaJdbcRepositoryImpl.class);

	// Inyeccion jdbc
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	@Override
	public Persona buscarId(int id) {
		// TODO Auto-generated method stub
		LOGGER.info("Se busco el usuario:"+ id);
		return this.jdbcTemplate.queryForObject("select * from persona WHERE id=?", new Object[] { id },
				new BeanPropertyRowMapper<Persona>(Persona.class));
	}
	@Override
	public void insertar(Persona persona) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("insert into persona (id,nombre,apellido) values (?,?,?)",
				new Object[] { persona.getId(), persona.getNombre(), persona.getApellido() });

	}

	@Override
	public void actualizar(Persona persona) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("update persona set nombre=?,apellido=? where id=?",
				new Object[] { persona.getNombre(), persona.getApellido(), persona.getId() });

	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		LOGGER.info("Se elimine el usuario:"+ id);
		this.jdbcTemplate.update("delete from persona where id=?", new Object[] { id });
	}
}
