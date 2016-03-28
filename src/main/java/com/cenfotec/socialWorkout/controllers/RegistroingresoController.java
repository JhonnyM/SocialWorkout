package com.cenfotec.socialWorkout.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.socialWorkout.contracts.RegistroingresoRequest;
import com.cenfotec.socialWorkout.contracts.RegistroingresoResponse;
import com.cenfotec.socialWorkout.contracts.TipoUsuarioResponse;
import com.cenfotec.socialWorkout.pojo.RegistroingresoPOJO;
import com.cenfotec.socialWorkout.services.RegistroingresoServiceInterface;

	
@RestController
@RequestMapping(value ="/rest/protected/registro")
public class RegistroingresoController {
	

	@Autowired private RegistroingresoServiceInterface registroService;

	@RequestMapping(value ="/getRegistroIngresoByUsuario", method = RequestMethod.POST)
	public RegistroingresoResponse getRegistroIngresoByUsuario() {
		RegistroingresoResponse response = new RegistroingresoResponse();
		response.setCode(200);
		response.setCodeMessage("Tipo fetch success");
		response.setRegistro(registroService.getRegistroIngresoByUsuario());
		return response;		
	}
	
	@RequestMapping(value ="/create", method = RequestMethod.POST)
	public RegistroingresoResponse create(@RequestBody RegistroingresoRequest registroRequest){	
		RegistroingresoResponse tResp = new RegistroingresoResponse();
		Boolean state = registroService.save(registroRequest);
		
		if(state){
			tResp.setCode(200);
			tResp.setCodeMessage("Registro creada satisfactoriamente");
		}
		return tResp;
	
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public RegistroingresoResponse save(@RequestBody RegistroingresoRequest registroRequest) {
	
		RegistroingresoResponse registroResponse = new RegistroingresoResponse();
		boolean saved = registroService.save(registroRequest);
		
		if(saved){
			registroResponse.setCode(200);
			registroResponse.setCodeMessage("Registro realizado");
		}
		else
		{
			registroResponse.setCode(404);
			registroResponse.setCodeMessage("Hubo un error al momento de realizar el registro");
		}
		return registroResponse;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public RegistroingresoResponse update(@RequestBody RegistroingresoRequest registroRequest) {
		
		RegistroingresoResponse registroResponse = new RegistroingresoResponse();
		
		if (registroService.exists(registroRequest.getRegistro().getIdRegistroIngreso()))
		{
			if(registroService.save(registroRequest))
			{
				registroResponse.setCode(200);
				registroResponse.setCodeMessage("La información de la clase fue modificada exitosamente.");
			}
			else
			{
				registroResponse.setCode(500);
				registroResponse.setCodeMessage("Hubo un error al momento de modificar la información de la clase");
			}
		}
		else
		{
			registroResponse.setCode(404);
			registroResponse.setCodeMessage("La clase a modificar no existe en la base de datos");
		}
		
		
		return registroResponse;
		
	}
}

