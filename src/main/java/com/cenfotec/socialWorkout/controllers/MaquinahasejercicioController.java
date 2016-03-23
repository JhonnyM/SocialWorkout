package com.cenfotec.socialWorkout.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.socialWorkout.contracts.MaquinaRequest;
import com.cenfotec.socialWorkout.contracts.MaquinaResponse;
import com.cenfotec.socialWorkout.contracts.MaquinahasejercicioRequest;
import com.cenfotec.socialWorkout.contracts.MaquinahasejercicioResponse;
import com.cenfotec.socialWorkout.ejb.Maquinahasejercicio;
import com.cenfotec.socialWorkout.services.MaquinahasejercicioServiceInterface;

@RestController
@RequestMapping(value = "rest/protected/MaquinaEjercicios")
public class MaquinahasejercicioController {

	@Autowired
	private MaquinahasejercicioServiceInterface maquinaHasEjercicioService;
	@Autowired
	private HttpServletRequest request;

//	@RequestMapping(value = "/create", method = RequestMethod.POST)
//	public MaquinahasejercicioResponse create(@RequestBody Maquinahasejercicio mh) {
//
//		MaquinahasejercicioResponse mhre = new MaquinahasejercicioResponse();
//		Boolean state = maquinaHasEjercicioService.saveMaquinahasejercicio(mh);
//
//		if (state) {
//			mhre.setCode(200);
//			mhre.setCodeMessage("Máquina creada correctamente.");
//		}
//		
//		return mhre;
//
//	}

}
