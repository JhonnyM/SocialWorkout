package com.cenfotec.socialWorkout.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.socialWorkout.contracts.PlantillarutinamaestroRequest;
import com.cenfotec.socialWorkout.contracts.PlantillarutinamaestroResponse;
import com.cenfotec.socialWorkout.pojo.PlantillarutinamaestroPOJO;
import com.cenfotec.socialWorkout.services.PlantillarutinamaestroServiceInterface;

	
@RestController
@RequestMapping(value ="/rest/protected/plantillas")
public class PlantillarutinamaestroController {
	

	@Autowired private PlantillarutinamaestroServiceInterface plantillaService;

	@RequestMapping(value ="/create", method = RequestMethod.POST)
	public PlantillarutinamaestroResponse create(@RequestBody PlantillarutinamaestroRequest request){	
		PlantillarutinamaestroResponse tResp = new PlantillarutinamaestroResponse();
		Boolean state = plantillaService.save(request);
		
		if(state){
			tResp.setCode(200);
			tResp.setCodeMessage("Plantilla creada satisfactoriamente");
		}
		return tResp;
	
	}

	@RequestMapping(value ="/all", method = RequestMethod.GET)
	public PlantillarutinamaestroResponse getAll(){	
		
		PlantillarutinamaestroResponse response = new PlantillarutinamaestroResponse();
		response.setCode(200);
		response.setCodeMessage("Plantillas fetch success");
		response.setPlantillas(plantillaService.getAll());
		return response;
		
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public PlantillarutinamaestroResponse save(@RequestBody PlantillarutinamaestroRequest request) {
	
		PlantillarutinamaestroResponse eventoResponse = new PlantillarutinamaestroResponse();
		boolean saved = plantillaService.save(request);
		
		if(saved){
			eventoResponse.setCode(200);
			eventoResponse.setCodeMessage("La plantilla ha sido guardada exitosamente");
		}
		else
		{
			eventoResponse.setCode(404);
			eventoResponse.setCodeMessage("Hubo un error al momento de guardar la plantilla");
		}
		return eventoResponse;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public PlantillarutinamaestroResponse update(@RequestBody PlantillarutinamaestroRequest request) {
		
		PlantillarutinamaestroResponse eventoResponse = new PlantillarutinamaestroResponse();
		
		if (plantillaService.exists(request.getPlantillaRutinaMaestro().getIdRutina()))
		{
			if(plantillaService.save(request))
			{
				eventoResponse.setCode(200);
				eventoResponse.setCodeMessage("La información de la plantilla fue modificada exitosamente.");
			}
			else
			{
				eventoResponse.setCode(500);
				eventoResponse.setCodeMessage("Hubo un error al momento de modificar la información de la plantilla");
			}
		}
		else
		{
			eventoResponse.setCode(404);
			eventoResponse.setCodeMessage("La plantilla a modificar no existe en la base de datos");
		}
		
		
		return eventoResponse;
		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public PlantillarutinamaestroResponse delete(@RequestBody PlantillarutinamaestroRequest request) {

		PlantillarutinamaestroResponse eventoResponse = new PlantillarutinamaestroResponse();
		
		if (plantillaService.exists(request.getPlantillaRutinaMaestro().getIdRutina()))
		{
			if(plantillaService.delete(request.getPlantillaRutinaMaestro().getIdRutina()))
			{
				eventoResponse.setCode(200);
				eventoResponse.setCodeMessage("La plantilla fue eliminada exitosamente");
			}
			else
			{
				eventoResponse.setCode(500);
				eventoResponse.setCodeMessage("Hubo un error al momento de eliminar la plantilla");
			}	
		}
		else
		{
			eventoResponse.setCode(404);
			eventoResponse.setCodeMessage("La plantilla no existe");
		}
		return eventoResponse;

	}
}

