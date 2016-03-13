package com.cenfotec.socialWorkout.pojo;
import java.sql.Time;

import java.util.List;

public class AgendaclasPOJO {

	private int idAgendaClase;
	private String diaSemanal;
	private Time horaFinal;
	private Time horaInicio;
	private ClasePOJO clase;

	private List<RegistroplanclasPOJO> registroplanclases;

	public AgendaclasPOJO() {
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

	public ClasePOJO getClase() {
		return this.clase;
	}

	public void setClase(ClasePOJO clase) {
		this.clase = clase;
	}

	public List<RegistroplanclasPOJO> getRegistroplanclases() {
		return this.registroplanclases;
	}

	public void setRegistroplanclases(List<RegistroplanclasPOJO> registroplanclases) {
		this.registroplanclases = registroplanclases;
	}

	public RegistroplanclasPOJO addRegistroplanclas(RegistroplanclasPOJO registroplanclas) {
		getRegistroplanclases().add(registroplanclas);
		registroplanclas.setAgendaclas(this);

		return registroplanclas;
	}

	public RegistroplanclasPOJO removeRegistroplanclas(RegistroplanclasPOJO registroplanclas) {
		getRegistroplanclases().remove(registroplanclas);
		registroplanclas.setAgendaclas(null);

		return registroplanclas;
	}

}

