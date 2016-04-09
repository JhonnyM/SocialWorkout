package com.cenfotec.socialWorkout.contracts;

import java.util.List;

import com.cenfotec.socialWorkout.pojo.EventoUsuarioPOJO;

public class EventoUsuarioResponse extends BaseResponse {

	private List<EventoUsuarioPOJO> eventos;

	public EventoUsuarioResponse() {
		super();
	}
	
	public List<EventoUsuarioPOJO> getEventos() {
		return eventos;
	}

	public void setEventos(List<EventoUsuarioPOJO> eventos) {
		this.eventos = eventos;
	}
	
}
