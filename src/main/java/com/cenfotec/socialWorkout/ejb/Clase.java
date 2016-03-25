package com.cenfotec.socialWorkout.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the clase database table.
 * 
 */
@Entity
@NamedQuery(name="Clase.findAll", query="SELECT c FROM Clase c")
public class Clase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idClase;

	private String descClase;

	//bi-directional many-to-one association to Agendaclas
	@OneToMany(mappedBy="clase")
	private List<Agendaclas> agendaclases;

	public Clase() {
	}

	public int getIdClase() {
		return this.idClase;
	}

	public void setIdClase(int idClase) {
		this.idClase = idClase;
	}

	public String getDescClase() {
		return this.descClase;
	}

	public void setDescClase(String descClase) {
		this.descClase = descClase;
	}

	public List<Agendaclas> getAgendaclases() {
		return this.agendaclases;
	}

	public void setAgendaclases(List<Agendaclas> agendaclases) {
		this.agendaclases = agendaclases;
	}

	public Agendaclas addAgendaclas(Agendaclas agendaclas) {
		getAgendaclases().add(agendaclas);
		agendaclas.setClase(this);

		return agendaclas;
	}

	public Agendaclas removeAgendaclas(Agendaclas agendaclas) {
		getAgendaclases().remove(agendaclas);
		agendaclas.setClase(null);

		return agendaclas;
	}

}