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
		
		ClaseResponse claseResponse = new ClaseResponse();			
		ClasePOJO eve = claseService.getById(claseRequest);
		
		if(eve.getIdClase() > 0)
		{
			claseResponse.setCode(200);
			claseResponse.setCodeMessage("Información de la clase encontrada");
			claseResponse.setClase(eve);
		}
		else
		{
			claseResponse.setCode(404);
			claseResponse.setCodeMessage("No se encontro la informacion relativa a la clase");
			claseResponse.setClase(eve);
		}			
		return claseResponse;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ClaseResponse save(@RequestBody ClaseRequest claseRequest) {
	
		ClaseResponse claseResponse = new ClaseResponse();
		boolean saved = claseService.save(claseRequest);
		
		if(saved){
			claseResponse.setCode(200);
			claseResponse.setCodeMessage("La clase ha sido guardado exitosamente");
		}
		else
		{
			claseResponse.setCode(404);
			claseResponse.setCodeMessage("Hubo un error al momento de guardar la clase");
		}
		return claseResponse;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ClaseResponse update(@RequestBody ClaseRequest claseRequest) {
		
		ClaseResponse claseResponse = new ClaseResponse();
		
		if (claseService.exists(claseRequest.getClase().getIdClase()))
		{
			if(claseService.save(claseRequest))
			{
				claseResponse.setCode(200);
				claseResponse.setCodeMessage("La información de la clase fue modificada exitosamente.");
			}
			else
			{
				claseResponse.setCode(500);
				claseResponse.setCodeMessage("Hubo un error al momento de modificar la información de la clase");
			}
		}
		else
		{
			claseResponse.setCode(404);
			claseResponse.setCodeMessage("La clase a modificar no existe en la base de datos");
		}
		
		
		return claseResponse;
		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ClaseResponse delete(@RequestBody ClaseRequest claseRequest) {

		ClaseResponse claseResponse = new ClaseResponse();
		
		if (claseService.exists(claseRequest.getClase().getIdClase()))
		{
			if(claseService.delete(claseRequest.getClase().getIdClase()))
			{
				claseResponse.setCode(200);
				claseResponse.setCodeMessage("La clase fue eliminada exitosamente");
			}
			else
			{
				claseResponse.setCode(500);
				claseResponse.setCodeMessage("Hubo un error al momento de eliminar la clase");
			}	
		}
		else
		{
			claseResponse.setCode(404);
			claseResponse.setCodeMessage("La clase no existe");
		}
		return claseResponse;

	}
}
