package com.uce.edu.demo.cajero.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "Ciudadano2")
@Table(name = "ciudadano2")
public class Ciudadano {
	
	@Id
	@Column(name = "cuid_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cuid_id_seq2") // anotacion de secuencia
	@SequenceGenerator(name = "cuid_id_seq2", sequenceName = "cuid_id_seq2", allocationSize = 1)
	private Integer id;
	
	@Column(name = "cuid_nombre")
	private String nombre;
	
	@Column(name = "cuid_apellido")
	private String apellido;
	
	@OneToOne(mappedBy = "ciudadano")
	private Cliente cliente;

	
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
}
