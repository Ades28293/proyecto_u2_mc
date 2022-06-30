package com.uce.edu.demo.tarea.to;

public class EstudianteTo {
	private int id;
	private String nombre;
	private String apellido;
	private int edad;
	private String direccion;
	
	public EstudianteTo() {
		
	}
	
	
	public EstudianteTo(int id, String nombre, String apellido, int edad, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.direccion = direccion;
	}




	//Set y Get
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
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
				+ ", direccion=" + direccion + "]";
	}
	

	
	
	

}
