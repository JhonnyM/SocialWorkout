package com.cenfotec.socialWorkout.controllers;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.socialWorkout.contracts.UnidadmedidaRequest;
import com.cenfotec.socialWorkout.contracts.UnidadmedidaResponse;
import com.cenfotec.socialWorkout.ejb.Unidadmedida;
import com.cenfotec.socialWorkout.services.UnidadmedidaServiceInterface;

@RestController
@RequestMapping(value ="rest/protected/UnidadesMedidas")
public class UnidadmedidaController {
	
	@Autowired private UnidadmedidaServiceInterface unidadMedidaService;
	@Autowired private HttpServletRequest request;

	@RequestMapping(value="/getAll", method = RequestMethod.POST)
	public UnidadmedidaResponse getAll(@RequestBody UnidadmedidaRequest umr){
		UnidadmedidaResponse um = new UnidadmedidaResponse();
		um.setCode(200);
		um.setUnidadesMedidas(unidadMedidaService.getAll(umr));
		return um;
	}
	
}
