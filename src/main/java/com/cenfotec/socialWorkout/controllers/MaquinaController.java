package com.cenfotec.socialWorkout.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.socialWorkout.contracts.EjercicioResponse;
import com.cenfotec.socialWorkout.contracts.MaquinaRequest;
import com.cenfotec.socialWorkout.contracts.MaquinaResponse;
import com.cenfotec.socialWorkout.contracts.UnidadMedidaRequest;
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

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public MaquinaResponse getAll() {
		MaquinaResponse mre = new MaquinaResponse();
		mre.setCode(200);
		mre.setMaquinas(maquinaService.getAll());
		return mre;
	}
	
	@RequestMapping(value ="/create", method = RequestMethod.POST)
	public MaquinaResponse create(@RequestBody MaquinaRequest mr){	
		
		MaquinaResponse mre = new MaquinaResponse();
		Boolean state = maquinaService.saveMaquina(mr);
	
		if(state){
			mre.setCode(200);
			mre.setCodeMessage("Máquina creada correctamente.");
		}
		return mre;
		
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public MaquinaResponse edit(@RequestBody MaquinaRequest mr) {

		MaquinaResponse mre = new MaquinaResponse();
		
		if(maquinaService.exists(mr.getMaquina().getIdMaquina())){
			if (maquinaService.saveMaquina(mr)){
				mre.setCode(200);
				mre.setCodeMessage("La información del ejercicio fue modificada correctamente.");
			}else{
				mre.setCode(500);
				mre.setCodeMessage("La información del ejercicio no fue modificada.");
				
			}
		}
		return mre;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public MaquinaResponse delete(@RequestBody MaquinaRequest mr) {

		MaquinaResponse objetivoResponse = new MaquinaResponse();

		if (maquinaService.exists(mr.getMaquina().getIdMaquina())) {
			if (maquinaService.delete(mr.getMaquina().getIdMaquina())) {
				objetivoResponse.setCode(200);
				objetivoResponse.setCodeMessage("El unidad medida fue eliminado exitosamente");
			} else {
				objetivoResponse.setCode(500);
				objetivoResponse.setCodeMessage("Hubo un error al momento de eliminar la unidad");
			}

		} else {
			objetivoResponse.setCode(404);
			objetivoResponse.setCodeMessage("La unidad de medida no existe");
		}

		return objetivoResponse;

	}


}
