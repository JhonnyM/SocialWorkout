package com.cenfotec.socialWorkout.contracts;

import com.cenfotec.socialWorkout.pojo.EventoshasusuarioPOJO;

public class EventoshasusuariosRequest {

	private EventoshasusuarioPOJO evento;
	
	public EventoshasusuariosRequest() {
		super();
	}
	
	public EventoshasusuarioPOJO getEvento() {
		return evento;
	}
	
	public void setEvento(EventoshasusuarioPOJO evento) {
		this.evento = evento;
	}

	@Override
	public String toString() {
		return "EventoRequest [evento=" + evento + "]";
	}
	
}
