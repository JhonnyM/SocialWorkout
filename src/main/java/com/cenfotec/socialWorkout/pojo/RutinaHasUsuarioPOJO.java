package com.cenfotec.socialWorkout.pojo;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class RutinaHasUsuarioPOJO {


	private int idRegistroRutinaXUsuario;
	private String diaSemanalAgendado;
	private Date fechaInicio;
	private Date fechaVencimiento;
	private Time hora;
	private int idRutina;
	private int idUsuario;

	
	public RutinaHasUsuarioPOJO() {
		super();
	}


	public int getIdRegistroRutinaXUsuario() {
		return idRegistroRutinaXUsuario;
	}


	public void setIdRegistroRutinaXUsuario(int idRegistroRutinaXUsuario) {
		this.idRegistroRutinaXUsuario = idRegistroRutinaXUsuario;
	}


	public String getDiaSemanalAgendado() {
		return diaSemanalAgendado;
	}


	public void setDiaSemanalAgendado(String diaSemanalAgendado) {
		this.diaSemanalAgendado = diaSemanalAgendado;
	}


	public Date getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}


	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}


	public Time getHora() {
		return hora;
	}


	public void setHora(Time hora) {
		this.hora = hora;
	}


	public int getIdRutina() {
		return idRutina;
	}


	public void setIdRutina(int idRutina) {
		this.idRutina = idRutina;
	}


	public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

}
