package com.cenfotec.socialWorkout.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cenfotec.socialWorkout.contracts.MaquinaRequest;
import com.cenfotec.socialWorkout.contracts.MaquinaResponse;
import com.cenfotec.socialWorkout.contracts.UnidadMedidaResponse;
import com.cenfotec.socialWorkout.ejb.Maquina;
import com.cenfotec.socialWorkout.ejb.Unidadmedida;
import com.cenfotec.socialWorkout.services.MaquinaServiceInterface;

@RestController
@RequestMapping(value = "rest/protected/Maquinas")
public class MaquinaController {

	@Autowired
	private MaquinaServiceInterface maquinaService;
	@Autowired
	private HttpServletRequest request;

	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	public MaquinaResponse getAll(@RequestBody MaquinaRequest mr) {
		MaquinaResponse mre = new MaquinaResponse();
		mre.setCode(200);
		mre.setMaquinas(maquinaService.getAll(mr));
		return mre;
	}
	
	@RequestMapping(value ="/create", method = RequestMethod.POST)
	public MaquinaResponse create(@RequestBody Maquina m){	
		
		MaquinaResponse mr = new MaquinaResponse();
		Boolean state = maquinaService.saveMaquina(m);
	
		if(state){
			mr.setCode(200);
			mr.setCodeMessage("Máquina creada correctamente.");
		}
		return mr;
		
	}

}
