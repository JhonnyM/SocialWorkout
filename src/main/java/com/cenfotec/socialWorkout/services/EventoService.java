package com.cenfotec.socialWorkout.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cenfotec.socialWorkout.contracts.EventoRequest;
import com.cenfotec.socialWorkout.ejb.Evento;
import com.cenfotec.socialWorkout.pojo.EventoPOJO;
import com.cenfotec.socialWorkout.repositories.EventoRepository;



@Service
public class EventoService implements EventoServiceInterface{

	@Autowired private EventoRepository eventoRepository;
	

	@Override
	@Transactional
	public List<EventoPOJO> getAll() {		
		List<Evento> eventos = eventoRepository.findAll();
		List<EventoPOJO> dtos = new ArrayList<EventoPOJO>();
		eventos.stream().forEach(ta ->{
			EventoPOJO dto = new EventoPOJO();
			BeanUtils.copyProperties(ta, dto);
			dtos.add(dto);
			
		});
		return dtos;	
	}
	
	@Override
	public EventoPOJO getById(EventoRequest request) {
		EventoPOJO eve = new EventoPOJO();
		Evento evento = eventoRepository.findOne(request.getEvento().getIdEvento());
		
		if(evento != null)
		{
			BeanUtils.copyProperties(evento, eve);
		}
		return eve;
	}

	@Override
	public boolean save (EventoRequest request){
		EventoPOJO eventoDTO = request.getEvento();
		Evento evento = new Evento();
		BeanUtils.copyProperties(eventoDTO, evento);
		Evento s = eventoRepository.save(evento);
		return !(s == null);
		
	}
	
	@Override
	public boolean exists (Integer idEvento){		
		return eventoRepository.exists(idEvento);		
	}

	@Override
	public boolean delete(int idEvento) {	
		eventoRepository.delete(idEvento);
		return !eventoRepository.exists(idEvento);
	}
}