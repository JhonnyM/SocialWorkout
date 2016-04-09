package com.cenfotec.socialWorkout.pojo;

import java.util.Date;

public class RutinahasusuarioPOJO {

	private int idRegistroRutinaXUsuario;
	private String diaSemanalAgendado;
	private Date fechaInicio;
	private Date fechaVencimiento;
	private PlantillarutinamaestroPOJO plantillarutinamaestro;
	private UsuarioPOJO usuario;

	public RutinahasusuarioPOJO() {
	}

	public int getIdRegistroRutinaXUsuario() {
		return this.idRegistroRutinaXUsuario;
	}

	public void setIdRegistroRutinaXUsuario(int idRegistroRutinaXUsuario) {
		this.idRegistroRutinaXUsuario = idRegistroRutinaXUsuario;
	}

	public String getDiaSemanalAgendado() {
		return this.diaSemanalAgendado;
	}

	public void setDiaSemanalAgendado(String diaSemanalAgendado) {
		this.diaSemanalAgendado = diaSemanalAgendado;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaVencimiento() {
		return this.fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public PlantillarutinamaestroPOJO getPlantillarutinamaestro() {
		return this.plantillarutinamaestro;
	}

	public void setPlantillarutinamaestro(PlantillarutinamaestroPOJO plantillarutinamaestro) {
		this.plantillarutinamaestro = plantillarutinamaestro;
	}

	public UsuarioPOJO getUsuario() {
		return this.usuario;
	}

	public void setUsuario(UsuarioPOJO usuario) {
		this.usuario = usuario;
	}

}
