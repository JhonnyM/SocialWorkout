package com.cenfotec.socialWorkout.controllers;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.socialWorkout.contracts.UnidadMedidaRequest;
import com.cenfotec.socialWorkout.contracts.UnidadMedidaResponse;
import com.cenfotec.socialWorkout.contracts.UserRequest;
import com.cenfotec.socialWorkout.contracts.UserResponse;
import com.cenfotec.socialWorkout.pojo.UnidadmedidaPOJO;
import com.cenfotec.socialWorkout.services.UnidadMedidaServiceInterface;

@RestController
@RequestMapping(value ="rest/protected/UnidadesMedidas")
public class UnidadMedidaController {
	
	@Autowired private UnidadMedidaServiceInterface	 unidadMedidaService;
	@Autowired private HttpServletRequest request;

	@RequestMapping(value="/getAll", method = RequestMethod.POST)
	public UnidadMedidaResponse getAll(@RequestBody UnidadMedidaRequest umr){
		UnidadMedidaResponse um = new UnidadMedidaResponse();
		um.setCode(200);
		um.setUnidadesMedidas(unidadMedidaService.getAll(umr));
		return um;
	}
	
	@RequestMapping(value ="/create", method = RequestMethod.POST)
	public UnidadMedidaResponse create(@RequestBody UnidadMedidaRequest umr){	
		
		UnidadMedidaResponse um = new UnidadMedidaResponse();
		Boolean state = unidadMedidaService.saveUnidadMedida(umr);
	
		if(state){
			um.setCode(200);
			um.setCodeMessage("Unidad medida");
		}
		return um;
		
	}
}
