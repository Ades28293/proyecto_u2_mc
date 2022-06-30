package com.uce.edu.demo.tarea.repository;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tarea.to.EstudianteTo;

@Repository
public class EstudianteJdbcRepositoryImpl implements IEstudianteJdbcRepository{
	
	private static final Logger LOGGER = Logger.getLogger(EstudianteJdbcRepositoryImpl.class);

	//Inyeccion jdbc
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public EstudianteTo buscar(int id) {
		// TODO Auto-generated method stub
		LOGGER.info("Se ha buscado por id: "+id);
		
		return this.jdbcTemplate.queryForObject("select * from estudiante where id=?", new Object[] {id},
				new BeanPropertyRowMapper<EstudianteTo>(EstudianteTo.class));
	}

	@Override
	public void insertar(EstudianteTo e) {
		// TODO Auto-generated method stub
		LOGGER.info("Se ha insertado el estudiante: "+e);
		this.jdbcTemplate.update("insert into estudiante (id,nombre,apellido,edad,direccion) values (?,?,?,?,?)",
				new Object[] { e.getId(),e.getNombre(),e.getApellido(),e.getEdad(),e.getDireccion()});
		
	}

	@Override
	public void actualizar(EstudianteTo e) {
		// TODO Auto-generated method stub
		LOGGER.info("Se ha actualizado el estudiante: "+e);
		this.jdbcTemplate.update("update estudiante set nombre=?,apellido=?,edad=?,direccion=? where id=?",
				new Object[] { e.getNombre(),e.getApellido(),e.getEdad(),e.getDireccion(),e.getId()});
		
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		LOGGER.info("Se ha eliminado por id: "+id);
		this.jdbcTemplate.update("delete from estudiante where id=?",new Object[] {id});
		
	}

}
