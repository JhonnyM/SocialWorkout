package com.cenfotec.socialWorkout.ejb;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the parametro database table.
 * 
 */
@Entity
@NamedQuery(name="Parametro.findAll", query="SELECT p FROM Parametro p")
public class Parametro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idRegistroParametro;

	private int cantidadDiasCalculoPromedios;

	private int capacidadCamposParqueo;

	private int capacidadPersonasGimnasio;

	private String nombreNegocio;

	private int tiempoOcupacionMinutos;

	public Parametro() {
	}

	public int getIdRegistroParametro() {
		return this.idRegistroParametro;
	}

	public void setIdRegistroParametro(int idRegistroParametro) {
		this.idRegistroParametro = idRegistroParametro;
	}

	public int getCantidadDiasCalculoPromedios() {
		return this.cantidadDiasCalculoPromedios;
	}

	public void setCantidadDiasCalculoPromedios(int cantidadDiasCalculoPromedios) {
		this.cantidadDiasCalculoPromedios = cantidadDiasCalculoPromedios;
	}

	public int getCapacidadCamposParqueo() {
		return this.capacidadCamposParqueo;
	}

	public void setCapacidadCamposParqueo(int capacidadCamposParqueo) {
		this.capacidadCamposParqueo = capacidadCamposParqueo;
	}

	public int getCapacidadPersonasGimnasio() {
		return this.capacidadPersonasGimnasio;
	}

	public void setCapacidadPersonasGimnasio(int capacidadPersonasGimnasio) {
		this.capacidadPersonasGimnasio = capacidadPersonasGimnasio;
	}

	public String getNombreNegocio() {
		return this.nombreNegocio;
	}

	public void setNombreNegocio(String nombreNegocio) {
		this.nombreNegocio = nombreNegocio;
	}

	public int getTiempoOcupacionMinutos() {
		return this.tiempoOcupacionMinutos;
	}

	public void setTiempoOcupacionMinutos(int tiempoOcupacionMinutos) {
		this.tiempoOcupacionMinutos = tiempoOcupacionMinutos;
	}

}