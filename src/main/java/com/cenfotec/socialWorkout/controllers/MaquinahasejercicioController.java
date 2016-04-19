package com.cenfotec.socialWorkout.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.socialWorkout.contracts.EjercicioRequest;
import com.cenfotec.socialWorkout.contracts.MaquinahasejercicioRequest;
import com.cenfotec.socialWorkout.contracts.MaquinahasejercicioResponse;
import com.cenfotec.socialWorkout.pojo.MaquinahasejercicioPOJO;
import com.cenfotec.socialWorkout.services.MaquinahasejercicioServiceInterface;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "rest/protected/Maquinahasejercicios")
public class MaquinahasejercicioController {

	@Autowired private MaquinahasejercicioServiceInterface relationService;

	@RequestMapping(value ="/all", method = RequestMethod.GET)
	public MaquinahasejercicioResponse getAll(){	
		
		MaquinahasejercicioResponse response = new MaquinahasejercicioResponse();
		response.setCode(200);
		response.setCodeMessage("clase fetch success");
		response.setMaquinahasejercicio(relationService.getAll());
		return response;
		
	}

	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public MaquinahasejercicioResponse save(@RequestBody MaquinahasejercicioRequest request) {
	
		MaquinahasejercicioResponse claseResponse = new MaquinahasejercicioResponse();
		boolean saved = relationService.save(request);
		
		if(saved){
			claseResponse.setCode(200);
			claseResponse.setCodeMessage("La asignacion ha sido guardado exitosamente");
		}
		else
		{
			claseResponse.setCode(404);
			claseResponse.setCodeMessage("Hubo un error al momento de guardar la asignacion");
		}
		return claseResponse;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public MaquinahasejercicioResponse update(@RequestBody MaquinahasejercicioRequest request) {
		
		MaquinahasejercicioResponse claseResponse = new MaquinahasejercicioResponse();
		
		if (relationService.exists(request.getMaquinahasejercicio().getIdEjercicioXMaquina()))
		{
			if(relationService.save(request))
			{
				claseResponse.setCode(200);
				claseResponse.setCodeMessage("La asignacion fue modificada exitosamente.");
			}
			else
			{
				claseResponse.setCode(500);
				claseResponse.setCodeMessage("Hubo un error al momento de modificar la asignacion de la clase");
			}
		}
		else
		{
			claseResponse.setCode(404);
			claseResponse.setCodeMessage("La asignacion a modificar no existe en la base de datos");
		}
		
		
		return claseResponse;
		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public MaquinahasejercicioResponse delete(@RequestBody MaquinahasejercicioRequest request) {

		MaquinahasejercicioResponse claseResponse = new MaquinahasejercicioResponse();
		
		if (relationService.exists(request.getMaquinahasejercicio().getIdEjercicioXMaquina()))
		{
			if(relationService.delete(request.getMaquinahasejercicio().getIdEjercicioXMaquina()))
			{
				claseResponse.setCode(200);
				claseResponse.setCodeMessage("La asignacion fue eliminada exitosamente");
			}
			else
			{
				claseResponse.setCode(500);
				claseResponse.setCodeMessage("Hubo un error al momento de eliminar la asignacion");
			}	
		}
		else
		{
			claseResponse.setCode(404);
			claseResponse.setCodeMessage("La clase no existe");
		}
		return claseResponse;

	}

	@RequestMapping(value ="/find", method = RequestMethod.POST)
	public MaquinahasejercicioResponse findOne(@RequestBody EjercicioRequest request){	
		
		MaquinahasejercicioResponse response = new MaquinahasejercicioResponse();
		response.setCode(200);
		response.setCodeMessage("relation fetch success");
		response.setMaquinahasejercicio(relationService.findByIdEjercicio(request.getEjercicio().getIdEjercicio()));
		return response;
	}

	
}
