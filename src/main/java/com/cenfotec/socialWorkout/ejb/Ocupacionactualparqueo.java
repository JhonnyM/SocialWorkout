package com.cenfotec.socialWorkout.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the ocupacionactualparqueo database table.
 * 
 */
@Entity
@NamedQuery(name="Ocupacionactualparqueo.findAll", query="SELECT o FROM Ocupacionactualparqueo o")
public class Ocupacionactualparqueo implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigInteger capacidad;
   @Id
	private BigInteger id;

	@Column(name="OCUPACION_PARQUEO")
	private BigInteger ocupacionParqueo;

	public Ocupacionactualparqueo() {
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

	public BigInteger getOcupacionParqueo() {
		return this.ocupacionParqueo;
	}

	public void setOcupacionParqueo(BigInteger ocupacionParqueo) {
		this.ocupacionParqueo = ocupacionParqueo;
	}

}