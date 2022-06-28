package com.uce.edu.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.to.Estudiante;

@Repository
public class EstudianteJdbcRepositoryImpl implements IEstudianteJdbcRepository{

	//Inyeccion jdbc
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public Estudiante buscar(int id) {
		// TODO Auto-generated method stub
		return this.jdbcTemplate.queryForObject("select * from estudiante where id=?", new Object[] {id},
				new BeanPropertyRowMapper<Estudiante>(Estudiante.class));
	}

	@Override
	public void insertar(Estudiante e) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("insert into estudiante (id,nombre,apellido,edad,direccion) values (?,?,?,?,?)",
				new Object[] { e.getId(),e.getNombre(),e.getApellido(),e.getEdad(),e.getDireccion()});
		
	}

	@Override
	public void actualizar(Estudiante e) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("update estudiante set nombre=?,apellido=?,edad=?,direccion=? where id=?",
				new Object[] { e.getNombre(),e.getApellido(),e.getEdad(),e.getDireccion(),e.getId()});
		
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("delete from estudiante where id=?",new Object[] {id});
		
	}

}
