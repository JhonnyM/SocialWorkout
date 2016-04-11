package com.cenfotec.socialWorkout.pojo;


import java.util.Date;
import java.util.List;

import com.cenfotec.socialWorkout.ejb.Eventoshasusuario;


public class EventoPOJO  {

	private int idEvento;
	private String descEvento;
	private Date fechaHoraFinal;
	private Date fechaHoraInicio;
	private String observaciones;

	public EventoPOJO() {
	}

	public int getIdEvento() {
		return this.idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public String getDescEvento() {
		return this.descEvento;
	}

	public void setDescEvento(String descEvento) {
		this.descEvento = descEvento;
	}

	public Date getFechaHoraFinal() {
		return this.fechaHoraFinal;
	}

	public void setFechaHoraFinal(Date fechaHoraFinal) {
		this.fechaHoraFinal = fechaHoraFinal;
	}

	public Date getFechaHoraInicio() {
		return this.fechaHoraInicio;
	}

	public void setFechaHoraInicio(Date fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}