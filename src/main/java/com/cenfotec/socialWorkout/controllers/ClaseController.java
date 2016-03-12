package com.cenfotec.socialWorkout.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.socialWorkout.contracts.ClaseRequest;
import com.cenfotec.socialWorkout.contracts.ClaseResponse;
import com.cenfotec.socialWorkout.pojo.ClasePOJO;
import com.cenfotec.socialWorkout.services.ClaseServiceInterface;

	
@RestController
@RequestMapping(value ="/rest/protected/clases")
public class ClaseController {
	

	@Autowired private ClaseServiceInterface claseService;

	@RequestMapping(value ="/create", method = RequestMethod.POST)
	public ClaseResponse create(@RequestBody ClaseRequest claseRequest){	
		ClaseResponse tResp = new ClaseResponse();
		Boolean state = claseService.save(claseRequest);
		
		if(state){
			tResp.setCode(200);
			tResp.setCodeMessage("Clase creada satisfactoriamente");
		}
		return tResp;
	
	}

	@RequestMapping(value ="/all", method = RequestMethod.GET)
	public ClaseResponse getAll(){	
		
		ClaseResponse response = new ClaseResponse();
		response.setCode(200);
		response.setCodeMessage("clase fetch success");
		response.setClases(claseService.getAll());
		return response;
		
	}
	
	@RequestMapping(value ="/find", method = RequestMethod.POST)
	public ClaseResponse findOne(@RequestBody ClaseRequest claseRequest){	
		
		ClaseResponse eventoResponse = new ClaseResponse();			
		ClasePOJO eve = claseService.getById(claseRequest);
		
		if(eve.getIdClase() > 0)
		{
			eventoResponse.setCode(200);
			eventoResponse.setCodeMessage("Información de la clase encontrada");
			eventoResponse.setClase(eve);
		}
		else
		{
			eventoResponse.setCode(404);
			eventoResponse.setCodeMessage("No se encontro la informacion relativa a la clase");
			eventoResponse.setClase(eve);
		}			
		return eventoResponse;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ClaseResponse save(@RequestBody ClaseRequest claseRequest) {
	
		ClaseResponse eventoResponse = new ClaseResponse();
		boolean saved = claseService.save(claseRequest);
		
		if(saved){
			eventoResponse.setCode(200);
			eventoResponse.setCodeMessage("La clase ha sido guardado exitosamente");
		}
		else
		{
			eventoResponse.setCode(404);
			eventoResponse.setCodeMessage("Hubo un error al momento de guardar la clase");
		}
		return eventoResponse;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ClaseResponse update(@RequestBody ClaseRequest claseRequest) {
		
		ClaseResponse eventoResponse = new ClaseResponse();
		
		if (claseService.exists(claseRequest.getClase().getIdClase()))
		{
			if(claseService.save(claseRequest))
			{
				eventoResponse.setCode(200);
				eventoResponse.setCodeMessage("La información de la clase fue modificada exitosamente.");
			}
			else
			{
				eventoResponse.setCode(500);
				eventoResponse.setCodeMessage("Hubo un error al momento de modificar la información de la clase");
			}
		}
		else
		{
			eventoResponse.setCode(404);
			eventoResponse.setCodeMessage("La clase a modificar no existe en la base de datos");
		}
		
		
		return eventoResponse;
		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ClaseResponse delete(@RequestBody ClaseRequest claseRequest) {

		ClaseResponse eventoResponse = new ClaseResponse();
		
		if (claseService.exists(claseRequest.getClase().getIdClase()))
		{
			if(claseService.delete(claseRequest.getClase().getIdClase()))
			{
				eventoResponse.setCode(200);
				eventoResponse.setCodeMessage("La clase fue eliminada exitosamente");
			}
			else
			{
				eventoResponse.setCode(500);
				eventoResponse.setCodeMessage("Hubo un error al momento de eliminar la clase");
			}	
		}
		else
		{
			eventoResponse.setCode(404);
			eventoResponse.setCodeMessage("La clase no existe");
		}
		return eventoResponse;

	}
}

