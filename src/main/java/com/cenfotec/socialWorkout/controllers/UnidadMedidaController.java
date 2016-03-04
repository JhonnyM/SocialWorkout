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
	public UnidadMedidaResponse getAll(@RequestBody UnidadMedidaRequest umr) {
		UnidadMedidaResponse um = new UnidadMedidaResponse();
		um.setCode(200);
		um.setUnidadesMedidas(unidadMedidaService.getAll(umr));
		return um;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public UnidadMedidaResponse create(@RequestBody Unidadmedida um) {

		UnidadMedidaResponse umr = new UnidadMedidaResponse();
		Boolean state = unidadMedidaService.saveUnidadMedida(um);

		if (state) {
			umr.setCode(200);
			umr.setCodeMessage("Unidad medida");
		}
		return umr;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public UnidadMedidaResponse edit(@RequestBody Unidadmedida um) {

		UnidadMedidaResponse umr = new UnidadMedidaResponse();
		Boolean state = unidadMedidaService.editUnidadMedida(um);

		if (state) {
			umr.setCode(200);
			umr.setCodeMessage("Unidad medida");
		}
		return umr;
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
