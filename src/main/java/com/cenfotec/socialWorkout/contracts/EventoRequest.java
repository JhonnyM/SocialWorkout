package com.cenfotec.socialWorkout.contracts;
import com.cenfotec.socialWorkout.pojo.EventoPOJO;

public class EventoRequest extends BaseRequest {
	
	private EventoPOJO evento;
		
	public EventoRequest() {
		super();
	}
	
	public EventoPOJO getEvento() {
		return evento;
	}
	
	public void setEvento(EventoPOJO evento) {
		this.evento = evento;
	}

	@Override
	public String toString() {
		return "EventoRequest [evento=" + evento + "]";
	}
}

