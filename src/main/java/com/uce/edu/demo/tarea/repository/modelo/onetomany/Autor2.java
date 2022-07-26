package com.uce.edu.demo.tarea.repository.modelo.onetomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "autor2")
public class Autor2 {

	@Id // primary key
	@Column(name = "auto2_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auto2_id_seq") // anotacion de secuencia
	@SequenceGenerator(name = "auto2_id_seq", sequenceName = "auto2_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "auto2_nombre")
	private String nombre;

	@OneToMany(mappedBy = "autor2")
	private List<Libro2Autor2> aurotorLibro;

	// Set y Get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Libro2Autor2> getAurotorLibro() {
		return aurotorLibro;
	}

	public void setAurotorLibro(List<Libro2Autor2> aurotorLibro) {
		this.aurotorLibro = aurotorLibro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

}
