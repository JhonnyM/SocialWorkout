package com.cenfotec.socialWorkout.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.socialWorkout.contracts.MaquinaRequest;
import com.cenfotec.socialWorkout.contracts.MaquinaResponse;
import com.cenfotec.socialWorkout.contracts.RegistroMedidaRequest;
import com.cenfotec.socialWorkout.contracts.RegistroMedidaResponse;
import com.cenfotec.socialWorkout.pojo.LugarMedicionPOJO;
import com.cenfotec.socialWorkout.pojo.RegistroMedidaPOJO;
import com.cenfotec.socialWorkout.pojo.UsuarioPOJO;
import com.cenfotec.socialWorkout.services.RegistroMedidaServiceInterface;

@RestController
@RequestMapping(value = "rest/protected/RegistrosMedidas")
public class RegistroMedidaController {

	@Autowired
	private RegistroMedidaServiceInterface registroMedidaService;
	@Autowired
	private HttpServletRequest request;

	@RequestMapping(value = "/getAllByIdUsuario", method = RequestMethod.POST)

	public RegistroMedidaResponse getAllByIdUsuario(@RequestBody RegistroMedidaRequest rmR) {
		
		RegistroMedidaResponse rmRe = new RegistroMedidaResponse();
					
		rmRe.setCode(200);
		
		rmRe.setRegistroMedidaPOJO(registroMedidaService.getAllById(rmR));
		
		return rmRe;
		
	}
	
}
