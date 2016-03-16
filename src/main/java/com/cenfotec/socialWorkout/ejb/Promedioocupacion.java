package com.cenfotec.socialWorkout.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the promedioocupacion database table.
 * 
 */
@Entity
@NamedQuery(name="Promedioocupacion.findAll", query="SELECT p FROM Promedioocupacion p")
public class Promedioocupacion implements Serializable {
	private static final long serialVersionUID = 1L;

	private String dia;

	private int hora;
    @Id
	private int id;

	private BigDecimal promedio;

	public Promedioocupacion() {
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