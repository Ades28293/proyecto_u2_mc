package com.uce.edu.demo.tarea.repository.modelo.onetomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "libro2")
public class Libro2 {
	@Id // primary key
	@Column(name = "libr2_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "libr2_id_seq") // anotacion de secuencia
	@SequenceGenerator(name = "libr2_id_seq", sequenceName = "libr2_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "libr2_titulo")
	private String titulo;

	@Column(name = "libr2_cantidad_paginas")
	private Integer cantidadPaginas;
	
	@OneToMany(mappedBy = "libro2")
	private List<Libro2Autor2> libroAutor;
	
	//Set y get 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getCantidadPaginas() {
		return cantidadPaginas;
	}

	public void setCantidadPaginas(Integer cantidadPaginas) {
		this.cantidadPaginas = cantidadPaginas;
	}

	public List<Libro2Autor2> getLibroAutor() {
		return libroAutor;
	}

	public void setLibroAutor(List<Libro2Autor2> libroAutor) {
		this.libroAutor = libroAutor;
	}

	
	
	
	
	
	
	
}
