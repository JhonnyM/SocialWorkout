package com.cenfotec.socialWorkout.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.List;


/**
 * The persistent class for the agendaclases database table.
 * 
 */
@Entity
@Table(name="agendaclases")
@NamedQuery(name="Agendaclas.findAll", query="SELECT a FROM Agendaclas a")
public class Agendaclas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idAgendaClase;

	private String diaSemanal;

	private Time horaFinal;

	private Time horaInicio;

	//bi-directional many-to-one association to Clase
	@ManyToOne
	@JoinColumn(name="idClase")
	private Clase clase;

	//bi-directional many-to-one association to Registroplanclas
	@OneToMany(mappedBy="agendaclas")
	private List<Registroplanclas> registroplanclases;

	public Agendaclas() {
	}

	public int getIdAgendaClase() {
		return this.idAgendaClase;
	}

	public void setIdAgendaClase(int idAgendaClase) {
		this.idAgendaClase = idAgendaClase;
	}

	public String getDiaSemanal() {
		return this.diaSemanal;
	}

	public void setDiaSemanal(String diaSemanal) {
		this.diaSemanal = diaSemanal;
	}

	public Time getHoraFinal() {
		return this.horaFinal;
	}

	public void setHoraFinal(Time horaFinal) {
		this.horaFinal = horaFinal;
	}

	public Time getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Clase getClase() {
		return this.clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

	public List<Registroplanclas> getRegistroplanclases() {
		return this.registroplanclases;
	}

	public void setRegistroplanclases(List<Registroplanclas> registroplanclases) {
		this.registroplanclases = registroplanclases;
	}

	public Registroplanclas addRegistroplanclas(Registroplanclas registroplanclas) {
		getRegistroplanclases().add(registroplanclas);
		registroplanclas.setAgendaclas(this);

		return registroplanclas;
	}

	public Registroplanclas removeRegistroplanclas(Registroplanclas registroplanclas) {
		getRegistroplanclases().remove(registroplanclas);
		registroplanclas.setAgendaclas(null);

		return registroplanclas;
	}

}