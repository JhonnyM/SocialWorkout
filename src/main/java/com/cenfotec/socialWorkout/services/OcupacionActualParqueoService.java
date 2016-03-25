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
import com.cenfotec.socialWorkout.pojo.OcupacionActualParqueoPOJO;
import com.cenfotec.socialWorkout.repositories.OcupacionActualParqueoRepository;
import com.cenfotec.socialWorkout.utils.Utils;
import com.cenfotec.socialWorkout.ejb.Ocupacionactualparqueo;

@Service
public class OcupacionActualParqueoService implements OcupacionActualParqueoServiceInterface {
	
@Autowired private OcupacionActualParqueoRepository ocupacionActualParqueoRepository;
	
	@Override
	@Transactional
	public List<OcupacionActualParqueoPOJO> getAll() {
		List<Ocupacionactualparqueo> ocupacion =  ocupacionActualParqueoRepository.findAll();
		return generateOcupacionActualParqueoDtos(ocupacion);
	}

	private List<OcupacionActualParqueoPOJO> generateOcupacionActualParqueoDtos(List<Ocupacionactualparqueo> ocupacion){
		List<OcupacionActualParqueoPOJO> uiOcupacion = new ArrayList<OcupacionActualParqueoPOJO>();
		ocupacion.stream().forEach(u -> {
			OcupacionActualParqueoPOJO dto = new OcupacionActualParqueoPOJO();
			if (!(u==null)){
			BeanUtils.copyProperties(u,dto);
			}
			uiOcupacion.add(dto);
		});	
		return uiOcupacion;
	}

	
}
