package com.cenfotec.socialWorkout.controllers;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cenfotec.socialWorkout.contracts.PromedioOcupacionRequest;
import com.cenfotec.socialWorkout.contracts.PromedioOcupacionResponse;
import com.cenfotec.socialWorkout.ejb.Promedioocupacion;
import com.cenfotec.socialWorkout.pojo.LugarMedicionPOJO;
import com.cenfotec.socialWorkout.pojo.PromedioOcupacionPOJO;
import com.cenfotec.socialWorkout.pojo.RutinaHasUsuarioPOJO;
import com.cenfotec.socialWorkout.pojo.UnidadmedidaPOJO;
import com.cenfotec.socialWorkout.pojo.UsuarioPOJO;
import com.cenfotec.socialWorkout.services.PromedioOcupacionServiceInterface;
import com.cenfotec.socialWorkout.services.RutinaHasUsuarioServiceInterface;
import com.cenfotec.socialWorkout.services.UserServiceInterface;


/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping(value ="rest/protected/promedioOcupacion")
public class PromedioOcupacionController {
	
	@Autowired private PromedioOcupacionServiceInterface ocupacionService;
	@Autowired private RutinaHasUsuarioServiceInterface rutinaHasUsuarioService;
	@Autowired private UserServiceInterface usuarioService;
	@Autowired private HttpServletRequest request;
	
	
	@RequestMapping(value ="/getAll", method = RequestMethod.POST)
	public PromedioOcupacionResponse getAll(){	
		PromedioOcupacionResponse response = new PromedioOcupacionResponse();
		response.setCode(200);
		response.setCodeMessage("Tipo fetch success");
		response.setOcupacion(ocupacionService.getAll());
		return response;		
	}
	
	
	@RequestMapping(value ="/getDiaHoraUsuario", method = RequestMethod.POST)
	public PromedioOcupacionResponse getDia(){	
		PromedioOcupacionResponse response = new PromedioOcupacionResponse();
		response.setCode(200);
		response.setCodeMessage("Tipo fetch success");
		List<RutinaHasUsuarioPOJO> rutinas = new ArrayList<RutinaHasUsuarioPOJO>();
		LocalDate date=LocalDate.now();
		rutinas = null;
		rutinas = rutinaHasUsuarioService.getRutinaDia(date.getDayOfWeek()+"", usuarioService.getUsuarioSession());
		if(!(rutinas.isEmpty())){
			List<PromedioOcupacionPOJO>  promediosOcupacionPOJO= new ArrayList<PromedioOcupacionPOJO>();
			rutinas.stream().forEach(r -> {
				ocupacionService.getDia(date.getDayOfWeek()+"",r.getHora().getHours()).stream().forEach( o -> {
					PromedioOcupacionPOJO p = new PromedioOcupacionPOJO();
					BeanUtils.copyProperties(o, p);
					promediosOcupacionPOJO.add(p);
				});
			});
			response.setNulo(0);
			response.setOcupacion(promediosOcupacionPOJO);
		}else{
        response.setNulo(1);
		}
		return response;		
	}
	
	@RequestMapping(value ="/getDiaTotal", method = RequestMethod.POST)
	public PromedioOcupacionResponse getDiaTotal(){	
		PromedioOcupacionResponse response = new PromedioOcupacionResponse();
		response.setCode(200);
		response.setCodeMessage("Tipo fetch success");
		LocalDate date=LocalDate.now();
		List<PromedioOcupacionPOJO>  promediosOcupacionPOJO= new ArrayList<PromedioOcupacionPOJO>();
		ocupacionService.getDiaTotal(date.getDayOfWeek()+"").stream().forEach( o -> {
					PromedioOcupacionPOJO p = new PromedioOcupacionPOJO();
					BeanUtils.copyProperties(o, p);
					promediosOcupacionPOJO.add(p);
				});
		if(!(promediosOcupacionPOJO.isEmpty())){
		response.setNulo(0);
		response.setOcupacion(promediosOcupacionPOJO);
		}else{
		response.setNulo(1);	
		}
		return response;		
	}
}