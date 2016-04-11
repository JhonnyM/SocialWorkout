package com.cenfotec.socialWorkout.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cenfotec.socialWorkout.contracts.EventoRequest;
import com.cenfotec.socialWorkout.contracts.EventoUsuarioRequest;
import com.cenfotec.socialWorkout.ejb.Evento;
import com.cenfotec.socialWorkout.ejb.Eventoshasusuario;
import com.cenfotec.socialWorkout.ejb.Usuario;
import com.cenfotec.socialWorkout.pojo.EventoPOJO;
import com.cenfotec.socialWorkout.pojo.EventoUsuarioPOJO;
import com.cenfotec.socialWorkout.pojo.EventoshasusuarioPOJO;
import com.cenfotec.socialWorkout.pojo.MaquinahasejercicioPOJO;
import com.cenfotec.socialWorkout.pojo.UsuarioPOJO;
import com.cenfotec.socialWorkout.repositories.EventoRepository;
import com.cenfotec.socialWorkout.repositories.EventoshasusuarioRepository;



@Service
public class EventoService implements EventoServiceInterface{

	@Autowired private EventoRepository eventoRepository;
	@Autowired private EventoshasusuarioRepository eventoUsuarioRepository;
	@Autowired private UserServiceInterface usuarioService;


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
	
	@Override
	@Transactional
	public List<EventoUsuarioPOJO> getAllPendingEvents() {		
		List<Evento> eventos = eventoRepository.getAllPendingEvents();
		List<EventoUsuarioPOJO> dtos = new ArrayList<EventoUsuarioPOJO>();

		
		
		eventos.stream().forEach(e ->{
			
			EventoUsuarioPOJO dto = new EventoUsuarioPOJO();
			UsuarioPOJO ulog = new UsuarioPOJO();
			ulog = usuarioService.getUsuarioSession();
			
			BeanUtils.copyProperties(e, dto);
			
			if (e.getEventoshasusuarios() != null){
				dto.setEventoshasusuarios(getDTOSEventoshasusuario(e.getEventoshasusuarios()));
			}

			dto.setUsuario(ulog);
			
			dto.setInscrito();
			
			dtos.add(dto);
			
		});
		
		return dtos;	
	}
	
	public List<EventoshasusuarioPOJO> getDTOSEventoshasusuario(List<Eventoshasusuario> eventos){

		List<EventoshasusuarioPOJO> uiEventosUsuario = new ArrayList<EventoshasusuarioPOJO>();
		UsuarioPOJO udto = new UsuarioPOJO();
		EventoPOJO edto = new EventoPOJO();

		eventos.stream().forEach(e -> {
			EventoshasusuarioPOJO dto = new EventoshasusuarioPOJO();
			BeanUtils.copyProperties(e, dto);
			BeanUtils.copyProperties(e.getUsuario(), udto);
			BeanUtils.copyProperties(e.getEvento(), edto);
			dto.setUsuarioPOJO(udto);
			dto.setEventoPOJO(edto);
			uiEventosUsuario.add(dto);
		});
		
		return uiEventosUsuario;
	
	}

	@Override
	public boolean assignEventoUsuario (EventoUsuarioRequest request){

		Usuario usuario = new Usuario();
		Evento evento = new Evento();
		
		Eventoshasusuario eventoHasUsuario = new Eventoshasusuario();
		
		BeanUtils.copyProperties(request.getEvento().getUsuario(), usuario);
		BeanUtils.copyProperties(request.getEvento(), evento);

		eventoHasUsuario.setEvento(evento);
		eventoHasUsuario.setUsuario(usuario);
		
		Eventoshasusuario e = eventoUsuarioRepository.save(eventoHasUsuario);
		
		return !(e == null);
		
	}
	
}