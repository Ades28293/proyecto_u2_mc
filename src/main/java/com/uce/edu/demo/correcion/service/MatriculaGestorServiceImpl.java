package com.uce.edu.demo.correcion.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.correcion.repository.IMatriculaRepository;
import com.uce.edu.demo.correcion.repository.IPropietarioRepository;
import com.uce.edu.demo.correcion.repository.IVehiculoRepository;
import com.uce.edu.demo.correcion.repository.modelo.Matricula;
import com.uce.edu.demo.correcion.repository.modelo.Propietario;
import com.uce.edu.demo.correcion.repository.modelo.Vehiculo;

@Service
public class MatriculaGestorServiceImpl implements IMatriculaGestorService{
/*	
	@Autowired
	private IPropietarioRepository iPropietarioRepository;
	@Autowired
	private IVehiculoRepository iVehiculoRepository;
	
	@Autowired
	@Qualifier("pesado")
	private IMatriculaService matriculaServicePesado;
	
	
	@Autowired
	@Qualifier("liviano")
	private IMatriculaService matriculaServiceLiviano;
	
	@Autowired
	private IMatriculaRepository iMatriculaRepository;
	
	
	@Override
	public void generar(String cedula, String placa) {
		// TODO Auto-generated method stub
		Propietario pro=this.iPropietarioRepository.consultar(cedula);
		Vehiculo v=this.iVehiculoRepository.buscar(placa);
		String tipo=v.getTipo();
		BigDecimal valorMatricula;
			if(tipo.equals("P")) {
				valorMatricula=this.matriculaServicePesado.calcular(v.getPrecio());
			}
			else {
				valorMatricula=this.matriculaServiceLiviano.calcular(v.getPrecio());
			}
			
			if(valorMatricula.compareTo(new BigDecimal(2000))>0) {
				BigDecimal valorDescuento=valorMatricula.multiply(new BigDecimal(7)).divide(new BigDecimal (100));
				valorMatricula=valorDescuento;
			}
		Matricula matricula =new Matricula();
		matricula.setFechaMatricula(LocalDateTime.now());
		matricula.setPropietario(pro);
		matricula.setVehiculo(v);
		matricula.setValorMatricula(valorMatricula);
		
		this.iMatriculaRepository.crear(matricula);
	}
*/
}
