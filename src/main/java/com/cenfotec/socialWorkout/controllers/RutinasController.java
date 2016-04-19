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

import com.cenfotec.socialWorkout.contracts.PlantillarutinamaestroResponse;
import com.cenfotec.socialWorkout.contracts.PlantillarutinadetalleRequest;
import com.cenfotec.socialWorkout.contracts.PlantillarutinadetalleResponse;
import com.cenfotec.socialWorkout.contracts.PromedioOcupacionRequest;
import com.cenfotec.socialWorkout.contracts.PromedioOcupacionResponse;
import com.cenfotec.socialWorkout.contracts.RutinaHasUsuarioRequest;
import com.cenfotec.socialWorkout.contracts.RutinaHasUsuarioResponse;
import com.cenfotec.socialWorkout.contracts.TipoUsuarioRequest;
import com.cenfotec.socialWorkout.contracts.TipoUsuarioResponse;
import com.cenfotec.socialWorkout.contracts.UserRequest;
import com.cenfotec.socialWorkout.ejb.Promedioocupacion;
import com.cenfotec.socialWorkout.pojo.LugarMedicionPOJO;
import com.cenfotec.socialWorkout.pojo.PlantillarutinadetallePOJO;
import com.cenfotec.socialWorkout.pojo.PlantillarutinamaestroPOJO;
import com.cenfotec.socialWorkout.pojo.PromedioOcupacionPOJO;
import com.cenfotec.socialWorkout.pojo.RutinaHasUsuarioPOJO;
import com.cenfotec.socialWorkout.pojo.UnidadmedidaPOJO;
import com.cenfotec.socialWorkout.pojo.UsuarioPOJO;
import com.cenfotec.socialWorkout.services.PlantillarutinadetalleServiceInterface;
import com.cenfotec.socialWorkout.services.PlantillarutinamaestroServiceInterface;
import com.cenfotec.socialWorkout.services.PromedioOcupacionServiceInterface;
import com.cenfotec.socialWorkout.services.RutinaHasUsuarioServiceInterface;
import com.cenfotec.socialWorkout.services.UserServiceInterface;


/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping(value ="rest/protected/rutinas")
public class RutinasController {
	
	@Autowired private PromedioOcupacionServiceInterface ocupacionService;
	@Autowired private RutinaHasUsuarioServiceInterface rutinaHasUsuarioService;
	@Autowired private PlantillarutinadetalleServiceInterface plantillaDetalleService;
	@Autowired private PlantillarutinamaestroServiceInterface plantillaMaestroService;
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
	
	@RequestMapping(value ="/getEjerciciosXRutina", method = RequestMethod.POST)
	public PlantillarutinadetalleResponse getEjerciciosXRutina(@RequestBody PlantillarutinadetalleRequest ur){	
		PlantillarutinadetalleResponse response = new PlantillarutinadetalleResponse();
		response.setCode(200);
		response.setCodeMessage("Tipo fetch success");
		List<PlantillarutinadetallePOJO> listaEjercicios = new ArrayList<PlantillarutinadetallePOJO>();
		listaEjercicios = plantillaDetalleService.getPlantillaRutinaDetalleXIdRutina(ur.getPlantillaRutinaDetalle().getPlantillarutinamaestro().getIdRutina());
		response.setPlantillasDetalle(listaEjercicios);
		return response;		
	}
	
	@RequestMapping(value ="/asignarNuevaRutina", method = RequestMethod.POST)
	public RutinaHasUsuarioResponse edit(@RequestBody RutinaHasUsuarioRequest rutinaHasUsuarioRequest){	
 		
		RutinaHasUsuarioResponse rutinaHasUsuario = new RutinaHasUsuarioResponse();
		List<RutinaHasUsuarioPOJO> rutinas = new ArrayList<RutinaHasUsuarioPOJO>();
		LocalDate date=LocalDate.now();
		rutinas = null;
		rutinas = rutinaHasUsuarioService.getRutinaWithPlantilla(date.getDayOfWeek()+"", usuarioService.getUsuarioSession());
		Boolean state = rutinaHasUsuarioService.actualizaRutinaTemporal(rutinas.get(0).getIdRegistroRutinaXUsuario() ,
				rutinaHasUsuarioRequest.getRutinaHasUsuarioPOJO().getTemporal());
	    if(state){
			rutinaHasUsuario.setCode(200);
			rutinaHasUsuario.setCodeMessage("Tipo de usuario modificado satisfactoriamente ");
		}
		return rutinaHasUsuario;
 	}
	
	@RequestMapping(value ="/getRutinasDia", method = RequestMethod.POST)
	public RutinaHasUsuarioResponse getRutinasDia(){	
		RutinaHasUsuarioResponse response = new RutinaHasUsuarioResponse();
		response.setCode(200);
		response.setCodeMessage("Tipo fetch success");
		List<RutinaHasUsuarioPOJO> rutinas = new ArrayList<RutinaHasUsuarioPOJO>();
		LocalDate date=LocalDate.now();
		rutinas = null;
		rutinas = rutinaHasUsuarioService.getRutinaWithPlantilla(date.getDayOfWeek()+"", usuarioService.getUsuarioSession());
		if(!(rutinas.isEmpty())){
			response.setNulo(0);
			response.setRutinasHasUsuarioPOJO(rutinas);
		}else{
        response.setNulo(1);
		}
		return response;		
	}
	
	@RequestMapping(value ="/getRutinasUsuario", method = RequestMethod.POST)
	public RutinaHasUsuarioResponse getRutinasUsuario(){	
		RutinaHasUsuarioResponse response = new RutinaHasUsuarioResponse();
		response.setCode(200);
		response.setCodeMessage("Tipo fetch success");
		List<RutinaHasUsuarioPOJO> rutinas = new ArrayList<RutinaHasUsuarioPOJO>();
		LocalDate date=LocalDate.now();
		rutinas = null;
		rutinas = rutinaHasUsuarioService. getRutinaWithPlantillaUsuario(usuarioService.getUsuarioSession());
		if(!(rutinas.isEmpty())){
			response.setNulo(0);
			response.setRutinasHasUsuarioPOJO(rutinas);
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