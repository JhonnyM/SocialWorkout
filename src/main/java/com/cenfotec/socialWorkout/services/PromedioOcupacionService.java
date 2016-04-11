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
import com.cenfotec.socialWorkout.pojo.PromedioOcupacionPOJO;
import com.cenfotec.socialWorkout.repositories.PromedioOcupacionRepository;
import com.cenfotec.socialWorkout.ejb.Promedioocupacion;

@Service
public class PromedioOcupacionService implements PromedioOcupacionServiceInterface {
	
@Autowired private PromedioOcupacionRepository promedioOcupacionRepository;
	
	@Override
	@Transactional
	public List<PromedioOcupacionPOJO> getAll() {
		List<Promedioocupacion> ocupacion =  promedioOcupacionRepository.findAll();
		return generatePromedioOcupacionDtos(ocupacion);
	}

	private List<PromedioOcupacionPOJO> generatePromedioOcupacionDtos(List<Promedioocupacion> ocupacion){
		List<PromedioOcupacionPOJO> uiOcupacion = new ArrayList<PromedioOcupacionPOJO>();
		ocupacion.stream().forEach(u -> {
			PromedioOcupacionPOJO dto = new PromedioOcupacionPOJO();
			if (!(u==null)){
			BeanUtils.copyProperties(u,dto);
			}
			uiOcupacion.add(dto);
		});	
		return uiOcupacion;
	}

	@Override
	public List<PromedioOcupacionPOJO> getDia(String dia, int hora) {
		List<Promedioocupacion> ocupacion =  promedioOcupacionRepository.findByDiaAndHora(dia, hora);
		return generatePromedioOcupacionDtos(ocupacion);
	}

	@Override
	public List<PromedioOcupacionPOJO> getDiaTotal(String dia) {
		List<Promedioocupacion> ocupacion =  promedioOcupacionRepository.findByDia(dia);
		return generatePromedioOcupacionDtos(ocupacion);
	}

	
}
