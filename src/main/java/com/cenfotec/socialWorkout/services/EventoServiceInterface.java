package com.cenfotec.socialWorkout.services;

import java.util.List;

import com.cenfotec.socialWorkout.ejb.Evento;
import com.cenfotec.socialWorkout.pojo.EventoPOJO;
import com.cenfotec.socialWorkout.pojo.EventoUsuarioPOJO;
import com.cenfotec.socialWorkout.contracts.EventoRequest;
import com.cenfotec.socialWorkout.contracts.EventoUsuarioRequest;

public interface EventoServiceInterface {

	public List<EventoPOJO> getAll();
	public EventoPOJO getById(EventoRequest request);
	public boolean save (EventoRequest request);
	public boolean delete(int idTipo);
	public boolean exists (Integer idTipo);
	List<EventoUsuarioPOJO> getAllPendingEvents();
	boolean assignEventoUsuario(EventoUsuarioRequest request);
	

}