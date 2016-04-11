package com.cenfotec.socialWorkout.pojo;

import java.sql.Time;
import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cenfotec.socialWorkout.ejb.Plantillarutinamaestro;
import com.cenfotec.socialWorkout.ejb.Usuario;

public class RutinaHasUsuarioPOJO {


	private int idRegistroRutinaXUsuario;
	private String diaSemanalAgendado;
	private Date fechaInicio;
	private Date fechaVencimiento;
	private Time hora;
	private PlantillarutinamaestroPOJO plantillarutinamaestroPOJO;
	private UsuarioPOJO usuario;

	
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


	public PlantillarutinamaestroPOJO getPlantillarutinamaestroPOJO() {
		return plantillarutinamaestroPOJO;
	}


	public void setPlantillarutinamaestroPOJO(PlantillarutinamaestroPOJO plantillarutinamaestroPOJO) {
		this.plantillarutinamaestroPOJO = plantillarutinamaestroPOJO;
	}


	public UsuarioPOJO getUsuario() {
		return usuario;
	}


	public void setUsuario(UsuarioPOJO usuario) {
		this.usuario = usuario;
	}

}
