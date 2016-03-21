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
import com.cenfotec.socialWorkout.pojo.PromedioOcupacionParqueoPOJO;
import com.cenfotec.socialWorkout.repositories.PromedioOcupacionParqueoRepository;
import com.cenfotec.socialWorkout.ejb.Promedioocupacionparqueo;

@Service
public class PromedioOcupacionParqueoService implements PromedioOcupacionParqueoServiceInterface {
	
@Autowired private PromedioOcupacionParqueoRepository promedioOcupacionParqueoRepository;
	
	@Override
	@Transactional
	public List<PromedioOcupacionParqueoPOJO> getAll() {
		List<Promedioocupacionparqueo> ocupacion =  promedioOcupacionParqueoRepository.findAll();
		return generatePromedioOcupacionParqueoDtos(ocupacion);
	}

	private List<PromedioOcupacionParqueoPOJO> generatePromedioOcupacionParqueoDtos(List<Promedioocupacionparqueo> ocupacion){
		List<PromedioOcupacionParqueoPOJO> uiOcupacion = new ArrayList<PromedioOcupacionParqueoPOJO>();
		ocupacion.stream().forEach(u -> {
			PromedioOcupacionParqueoPOJO dto = new PromedioOcupacionParqueoPOJO();
			if (!(u==null)){
			BeanUtils.copyProperties(u,dto);
			}
			uiOcupacion.add(dto);
		});	
		return uiOcupacion;
	}

	
}