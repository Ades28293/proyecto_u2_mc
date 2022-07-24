package com.uce.edu.demo.tarea.repository.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="medico")
public class Medico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medi_id_seq") // anotacion de secuencia
	@SequenceGenerator(name = "medi_id_seq", sequenceName = "medi_id_seq", allocationSize = 1)
	@Column(name="medi_id")
	private Integer id;
	
	@Column(name="medi_nombre")
	private String nombre;
	
	@Column(name="medi_apellido")
	private String apellido;

	@OneToMany(mappedBy = "medico")
	private List<RecetaMedica> recetas;
	
	//Set y Get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public List<RecetaMedica> getRecetas() {
		return recetas;
	}

	public void setRecetas(List<RecetaMedica> recetas) {
		this.recetas = recetas;
	}
	
	

}
