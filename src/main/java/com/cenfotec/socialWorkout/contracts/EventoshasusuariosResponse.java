package com.cenfotec.socialWorkout.contracts;

import java.util.List;

import com.cenfotec.socialWorkout.pojo.EventoshasusuarioPOJO;

public class EventoshasusuariosResponse extends BaseResponse {

	
	private List<EventoshasusuarioPOJO> eventos;

	public EventoshasusuariosResponse() {
		super();
	}
	
	public List<EventoshasusuarioPOJO> getEventos() {
		return eventos;
	}

	public void setEventos(List<EventoshasusuarioPOJO> eventos) {
		this.eventos = eventos;
	}



	
}
