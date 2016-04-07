package com.cenfotec.socialWorkout.contracts;

import com.cenfotec.socialWorkout.pojo.EventoPOJO;
import com.cenfotec.socialWorkout.pojo.EventoUsuarioPOJO;

public class EventoUsuarioRequest {

	private EventoUsuarioPOJO evento;
	
	public EventoUsuarioRequest() {
		super();
	}
	
	public EventoUsuarioPOJO getEvento() {
		return evento;
	}
	
	public void setEvento(EventoUsuarioPOJO evento) {
		this.evento = evento;
	}

	@Override
	public String toString() {
		return "EventoRequest [evento=" + evento + "]";
	}
}
	
