package com.uce.edu.demo.correcion.repository.modelo;

import java.math.BigDecimal;
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
@Table(name = "vehiculo")
public class Vehiculo {
	@Id // primary key
	@Column(name = "vehi_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehi_id_seq") // anotacion de secuencia
	@SequenceGenerator(name = "vehi_id_seq", sequenceName = "vehi_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "vehi_marca")
	private String marca;

	@Column(name = "vehi_placa")
	private String placa;

	@Column(name = "vehi_tipo")
	private String tipo;

	@Column(name = "vehi_precio")
	private BigDecimal precio;

	@OneToMany(mappedBy = "vehiculo")
	private List<Matricula> matriculas;

}
