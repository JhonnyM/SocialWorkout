package com.cenfotec.socialWorkout.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;


/**
 * The persistent class for the promedioocupacionparqueo database table.
 * 
 */
@Entity
@NamedQuery(name="Promedioocupacionparqueo.findAll", query="SELECT p FROM Promedioocupacionparqueo p")
public class Promedioocupacionparqueo implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigInteger capacidad;

	private String dia;

	private int hora;
    @Id
	private int id;

	private BigDecimal promedio;

	public Promedioocupacionparqueo() {
	}

	public BigInteger getCapacidad() {
		return this.capacidad;
	}

	public void setCapacidad(BigInteger capacidad) {
		this.capacidad = capacidad;
	}

	public String getDia() {
		return this.dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public int getHora() {
		return this.hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getPromedio() {
		return this.promedio;
	}

	public void setPromedio(BigDecimal promedio) {
		this.promedio = promedio;
	}

}