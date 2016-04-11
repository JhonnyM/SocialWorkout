package com.cenfotec.socialWorkout.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cenfotec.socialWorkout.contracts.MaquinaRequest;
import com.cenfotec.socialWorkout.contracts.MaquinaResponse;
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
		MaquinaResponse maquinaResponse = new MaquinaResponse();
		maquinaResponse.setCode(200);
		maquinaResponse.setMaquinas(maquinaService.getAll());
		return maquinaResponse;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public MaquinaResponse create(@RequestBody MaquinaRequest maquinaRequest) {

		MaquinaResponse maquinaResponse = new MaquinaResponse();
		Boolean state = maquinaService.saveMaquina(maquinaRequest);

		if (state) {
			maquinaResponse.setCode(200);
			maquinaResponse.setCodeMessage("Máquina creada correctamente.");
		}
		return maquinaResponse;

	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public MaquinaResponse edit(@RequestBody MaquinaRequest maquinaRequest) {

		MaquinaResponse maquinaResponse = new MaquinaResponse();

		if (maquinaService.exists(maquinaRequest.getMaquina().getIdMaquina())) {
			if (maquinaService.saveMaquina(maquinaRequest)) {
				maquinaResponse.setCode(200);
				maquinaResponse.setCodeMessage("La información del ejercicio fue modificada correctamente.");
			} else {
				maquinaResponse.setCode(500);
				maquinaResponse.setCodeMessage("La información del ejercicio no fue modificada.");

			}
		}
		return maquinaResponse;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public MaquinaResponse delete(@RequestBody MaquinaRequest maquinaRequest) {

		MaquinaResponse maquinaResponse = new MaquinaResponse();

		if (maquinaService.exists(maquinaRequest.getMaquina().getIdMaquina())) {
			if (maquinaService.delete(maquinaRequest.getMaquina().getIdMaquina())) {
				maquinaResponse.setCode(200);
				maquinaResponse.setCodeMessage("El unidad medida fue eliminado exitosamente");
			} else {
				maquinaResponse.setCode(500);
				maquinaResponse.setCodeMessage("Hubo un error al momento de eliminar la unidad");
			}

		} else {
			maquinaResponse.setCode(404);
			maquinaResponse.setCodeMessage("La unidad de medida no existe");
		}

		return maquinaResponse;

	}

}