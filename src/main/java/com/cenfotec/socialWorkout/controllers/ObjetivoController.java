package com.cenfotec.socialWorkout.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.socialWorkout.contracts.ObjetivoRequest;
import com.cenfotec.socialWorkout.contracts.ObjetivoResponse;
import com.cenfotec.socialWorkout.services.ObjetivoServiceInterface;
import com.cenfotec.socialWorkout.ejb.Objetivo;

@RestController
@RequestMapping(value ="rest/protected/objetivos")
public class ObjetivoController {
	
	@Autowired private ObjetivoServiceInterface objetivoService;
	@Autowired private HttpServletRequest request;
	
	@RequestMapping(value ="/create", method = RequestMethod.POST)
	public ObjetivoResponse create(@RequestBody Objetivo objetivo){	
		
		ObjetivoResponse tResp = new ObjetivoResponse();
		Boolean state = objetivoService.saveObjetivo(objetivo);
		
		if(state){
			tResp.setCode(200);
			tResp.setCodeMessage("Objetivo creado satisfactoriamente");
		}
		return tResp;
	
	}
	
	@RequestMapping(value ="/getAll", method = RequestMethod.POST)
	public ObjetivoResponse getAll(@RequestBody ObjetivoRequest or){	
			
		ObjetivoResponse response = new ObjetivoResponse();
		response.setCode(200);
		response.setCodeMessage("Tipo fetch success");
		response.setObjetivoList(objetivoService.getAll(or));
		return response;		
	}
	
	@RequestMapping(value ="/edit", method = RequestMethod.POST)
	public ObjetivoResponse edit(@RequestBody Objetivo obj){	
 		
		ObjetivoResponse objetivo = new ObjetivoResponse();
		Boolean state = objetivoService.edit(obj);
	
		if(state){
			objetivo.setCode(200);
			objetivo.setCodeMessage("Objetivo ");
		}
		return objetivo;
 	}

 	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ObjetivoResponse delete(@RequestBody ObjetivoRequest or) {

		ObjetivoResponse objetivoResponse = new ObjetivoResponse();
		
		if (objetivoService.exists(or.getObjetivo().getIdObjetivo()))
		{
			if(objetivoService.delete(or.getObjetivo().getIdObjetivo()))
			{
				objetivoResponse.setCode(200);
				objetivoResponse.setCodeMessage("El objetivo fue eliminado exitosamente");
			}
			else
			{
				objetivoResponse.setCode(500);
				objetivoResponse.setCodeMessage("Hubo un error al momento de eliminar el objetivo");
			}
			
		}
		else
		{
			objetivoResponse.setCode(404);
			objetivoResponse.setCodeMessage("El objetivo no existe");
		}

		return objetivoResponse;

	}
}