package com.cenfotec.socialWorkout.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.socialWorkout.contracts.RegistroIngresoRequest;
import com.cenfotec.socialWorkout.contracts.RegistroIngresoResponse;
import com.cenfotec.socialWorkout.services.RegistroIngresoServiceInterface;

@RestController
@RequestMapping(value ="rest/protected/ingreso")
public class RegistroIngresoController {
	
	@Autowired private RegistroIngresoServiceInterface IngresoService;
	
	@RequestMapping(value ="/getAllByFechaIngreso", method = RequestMethod.POST)
	public RegistroIngresoResponse getAllByFechaIngreso(@RequestBody RegistroIngresoRequest ir){
					
		RegistroIngresoResponse lstIngreses = new RegistroIngresoResponse();
		lstIngreses.setCode(200);
		lstIngreses.setCodeMessage("parametro fetch success");
		lstIngreses.setRegistroIngreso(IngresoService.getAllByFechaIngreso(ir));
		return lstIngreses;		
	}

}
