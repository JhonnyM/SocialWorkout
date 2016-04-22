package com.cenfotec.socialWorkout.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the promediorutinasmaquina database table.
 * 
 */
@Entity
@NamedQuery(name="Promediorutinasmaquina.findAll", query="SELECT p FROM Promediorutinasmaquina p")
public class Promediorutinasmaquina implements Serializable {
	private static final long serialVersionUID = 1L;

	private int cantidad;

	private BigDecimal capacidadTotal;

	private int codigoMaquina;

	private String dia;

	private int hora;
    @Id
	private BigDecimal id;

	private String maquina;

	private int minutosXPersona;

	private BigDecimal ocupacion;

	private int personasXMaquina;

	private BigDecimal promedio;

	public Promediorutinasmaquina() {
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getCapacidadTotal() {
		return this.capacidadTotal;
	}

	public void setCapacidadTotal(BigDecimal capacidadTotal) {
		this.capacidadTotal = capacidadTotal;
	}

	public int getCodigoMaquina() {
		return this.codigoMaquina;
	}

	public void setCodigoMaquina(int codigoMaquina) {
		this.codigoMaquina = codigoMaquina;
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

	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getMaquina() {
		return this.maquina;
	}

	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}

	public int getMinutosXPersona() {
		return this.minutosXPersona;
	}

	public void setMinutosXPersona(int minutosXPersona) {
		this.minutosXPersona = minutosXPersona;
	}

	public BigDecimal getOcupacion() {
		return this.ocupacion;
	}

	public void setOcupacion(BigDecimal ocupacion) {
		this.ocupacion = ocupacion;
	}

	public int getPersonasXMaquina() {
		return this.personasXMaquina;
	}

	public void setPersonasXMaquina(int personasXMaquina) {
		this.personasXMaquina = personasXMaquina;
	}

	public BigDecimal getPromedio() {
		return this.promedio;
	}

	public void setPromedio(BigDecimal promedio) {
		this.promedio = promedio;
	}

}