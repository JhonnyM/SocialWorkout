package com.cenfotec.socialWorkout.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.socialWorkout.contracts.MaquinaRequest;
import com.cenfotec.socialWorkout.contracts.MaquinaResponse;
import com.cenfotec.socialWorkout.contracts.RegistroMedidaRequest;
import com.cenfotec.socialWorkout.contracts.RegistroMedidaResponse;
import com.cenfotec.socialWorkout.pojo.LugarMedicionPOJO;
import com.cenfotec.socialWorkout.pojo.RegistroMedidaPOJO;
import com.cenfotec.socialWorkout.pojo.UsuarioPOJO;
import com.cenfotec.socialWorkout.services.RegistroMedidaServiceInterface;

@RestController
@RequestMapping(value = "rest/protected/RegistrosMedidas")
public class RegistroMedidaController {

	@Autowired
	private RegistroMedidaServiceInterface registroMedidaService;
	@Autowired
	private HttpServletRequest request;

	@RequestMapping(value = "/getAllByIdUsuario", method = RequestMethod.POST)

	public RegistroMedidaResponse getAllByIdUsuario(@RequestBody RegistroMedidaRequest rmR) {

		RegistroMedidaResponse rmRe = new RegistroMedidaResponse();

		rmRe.setCode(200);

		rmRe.setRegistroMedidaPOJO(registroMedidaService.getAllById(rmR));

		return rmRe;

	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public RegistroMedidaResponse create(@RequestBody RegistroMedidaRequest rmR) {

		RegistroMedidaResponse rmRe = new RegistroMedidaResponse();
		Boolean state = registroMedidaService.saveRegistroMedida(rmR);

		if (state) {
			rmRe.setCode(200);
			rmRe.setCodeMessage("Registro medida creado correctamente.");
		}
		return rmRe;

	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public RegistroMedidaResponse edit(@RequestBody RegistroMedidaRequest rmR) {

		RegistroMedidaResponse rmRe = new RegistroMedidaResponse();

		if (registroMedidaService.exists(rmR.getRegistroMedida().getIdRegistroMedida())) {
			if (registroMedidaService.saveRegistroMedida(rmR)) {
				rmRe.setCode(200);
				rmRe.setCodeMessage("La información del registro de medida fue actualizada correctamente.");
			} else {
				rmRe.setCode(500);
				rmRe.setCodeMessage("La información del registro de medida no fue modificada.");

			}
		}
		return rmRe;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public RegistroMedidaResponse delete(@RequestBody RegistroMedidaRequest rmR) {

		RegistroMedidaResponse rmRe = new RegistroMedidaResponse();

		if (registroMedidaService.exists(rmR.getRegistroMedida().getIdRegistroMedida())) {
			if (registroMedidaService.delete(rmR.getRegistroMedida().getIdRegistroMedida())) {
				rmRe.setCode(200);
				rmRe.setCodeMessage("El registro de medida fue eliminado exitosamente");
			} else {
				rmRe.setCode(500);
				rmRe.setCodeMessage("Hubo un error al momento de eliminar el registro de medida.");
			}

		} else {
			rmRe.setCode(404);
			rmRe.setCodeMessage("El registro de medida no existe.");
		}

		return rmRe;

	}

}
