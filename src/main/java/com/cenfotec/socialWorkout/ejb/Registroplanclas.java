package com.cenfotec.socialWorkout.ejb;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the registroplanclases database table.
 * 
 */
@Entity
@Table(name="registroplanclases")
@NamedQuery(name="Registroplanclas.findAll", query="SELECT r FROM Registroplanclas r")
public class Registroplanclas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idAsignacionClases;

	//bi-directional many-to-one association to Agendaclas
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idAgendaClase")
	private Agendaclas agendaclas;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUsuario")
	private Usuario usuario;

	public Registroplanclas() {
	}

	public int getIdAsignacionClases() {
		return this.idAsignacionClases;
	}

	public void setIdAsignacionClases(int idAsignacionClases) {
		this.idAsignacionClases = idAsignacionClases;
	}

	public Agendaclas getAgendaclas() {
		return this.agendaclas;
	}

	public void setAgendaclas(Agendaclas agendaclas) {
		this.agendaclas = agendaclas;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}