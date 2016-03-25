package com.cenfotec.socialWorkout.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the ocupacionactualgimnasio database table.
 * 
 */
@Entity
@NamedQuery(name="Ocupacionactualgimnasio.findAll", query="SELECT o FROM Ocupacionactualgimnasio o")
public class Ocupacionactualgimnasio implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigInteger capacidad;
    @Id
	private BigInteger id;

	@Column(name="OCUPACION_GIMNASIO")
	private BigInteger ocupacionGimnasio;

	public Ocupacionactualgimnasio() {
	}

	public BigInteger getCapacidad() {
		return this.capacidad;
	}

	public void setCapacidad(BigInteger capacidad) {
		this.capacidad = capacidad;
	}

	public BigInteger getId() {
		return this.id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public BigInteger getOcupacionGimnasio() {
		return this.ocupacionGimnasio;
	}

	public void setOcupacionGimnasio(BigInteger ocupacionGimnasio) {
		this.ocupacionGimnasio = ocupacionGimnasio;
	}

}
