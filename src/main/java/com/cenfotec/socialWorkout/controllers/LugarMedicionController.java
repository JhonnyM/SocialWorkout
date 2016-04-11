package com.cenfotec.socialWorkout.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.socialWorkout.contracts.LugarMedicionRequest;
import com.cenfotec.socialWorkout.contracts.LugarMedicionResponse;
import com.cenfotec.socialWorkout.services.LugarMedicionServiceInterface;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping(value = "rest/protected/lugarMedicion")
public class LugarMedicionController {

	@Autowired
	private LugarMedicionServiceInterface lugarMedicionService;
	@Autowired
	private HttpServletRequest request;

	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	public LugarMedicionResponse getAll() {
		LugarMedicionResponse response = new LugarMedicionResponse();
		response.setCode(200);
		response.setCodeMessage("Tipo fetch success");
		response.setLugaresMedicionPOJO(lugarMedicionService.getAll());
		return response;
	}

	@RequestMapping(value = "/getAll2", method = RequestMethod.GET)
	public LugarMedicionResponse getAll2() {
		LugarMedicionResponse lmr = new LugarMedicionResponse();
		lmr.setCode(200);
		lmr.setLugaresMedicionPOJO(lugarMedicionService.getAll2());
		return lmr;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public LugarMedicionResponse create(@RequestBody LugarMedicionRequest lugarMedicionRequest) {
		LugarMedicionResponse tResp = new LugarMedicionResponse();
		Boolean state = lugarMedicionService.save(lugarMedicionRequest);
		if (state) {
			tResp.setCode(200);
			tResp.setCodeMessage("Tipo de usuario creado satisfactoriamente");
		}
		return tResp;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public LugarMedicionResponse edit(@RequestBody LugarMedicionRequest lugarMedicionRequest) {

		LugarMedicionResponse lugarMedicion = new LugarMedicionResponse();
		Boolean state = lugarMedicionService.edit(lugarMedicionRequest);
		if (state) {
			lugarMedicion.setCode(200);
			lugarMedicion.setCodeMessage("Tipo de usuario modificado satisfactoriamente ");
		}
		return lugarMedicion;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public LugarMedicionResponse delete(@RequestBody LugarMedicionRequest lm) {

		LugarMedicionResponse lugarMedicionResponse = new LugarMedicionResponse();

		if (lugarMedicionService.exists(lm.getLugarMedicion().getIdLugarMedicion())) {
			if (lugarMedicionService.delete(lm.getLugarMedicion().getIdLugarMedicion())) {
				lugarMedicionResponse.setCode(200);
				lugarMedicionResponse.setCodeMessage("El tipo de usuario fue eliminado exitosamente");
			} else {
				lugarMedicionResponse.setCode(500);
				lugarMedicionResponse.setCodeMessage("Hubo un error al momento de eliminar el tipo de usuario");
			}
		} else {
			lugarMedicionResponse.setCode(404);
			lugarMedicionResponse.setCodeMessage("El tipo de usuario no existe");
		}

		return lugarMedicionResponse;

	}
}