package com.uce.edu.demo.correcion.repository.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name= "propietario")
public class Propietario {
	
	@Id //primary key
	@Column(name="prop_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "prop_id_seq")//anotacion de secuencia
	@SequenceGenerator(name="prop_id_seq",sequenceName="prop_id_seq",allocationSize = 1)
	private Integer id;
	
	@Column(name="prop_nombre")
	private String nombre;
	
	@Column(name="prop_apellido")
	private String apellido;
	
	@Column(name="prop_cedula")
	private String cedula;
	
	@Column(name="prop_fecha")
	private LocalDateTime fecha;
	
	//Set y GET
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
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	@Override
	public String toString() {
		return "Propietario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula
				+ ", fecha=" + fecha + "]";
	}
	
	
	
	
	
}
