package com.cenfotec.socialWorkout.pojo;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Id;

public class PromedioRutinasMaquinaPOJO {
	
	private  BigDecimal id;
	private String dia;
	private int hora;
	private int codigoMaquina;
	private String maquina;
	private BigDecimal ocupacion;
	private BigDecimal promedio;
	private BigDecimal capacidadTotal;
	private int cantidad;
	private int personasXMaquina;
	private int minutosXPersona;

	public PromedioRutinasMaquinaPOJO() {
		super();
	}

	

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	

	public String getMaquina() {
		return maquina;
	}

	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}

	public BigDecimal getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(BigDecimal ocupacion) {
		this.ocupacion = ocupacion;
	}

	public BigDecimal getPromedio() {
		return promedio;
	}

	public void setPromedio(BigDecimal promedio) {
		this.promedio = promedio;
	}

	public BigDecimal getCapacidadTotal() {
		return capacidadTotal;
	}

	public void setCapacidadTotal(BigDecimal capacidadTotal) {
		this.capacidadTotal = capacidadTotal;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPersonasXMaquina() {
		return personasXMaquina;
	}

	public void setPersonasXMaquina(int personasXMaquina) {
		this.personasXMaquina = personasXMaquina;
	}

	public int getMinutosXPersona() {
		return minutosXPersona;
	}

	public void setMinutosXPersona(int minutosXPersona) {
		this.minutosXPersona = minutosXPersona;
	}

	public int getCodigoMaquina() {
		return codigoMaquina;
	}

	public void setCodigoMaquina(int codigoMaquina) {
		this.codigoMaquina = codigoMaquina;
	}



	public BigDecimal getId() {
		return id;
	}



	public void setId(BigDecimal id) {
		this.id = id;
	}

	
}
