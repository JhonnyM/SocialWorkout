package com.cenfotec.socialWorkout.pojo;

import java.io.Serializable;
import javax.persistence.*;

public class EventoshasusuarioPOJO implements Serializable {

	private int idEventoHasUsuario;

	private EventoPOJO eventoPOJO;

	private UsuarioPOJO usuarioPOJO;

	public EventoshasusuarioPOJO() {
	}

	public int getIdEventoHasUsuario() {
		return this.idEventoHasUsuario;
	}

	public void setIdEventoHasUsuario(int idEventoHasUsuario) {
		this.idEventoHasUsuario = idEventoHasUsuario;
	}

	public EventoPOJO getEventoPOJO() {
		return this.eventoPOJO;
	}

	public void setEventoPOJO(EventoPOJO evento) {
		this.eventoPOJO = evento;
	}

	public UsuarioPOJO getUsuarioPOJO() {
		return this.usuarioPOJO;
	}

	public void setUsuarioPOJO(UsuarioPOJO usuarioPOJO) {
		this.usuarioPOJO = usuarioPOJO;
	}

}