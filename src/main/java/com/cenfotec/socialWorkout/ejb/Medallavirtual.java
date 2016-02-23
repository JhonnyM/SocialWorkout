package com.cenfotec.socialWorkout.ejb;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the medallavirtual database table.
 * 
 */
@Entity
@NamedQuery(name="Medallavirtual.findAll", query="SELECT m FROM Medallavirtual m")
public class Medallavirtual implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idMedallaVirtual;

	private int cantidadMinimaPuntos;

	//bi-directional many-to-one association to Clasepremiacion
	@ManyToOne
	@JoinColumn(name="idClasePremiacion")
	private Clasepremiacion clasepremiacion;

	public Medallavirtual() {
	}

	public int getIdMedallaVirtual() {
		return this.idMedallaVirtual;
	}

	public void setIdMedallaVirtual(int idMedallaVirtual) {
		this.idMedallaVirtual = idMedallaVirtual;
	}

	public int getCantidadMinimaPuntos() {
		return this.cantidadMinimaPuntos;
	}

	public void setCantidadMinimaPuntos(int cantidadMinimaPuntos) {
		this.cantidadMinimaPuntos = cantidadMinimaPuntos;
	}

	public Clasepremiacion getClasepremiacion() {
		return this.clasepremiacion;
	}

	public void setClasepremiacion(Clasepremiacion clasepremiacion) {
		this.clasepremiacion = clasepremiacion;
	}

}