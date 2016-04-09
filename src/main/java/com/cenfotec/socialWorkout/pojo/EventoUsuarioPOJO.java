package com.cenfotec.socialWorkout.pojo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

public class EventoUsuarioPOJO {

	private int idEvento;
//	private int idUsuario;
	private String descEvento;
	private Date fechaHoraFinal;
	private Date fechaHoraInicio;
	private String observaciones;
	private List<EventoshasusuarioPOJO> eventoshasusuarios;
	private String inscrito;
	private UsuarioPOJO usuario;
	
	public EventoUsuarioPOJO() {

	}

	public int getIdEvento() {
		return this.idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

//	public int getIdUsuario() {
//		return this.idUsuario;
//	}
//
//	public void setIdUsuario(int idUsuario) {
//		this.idUsuario = idUsuario;
//	}
	
	public String getDescEvento() {
		return this.descEvento;
	}

	public void setDescEvento(String descEvento) {
		this.descEvento = descEvento;
	}

	public UsuarioPOJO getUsuario(){
		return this.usuario;
	}
	
	public void setUsuario(UsuarioPOJO usuario){
		this.usuario = usuario;
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

	public List<EventoshasusuarioPOJO> getEventoshasusuarios() {
		return this.eventoshasusuarios;
	}

	public void setEventoshasusuarios(List<EventoshasusuarioPOJO> eventoshasusuarios) {
		this.eventoshasusuarios = eventoshasusuarios;
	}

	public void setInscrito() {

		if (this.eventoshasusuarios.size() > 0) {

			this.eventoshasusuarios.stream().forEach(e -> {
				if ((this.usuario.getIdUsuario() == e.getUsuarioPOJO().getIdUsuario())
						&& this.idEvento == e.getEventoPOJO().getIdEvento()
						) {
					inscrito = "Evento ya inscrito";
				} else {
					inscrito = "Evento no inscrito";
				}
			});
		} else {
			this.inscrito = "Evento no inscrito";
		}

	};

	public String getInscrito() {
		return this.inscrito;
	}

}
