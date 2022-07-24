package com.uce.edu.demo.tarea.repository.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="receta")
public class RecetaMedica {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rece_id_seq") // anotacion de secuencia
	@SequenceGenerator(name = "rece_id_seq", sequenceName = "rece_id_seq", allocationSize = 1)
	@Column(name="rece_id")
	private String id;
	
	@Column(name="rece_fecha")
	private LocalDateTime fecha;
	
	@Column(name="rece_prescripcion")
	private String prescripcion;

	@ManyToOne
	@JoinColumn(name = "rece_id_medico")
	private Medico medico;
	
	
	//Set y get
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getPrescripcion() {
		return prescripcion;
	}

	public void setPrescripcion(String prescripcion) {
		this.prescripcion = prescripcion;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	
	
	
	

}
