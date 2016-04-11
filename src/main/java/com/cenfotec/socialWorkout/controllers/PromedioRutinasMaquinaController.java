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
import com.cenfotec.socialWorkout.contracts.PromedioRutinasMaquinaResponse;
import com.cenfotec.socialWorkout.ejb.Promedioocupacion;
import com.cenfotec.socialWorkout.pojo.LugarMedicionPOJO;
import com.cenfotec.socialWorkout.pojo.MaquinaPOJO;
import com.cenfotec.socialWorkout.pojo.MaquinahasejercicioPOJO;
import com.cenfotec.socialWorkout.pojo.PlantillarutinadetallePOJO;
import com.cenfotec.socialWorkout.pojo.PromedioOcupacionPOJO;
import com.cenfotec.socialWorkout.pojo.PromedioRutinasMaquinaPOJO;
import com.cenfotec.socialWorkout.pojo.RutinaHasUsuarioPOJO;
import com.cenfotec.socialWorkout.pojo.UnidadmedidaPOJO;
import com.cenfotec.socialWorkout.pojo.UsuarioPOJO;
import com.cenfotec.socialWorkout.services.MaquinahasejercicioServiceInterface;
import com.cenfotec.socialWorkout.services.PlantillarutinadetalleServiceInterface;
import com.cenfotec.socialWorkout.services.PromedioOcupacionServiceInterface;
import com.cenfotec.socialWorkout.services.PromedioRutinasMaquinaServiceInterface;
import com.cenfotec.socialWorkout.services.RutinaHasUsuarioServiceInterface;
import com.cenfotec.socialWorkout.services.UserServiceInterface;


/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping(value ="rest/protected/promedioRutinasMaquina")
public class PromedioRutinasMaquinaController {
	
	@Autowired private PromedioRutinasMaquinaServiceInterface ocupacionMaquinaService;
	@Autowired private RutinaHasUsuarioServiceInterface rutinaHasUsuarioService;
	@Autowired private PlantillarutinadetalleServiceInterface plantillaRutinaDetalleService;
	@Autowired private MaquinahasejercicioServiceInterface maquinaHasEjercicioService;
	@Autowired private UserServiceInterface usuarioService;
	@Autowired private HttpServletRequest request;
	
	
	@RequestMapping(value ="/getAll", method = RequestMethod.POST)
	public PromedioRutinasMaquinaResponse getAll(){	
		PromedioRutinasMaquinaResponse response = new PromedioRutinasMaquinaResponse();
		response.setCode(200);
		response.setCodeMessage("Tipo fetch success");
		response.setOcupacion(ocupacionMaquinaService.getAll());
		return response;		
	}
	
	
	@RequestMapping(value ="/getMaquinasUsuario", method = RequestMethod.POST)
	public PromedioRutinasMaquinaResponse getDia(){	
		PromedioRutinasMaquinaResponse response = new PromedioRutinasMaquinaResponse();
		response.setCode(200);
		response.setCodeMessage("Tipo fetch success");
		List<RutinaHasUsuarioPOJO> rutinas = new ArrayList<RutinaHasUsuarioPOJO>();
		List<PromedioRutinasMaquinaPOJO>  promediosRutinasMaquinaPOJO= new ArrayList<PromedioRutinasMaquinaPOJO>();	
		LocalDate date=LocalDate.now();
		rutinas = null;
		rutinas = rutinaHasUsuarioService.getRutinaWithPlantilla(date.getDayOfWeek()+"", usuarioService.getUsuarioSession());
		if(!(rutinas.isEmpty())){
			rutinas.stream().forEach(r -> {
				List<PlantillarutinadetallePOJO> listaIdEjerciciosXMaquina= new ArrayList<PlantillarutinadetallePOJO>();
				listaIdEjerciciosXMaquina = plantillaRutinaDetalleService.getPlantillaRutinaDetalleXIdRutina(r.getPlantillarutinamaestroPOJO().getIdRutina());
					listaIdEjerciciosXMaquina.stream().forEach(l -> {
						PromedioRutinasMaquinaPOJO  ocupacionMaquina = new PromedioRutinasMaquinaPOJO();
						 		MaquinaPOJO maqPOJO = new MaquinaPOJO();
						 		maqPOJO = l.getMaquinahasejercicio().getMaquinaPOJO();
    					 		ocupacionMaquina = ocupacionMaquinaService.getOcupacionXDiaHoraMaquina(maqPOJO.getIdMaquina(),date.getDayOfWeek()+"",r.getHora().getHours());
						 		promediosRutinasMaquinaPOJO.add(ocupacionMaquina);
					});
				});
			response.setNulo(0);
			response.setOcupacion(promediosRutinasMaquinaPOJO);
		}else{
        response.setNulo(1);
		}
		return response;		
	}
	
	@RequestMapping(value ="/getDiaTotal", method = RequestMethod.POST)
	public PromedioRutinasMaquinaResponse getDiaTotal(){	
		PromedioRutinasMaquinaResponse response = new PromedioRutinasMaquinaResponse();
		response.setCode(200);
		response.setCodeMessage("Tipo fetch success");
		LocalDate date=LocalDate.now();
		List<PromedioRutinasMaquinaPOJO>  promediosRutinasMaquinaPOJO= new ArrayList<PromedioRutinasMaquinaPOJO>();	
        promediosRutinasMaquinaPOJO = ocupacionMaquinaService.getOcupacionXDiaTotal(date.getDayOfWeek()+"");
        if(!(promediosRutinasMaquinaPOJO.isEmpty())){
			response.setNulo(0);
			response.setOcupacion(promediosRutinasMaquinaPOJO);
		}else{
        response.setNulo(1);
		}
		return response;		
	}
}