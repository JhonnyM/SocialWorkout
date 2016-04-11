package com.cenfotec.socialWorkout.pojo;

public class RegistroplanclasPOJO {

	private int idAsignacionClases;
	private AgendaclasPOJO agendaclas;
	private UsuarioPOJO usuario;

	public RegistroplanclasPOJO() {
	}

	public int getIdAsignacionClases() {
		return this.idAsignacionClases;
	}

	public void setIdAsignacionClases(int idAsignacionClases) {
		this.idAsignacionClases = idAsignacionClases;
	}

	public AgendaclasPOJO getAgendaclas() {
		return this.agendaclas;
	}

	public void setAgendaclas(AgendaclasPOJO agendaclas) {
		this.agendaclas = agendaclas;
	}

	public UsuarioPOJO getUsuario() {
		return this.usuario;
	}

	public void setUsuario(UsuarioPOJO usuario) {
		this.usuario = usuario;
	}


}
