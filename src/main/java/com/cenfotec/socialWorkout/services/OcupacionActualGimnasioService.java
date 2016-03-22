package com.cenfotec.socialWorkout.services;

import java.beans.Beans;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cenfotec.socialWorkout.pojo.OcupacionActualGimnasioPOJO;
import com.cenfotec.socialWorkout.repositories.OcupacionActualGimnasioRepository;
import com.cenfotec.socialWorkout.utils.Utils;
import com.cenfotec.socialWorkout.ejb.Ocupacionactualgimnasio;

@Service
public class OcupacionActualGimnasioService implements OcupacionActualGimnasioServiceInterface {
	
@Autowired private OcupacionActualGimnasioRepository ocupacionActualGimnasioRepository;
	
	@Override
	@Transactional
	public List<OcupacionActualGimnasioPOJO> getAll() {
		List<Ocupacionactualgimnasio> ocupacion =  ocupacionActualGimnasioRepository.findAll();
		return generateOcupacionActualGimnasioDtos(ocupacion);
	}

	private List<OcupacionActualGimnasioPOJO> generateOcupacionActualGimnasioDtos(List<Ocupacionactualgimnasio> ocupacion){
		List<OcupacionActualGimnasioPOJO> uiOcupacion = new ArrayList<OcupacionActualGimnasioPOJO>();
		ocupacion.stream().forEach(u -> {
			OcupacionActualGimnasioPOJO dto = new OcupacionActualGimnasioPOJO();
			if (!(u==null)){
			BeanUtils.copyProperties(u,dto);
			}
			uiOcupacion.add(dto);
		});	
		return uiOcupacion;
	}

	
}
