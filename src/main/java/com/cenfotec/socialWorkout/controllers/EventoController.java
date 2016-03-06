package com.cenfotec.socialWorkout.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.socialWorkout.contracts.EventoRequest;
import com.cenfotec.socialWorkout.contracts.EventoResponse;
import com.cenfotec.socialWorkout.pojo.EventoPOJO;
import com.cenfotec.socialWorkout.services.EventoServiceInterface;

	
@RestController
@RequestMapping(value ="/rest/protected/eventos")
public class EventoController {
	

	@Autowired private EventoServiceInterface eventoService;

	@RequestMapping(value ="/create", method = RequestMethod.POST)
	public EventoResponse create(@RequestBody EventoRequest eventoRequest){	
		EventoResponse tResp = new EventoResponse();
		Boolean state = eventoService.save(eventoRequest);
		
		if(state){
			tResp.setCode(200);
			tResp.setCodeMessage("Evento creado satisfactoriamente");
		}
		return tResp;
	
	}

	@RequestMapping(value ="/all", method = RequestMethod.GET)
	public EventoResponse getAll(){	
		
		EventoResponse response = new EventoResponse();
		response.setCode(200);
		response.setCodeMessage("users fetch success");
		response.setEventos(eventoService.getAll());
		return response;
		
	}
	
	@RequestMapping(value ="/find", method = RequestMethod.POST)
	public EventoResponse findOne(@RequestBody EventoRequest eventoRequest){	
		
		EventoResponse eventoResponse = new EventoResponse();			
		EventoPOJO eve = eventoService.getById(eventoRequest);
		
		if(eve.getIdEvento() > 0)
		{
			eventoResponse.setCode(200);
			eventoResponse.setCodeMessage("Información del evento encontrada");
			eventoResponse.setEvento(eve);
		}
		else
		{
			eventoResponse.setCode(404);
			eventoResponse.setCodeMessage("No se encontro la informacion relativa al evento buscado");
			eventoResponse.setEvento(eve);
		}			
		return eventoResponse;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public EventoResponse save(@RequestBody EventoRequest eventoRequest) {
	
		EventoResponse eventoResponse = new EventoResponse();
		boolean saved = eventoService.save(eventoRequest);
		
		if(saved){
			eventoResponse.setCode(200);
			eventoResponse.setCodeMessage("El evento ha sido guardado exitosamente");
		}
		else
		{
			eventoResponse.setCode(404);
			eventoResponse.setCodeMessage("Hubo un error al momento de guardar el evento");
		}
		return eventoResponse;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public EventoResponse update(@RequestBody EventoRequest eventoRequest) {
		
		EventoResponse eventoResponse = new EventoResponse();
		
		if (eventoService.exists(eventoRequest.getEvento().getIdEvento()))
		{
			if(eventoService.save(eventoRequest))
			{
				eventoResponse.setCode(200);
				eventoResponse.setCodeMessage("La información del evento fue modificada exitosamente.");
			}
			else
			{
				eventoResponse.setCode(500);
				eventoResponse.setCodeMessage("Hubo un error al momento de modificar la información del evento");
			}
		}
		else
		{
			eventoResponse.setCode(404);
			eventoResponse.setCodeMessage("El evento a modificar no existe en la base de datos");
		}
		
		
		return eventoResponse;
		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public EventoResponse delete(@RequestBody EventoRequest eventoRequest) {

		EventoResponse eventoResponse = new EventoResponse();
		
		if (eventoService.exists(eventoRequest.getEvento().getIdEvento()))
		{
			if(eventoService.delete(eventoRequest.getEvento().getIdEvento()))
			{
				eventoResponse.setCode(200);
				eventoResponse.setCodeMessage("El evento fue eliminado exitosamente");
			}
			else
			{
				eventoResponse.setCode(500);
				eventoResponse.setCodeMessage("Hubo un error al momento de eliminar el evento");
			}	
		}
		else
		{
			eventoResponse.setCode(404);
			eventoResponse.setCodeMessage("El evento no existe");
		}
		return eventoResponse;

	}
}

