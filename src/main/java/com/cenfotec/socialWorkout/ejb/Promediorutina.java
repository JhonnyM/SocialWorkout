package com.cenfotec.socialWorkout.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the promediorutinas database table.
 * 
 */
@Entity
@Table(name="promediorutinas")
@NamedQuery(name="Promediorutina.findAll", query="SELECT p FROM Promediorutina p")
public class Promediorutina implements Serializable {
	private static final long serialVersionUID = 1L;

	private String dia;

	private int hora;
    @Id
	private int id;

	private int idRutina;

	private BigDecimal promedio;

	public Promediorutina() {
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

	public int getIdRutina() {
		return this.idRutina;
	}

	public void setIdRutina(int idRutina) {
		this.idRutina = idRutina;
	}

	public BigDecimal getPromedio() {
		return this.promedio;
	}

	public void setPromedio(BigDecimal promedio) {
		this.promedio = promedio;
	}

}