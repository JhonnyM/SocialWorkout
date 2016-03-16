package com.cenfotec.socialWorkout.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.socialWorkout.contracts.UnidadMedidaRequest;
import com.cenfotec.socialWorkout.contracts.UnidadMedidaResponse;
import com.cenfotec.socialWorkout.contracts.UserRequest;
import com.cenfotec.socialWorkout.contracts.UserResponse;
import com.cenfotec.socialWorkout.ejb.Unidadmedida;
import com.cenfotec.socialWorkout.pojo.UnidadmedidaPOJO;
import com.cenfotec.socialWorkout.services.UnidadMedidaServiceInterface;

@RestController
@RequestMapping(value = "rest/protected/UnidadesMedidas")
public class UnidadMedidaController {

	@Autowired
	private UnidadMedidaServiceInterface unidadMedidaService;
	@Autowired
	private HttpServletRequest request;

	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	public UnidadMedidaResponse getAll() {
		UnidadMedidaResponse um = new UnidadMedidaResponse();
		um.setCode(200);
		um.setUnidadesMedidas(unidadMedidaService.getAll());
		return um;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public UnidadMedidaResponse create(@RequestBody UnidadMedidaRequest umr) {

		UnidadMedidaResponse umre = new UnidadMedidaResponse();
		Boolean state = unidadMedidaService.saveUnidadMedida(umr);

		if (state) {
			umre.setCode(200);
			umre.setCodeMessage("Unidad medida");
		}
		return umre;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public UnidadMedidaResponse edit(@RequestBody UnidadMedidaRequest umr) {

		UnidadMedidaResponse umre = new UnidadMedidaResponse();
		

		if (unidadMedidaService.exists(umr.getUnidadMedida().getIdUnidadMedida())) {
			if (unidadMedidaService.saveUnidadMedida(umr)) {
				umre.setCode(200);
				umre.setCodeMessage("La información del ejercicio fue modificada correctamente.");
			} else {
				umre.setCode(500);
				umre.setCodeMessage("La información del ejercicio no fue modificada.");

			}
		}
		return umre;

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public UnidadMedidaResponse delete(@RequestBody UnidadMedidaRequest ur) {

		UnidadMedidaResponse objetivoResponse = new UnidadMedidaResponse();

		if (unidadMedidaService.exists(ur.getUnidadMedida().getIdUnidadMedida())) {
			if (unidadMedidaService.delete(ur.getUnidadMedida().getIdUnidadMedida())) {
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
