package com.uce.edu.demo.tarea.repository.modelo;

import java.io.Serializable;

public class EstudianteContadorPorEstado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long numero;
	private String estado;

	public EstudianteContadorPorEstado() {

	}

	public EstudianteContadorPorEstado(String estado, Long numero) {
		super();
		this.estado = estado;
		this.numero = numero;

	}

	@Override
	public String toString() {
		return "EstudianteContadorPorEstado [numero=" + numero + ", estado=" + estado + "]";
	}

	// Sets y Gets

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
