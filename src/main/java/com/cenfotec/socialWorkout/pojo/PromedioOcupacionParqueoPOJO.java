package com.cenfotec.socialWorkout.pojo;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Id;

public class PromedioOcupacionParqueoPOJO {
	private BigInteger capacidad;
	private String dia;
    private int hora;
    private int id;
    private BigDecimal promedio;
	
	public PromedioOcupacionParqueoPOJO() {
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getPromedio() {
		return promedio;
	}

	public void setPromedio(BigDecimal promedio) {
		this.promedio = promedio;
	}

	public BigInteger getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(BigInteger capacidad) {
		this.capacidad = capacidad;
	}

	
}
