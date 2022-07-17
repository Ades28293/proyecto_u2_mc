package com.uce.edu.demo.tarea.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.uce.edu.demo.repository.modelo.Persona;

@Entity
@Table(name= "estudiante")
@NamedNativeQuery(name="Estudiante.buscarPorNombreNative",query="SELECT * FROM estudiante WHERE estu_nombre= :datoNombre",resultClass=Estudiante.class)
@NamedNativeQuery(name="Estudiante.buscarPorApellidoNative",query="SELECT * FROM estudiante WHERE estu_apellido= :datoApellido",resultClass=Estudiante.class)
public class Estudiante {
	@Id //primary key
	@Column(name="estu_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estu_id_seq") // anotacion de secuencia
	@SequenceGenerator(name = "estu_id_seq", sequenceName = "estu_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name="estu_nombre")
	private String nombre;
	
	@Column(name="estu_apellido")
	private String apellido;
	
	@Column(name="estu_edad")
	private Integer  edad;
	
	@Column(name="estu_direccion")
	private String direccion;
	
	@Column(name="estu_estado")
	private String estado;
	
	//Set y get 
	public Integer getId() {
		return id;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
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
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
				+ ", direccion=" + direccion + ", estado=" + estado + "]";
	}
	

	
	
	
	
	
}
