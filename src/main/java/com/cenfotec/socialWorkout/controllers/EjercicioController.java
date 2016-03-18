package com.cenfotec.socialWorkout.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.socialWorkout.contracts.EjercicioRequest;
import com.cenfotec.socialWorkout.contracts.EjercicioResponse;
import com.cenfotec.socialWorkout.contracts.MaquinaRequest;
import com.cenfotec.socialWorkout.contracts.MaquinaResponse;
import com.cenfotec.socialWorkout.contracts.MaquinahasejercicioRequest;
import com.cenfotec.socialWorkout.ejb.Ejercicio;
import com.cenfotec.socialWorkout.ejb.Maquina;
import com.cenfotec.socialWorkout.services.EjercicioServiceInterface;
import com.cenfotec.socialWorkout.services.MaquinahasejercicioServiceInterface;

@RestController
@RequestMapping(value = "rest/protected/Ejercicios")
public class EjercicioController {

	@Autowired
	private EjercicioServiceInterface ejercicioService;
	
	@Autowired
	private HttpServletRequest request;

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public EjercicioResponse getAll() {
		EjercicioResponse ere = new EjercicioResponse();
		ere.setCode(200);
		ere.setEjercicios(ejercicioService.getAll());
		return ere;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public EjercicioResponse create(@RequestBody EjercicioRequest er) {

		EjercicioResponse ere = new EjercicioResponse();
		Boolean state = ejercicioService.saveEjercicio(er);

		if (state) {
			ere.setCode(200);
			ere.setCodeMessage("Ejercicio creado correctamente.");
		}
		return ere;

	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public EjercicioResponse edit(@RequestBody EjercicioRequest er) {

		EjercicioResponse ere = new EjercicioResponse();
		
		if(ejercicioService.exists(er.getEjercicio().getIdEjercicio())){
			if (ejercicioService.saveEjercicio(er)){
				ere.setCode(200);
				ere.setCodeMessage("La información del ejercicio fue modificada correctamente.");
			}else{
				ere.setCode(500);
				ere.setCodeMessage("La información del ejercicio no fue modificada.");
				
			}
		}
		return ere;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public EjercicioResponse delete(@RequestBody EjercicioRequest er) {

		EjercicioResponse ere = new EjercicioResponse();

		if (ejercicioService.exists(er.getEjercicio().getIdEjercicio())) {
			if (ejercicioService.delete(er.getEjercicio().getIdEjercicio())) {
				ere.setCode(200);
				ere.setCodeMessage("El unidad medida fue eliminado exitosamente");
			} else {
				ere.setCode(500);
				ere.setCodeMessage("Hubo un error al momento de eliminar la unidad");
			}

		} else {

			ere.setCode(404);
			ere.setCodeMessage("La unidad de medida no existe");
		}

		return ere;

	}
	
	@RequestMapping(value = "/assignMachine", method = RequestMethod.POST)
	public EjercicioResponse assignMachine(@RequestBody EjercicioRequest er) {

		EjercicioResponse ere = new EjercicioResponse();
		Boolean state = ejercicioService.setMaquinaEjercicio(er);

		if (state) {
			ere.setCode(200);
			ere.setCodeMessage("Ejercicio creado correctamente.");
		}
		return ere;

	}
	
}
