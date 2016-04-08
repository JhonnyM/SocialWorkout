package com.cenfotec.socialWorkout.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.socialWorkout.contracts.PlantillarutinadetalleRequest;
import com.cenfotec.socialWorkout.contracts.PlantillarutinadetalleResponse;
import com.cenfotec.socialWorkout.services.PlantillarutinadetalleServiceInterface;

	
@RestController
@RequestMapping(value ="/rest/protected/plantillaDetalles")
public class PlantillarutinadetalleController {
	

	@Autowired private PlantillarutinadetalleServiceInterface plantillaService;

	@RequestMapping(value ="/create", method = RequestMethod.POST)
	public PlantillarutinadetalleResponse create(@RequestBody PlantillarutinadetalleRequest request){	
		PlantillarutinadetalleResponse tResp = new PlantillarutinadetalleResponse();
		Boolean state = plantillaService.save(request);
		
		if(state){
			tResp.setCode(200);
			tResp.setCodeMessage("Plantilla detalle creada satisfactoriamente");
		}
		return tResp;
	
	}

	@RequestMapping(value ="/all", method = RequestMethod.GET)
	public PlantillarutinadetalleResponse getAll(){	
		
		PlantillarutinadetalleResponse response = new PlantillarutinadetalleResponse();
		response.setCode(200);
		response.setCodeMessage("Detalle Plantillas fetch success");
		response.setPlantillasDetalle(plantillaService.getAll());
		return response;
		
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public PlantillarutinadetalleResponse save(@RequestBody PlantillarutinadetalleRequest request) {
	
		PlantillarutinadetalleResponse eventoResponse = new PlantillarutinadetalleResponse();
		boolean saved = plantillaService.save(request);
		
		if(saved){
			eventoResponse.setCode(200);
			eventoResponse.setCodeMessage("El detalle plantilla ha sido guardada exitosamente");
		}
		else
		{
			eventoResponse.setCode(404);
			eventoResponse.setCodeMessage("Hubo un error al momento de guardar el detalle plantilla");
		}
		return eventoResponse;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public PlantillarutinadetalleResponse update(@RequestBody PlantillarutinadetalleRequest request) {
		
		PlantillarutinadetalleResponse eventoResponse = new PlantillarutinadetalleResponse();
		
		if (plantillaService.exists(request.getPlantillaRutinaDetalle().getIdPLantillaRutinaDetalle()))
		{
			if(plantillaService.save(request))
			{
				eventoResponse.setCode(200);
				eventoResponse.setCodeMessage("La información de el detalle plantilla fue modificada exitosamente.");
			}
			else
			{
				eventoResponse.setCode(500);
				eventoResponse.setCodeMessage("Hubo un error al momento de modificar la información del detalle plantilla");
			}
		}
		else
		{
			eventoResponse.setCode(404);
			eventoResponse.setCodeMessage("El detalle plantilla a modificar no existe en la base de datos");
		}
		
		
		return eventoResponse;
		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public PlantillarutinadetalleResponse delete(@RequestBody PlantillarutinadetalleRequest request) {

		PlantillarutinadetalleResponse eventoResponse = new PlantillarutinadetalleResponse();
		
		if (plantillaService.exists(request.getPlantillaRutinaDetalle().getIdPLantillaRutinaDetalle()))
		{
			if(plantillaService.delete(request.getPlantillaRutinaDetalle().getIdPLantillaRutinaDetalle()))
			{
				eventoResponse.setCode(200);
				eventoResponse.setCodeMessage("El detalle plantilla fue eliminado exitosamente");
			}
			else
			{
				eventoResponse.setCode(500);
				eventoResponse.setCodeMessage("Hubo un error al momento de eliminar el detalle plantilla");
			}	
		}
		else
		{
			eventoResponse.setCode(404);
			eventoResponse.setCodeMessage("El detalle plantilla no existe");
		}
		return eventoResponse;

	}
}

