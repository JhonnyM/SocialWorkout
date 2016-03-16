package com.cenfotec.socialWorkout.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the ocupacionactualrutina database table.
 * 
 */
@Entity
@NamedQuery(name="Ocupacionactualrutina.findAll", query="SELECT o FROM Ocupacionactualrutina o")
public class Ocupacionactualrutina implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
	private int id;

	@Column(name="OCUPACION_RUTINA")
	private BigInteger ocupacionRutina;

	private int rutina;

	public Ocupacionactualrutina() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigInteger getOcupacionRutina() {
		return this.ocupacionRutina;
	}

	public void setOcupacionRutina(BigInteger ocupacionRutina) {
		this.ocupacionRutina = ocupacionRutina;
	}

	public int getRutina() {
		return this.rutina;
	}

	public void setRutina(int rutina) {
		this.rutina = rutina;
	}

}