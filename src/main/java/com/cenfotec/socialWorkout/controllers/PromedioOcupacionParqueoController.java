package com.cenfotec.socialWorkout.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cenfotec.socialWorkout.contracts.PromedioOcupacionParqueoRequest;
import com.cenfotec.socialWorkout.contracts.PromedioOcupacionParqueoResponse;
import com.cenfotec.socialWorkout.contracts.PromedioOcupacionResponse;
import com.cenfotec.socialWorkout.pojo.PromedioOcupacionPOJO;
import com.cenfotec.socialWorkout.pojo.PromedioOcupacionParqueoPOJO;
import com.cenfotec.socialWorkout.pojo.RutinaHasUsuarioPOJO;
import com.cenfotec.socialWorkout.services.PromedioOcupacionParqueoServiceInterface;
import com.cenfotec.socialWorkout.services.RutinaHasUsuarioServiceInterface;
import com.cenfotec.socialWorkout.services.UserServiceInterface;
 

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping(value ="rest/protected/promedioOcupacionParqueo")
public class PromedioOcupacionParqueoController {
	
	@Autowired private PromedioOcupacionParqueoServiceInterface ocupacionService;
	@Autowired private RutinaHasUsuarioServiceInterface rutinaHasUsuarioService;
	@Autowired private UserServiceInterface usuarioService;
	@Autowired private HttpServletRequest request;
	
	@RequestMapping(value ="/getAll", method = RequestMethod.POST)
	public PromedioOcupacionParqueoResponse getAll(){	
		PromedioOcupacionParqueoResponse response = new PromedioOcupacionParqueoResponse();
		response.setCode(200);
		response.setCodeMessage("Tipo fetch success");
		response.setOcupacion(ocupacionService.getAll());
		return response;		
	}
	
	@RequestMapping(value ="/getDiaHoraUsuario", method = RequestMethod.POST)
	public PromedioOcupacionParqueoResponse getDia(){	
		PromedioOcupacionParqueoResponse response = new PromedioOcupacionParqueoResponse();
		response.setCode(200);
		response.setCodeMessage("Tipo fetch success");
		List<RutinaHasUsuarioPOJO> rutinas = new ArrayList<RutinaHasUsuarioPOJO>();
		LocalDate date=LocalDate.now();
		rutinas = null;
		rutinas = rutinaHasUsuarioService.getRutinaDia(date.getDayOfWeek()+"", usuarioService.getUsuarioSession());
		if(!(rutinas.isEmpty())){
			List<PromedioOcupacionParqueoPOJO>  promediosOcupacionParqueoPOJO= new ArrayList<PromedioOcupacionParqueoPOJO>();
			rutinas.stream().forEach(r -> {
				ocupacionService.getDia(date.getDayOfWeek()+"",r.getHora().getHours()).stream().forEach( o -> {
					PromedioOcupacionParqueoPOJO p = new PromedioOcupacionParqueoPOJO();
					BeanUtils.copyProperties(o, p);
					promediosOcupacionParqueoPOJO.add(p);
				});
			});
			response.setNulo(0);
			response.setOcupacion(promediosOcupacionParqueoPOJO);
		}else{
        response.setNulo(1);
		}
		return response;		
	}
	
	@RequestMapping(value ="/getDiaTotal", method = RequestMethod.POST)
	public PromedioOcupacionParqueoResponse getDiaTotal(){	
		PromedioOcupacionParqueoResponse response = new PromedioOcupacionParqueoResponse();
		response.setCode(200);
		response.setCodeMessage("Tipo fetch success");
		LocalDate date=LocalDate.now();
		List<PromedioOcupacionParqueoPOJO>  promediosOcupacionParqueoPOJO= new ArrayList<PromedioOcupacionParqueoPOJO>();
		ocupacionService.getDiaTotal(date.getDayOfWeek()+"").stream().forEach( o -> {
					PromedioOcupacionParqueoPOJO p = new PromedioOcupacionParqueoPOJO();
					BeanUtils.copyProperties(o, p);
					promediosOcupacionParqueoPOJO.add(p);
				});
		if(!(promediosOcupacionParqueoPOJO.isEmpty())){
		response.setNulo(0);
		response.setOcupacion(promediosOcupacionParqueoPOJO);
		}else{
		response.setNulo(1);	
		}
		return response;		
	}
}