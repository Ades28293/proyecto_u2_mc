package com.uce.edu.demo.tarea.repository.modelo;

import java.io.Serializable;

public class EstudianteSencillo implements  Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String apellido;
	private String estado;
	
	public EstudianteSencillo() {
		
	}
	
	
	public EstudianteSencillo(String nombre, String apellido, String estado) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "EstudianteSencillo [nombre=" + nombre + ", apellido=" + apellido + ", estado=" + estado + "]";
	}
	
	//Get y Set

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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
