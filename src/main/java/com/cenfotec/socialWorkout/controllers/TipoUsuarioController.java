package com.cenfotec.socialWorkout.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.socialWorkout.contracts.TipoUsuarioRequest;
import com.cenfotec.socialWorkout.contracts.TipoUsuarioResponse;
import com.cenfotec.socialWorkout.services.TipoUsuarioServiceInterface;
import com.cenfotec.socialWorkout.ejb.Tipousuario;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping(value ="rest/protected/tipousers")
public class TipoUsuarioController {
	
	@Autowired private TipoUsuarioServiceInterface tipoUsuarioService;
	@Autowired private HttpServletRequest request;
	
	@RequestMapping(value ="/getAll", method = RequestMethod.POST)
	public TipoUsuarioResponse getAll(){	
		TipoUsuarioResponse response = new TipoUsuarioResponse();
		response.setCode(200);
		response.setCodeMessage("Tipo fetch success");
		response.setTipoUsuariosList(tipoUsuarioService.getAll());
		return response;		
	}
	
	@RequestMapping(value ="/create", method = RequestMethod.POST)
	public TipoUsuarioResponse create(@RequestBody TipoUsuarioRequest tipoUsuarioRequest){	
		TipoUsuarioResponse tResp = new TipoUsuarioResponse();
		Boolean state = tipoUsuarioService.saveTipoUsuario(tipoUsuarioRequest);
		if(state){
			tResp.setCode(200);
			tResp.setCodeMessage("Tipo de usuario creado satisfactoriamente");
		}
		return tResp;
	}
	
	@RequestMapping(value ="/edit", method = RequestMethod.POST)
	public TipoUsuarioResponse edit(@RequestBody TipoUsuarioRequest tipoUsuarioRequest){	
 		
		TipoUsuarioResponse tipoUsuario = new TipoUsuarioResponse();
		Boolean state = tipoUsuarioService.edit(tipoUsuarioRequest);
	
		if(state){
			tipoUsuario.setCode(200);
			tipoUsuario.setCodeMessage("Tipo de usuario modificado satisfactoriamente ");
		}
		return tipoUsuario;
 	}

 	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public TipoUsuarioResponse delete(@RequestBody TipoUsuarioRequest tu) {

		TipoUsuarioResponse tipoUsuarioResponse = new TipoUsuarioResponse();
		
		if (tipoUsuarioService.exists(tu.getTipo().getIdTipoUsuario()))
		{
			if(tipoUsuarioService.delete(tu.getTipo().getIdTipoUsuario()))
			{
				tipoUsuarioResponse.setCode(200);
				tipoUsuarioResponse.setCodeMessage("El tipo de usuario fue eliminado exitosamente");
			}
			else
			{
				tipoUsuarioResponse.setCode(500);
				tipoUsuarioResponse.setCodeMessage("Hubo un error al momento de eliminar el tipo de usuario");
			}
		}
		else
		{
			tipoUsuarioResponse.setCode(404);
			tipoUsuarioResponse.setCodeMessage("El tipo de usuario no existe");
		}

		return tipoUsuarioResponse;

	}
}