package com.cenfotec.socialWorkout.contracts;

import java.util.List;
import com.cenfotec.socialWorkout.pojo.EventoPOJO;

public class EventoResponse extends BaseResponse {
	
	private List<EventoPOJO> eventos;
	private EventoPOJO evento;

	public EventoResponse() {
		super();
	}
	
	public List<EventoPOJO> getEventos() {
		return eventos;
	}

	public void setEventos(List<EventoPOJO> eventos) {
		this.eventos = eventos;
	}

	public EventoPOJO getEvento() {
		return evento;
	}

	public void setEvento(EventoPOJO evento) {
		this.evento = evento;
	}

}
