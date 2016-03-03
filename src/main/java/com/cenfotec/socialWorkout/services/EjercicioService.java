package com.cenfotec.socialWorkout.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.socialWorkout.contracts.EjercicioRequest;
import com.cenfotec.socialWorkout.ejb.Ejercicio;
import com.cenfotec.socialWorkout.ejb.Maquina;
import com.cenfotec.socialWorkout.pojo.EjercicioPOJO;
import com.cenfotec.socialWorkout.pojo.MaquinaPOJO;
import com.cenfotec.socialWorkout.repositories.EjercicioRepository;
import com.cenfotec.socialWorkout.repositories.MaquinaRepository;

@Service
public class EjercicioService implements EjercicioServiceInterface {

	@Autowired
	private EjercicioRepository ejercicioRepository;
	
	@Override
	public List<EjercicioPOJO> getAll(EjercicioRequest er) {
		List<Ejercicio> ejercicios = ejercicioRepository.findAll();
		return generateEjercicioDtos(ejercicios);
	}

	private List<EjercicioPOJO> generateEjercicioDtos(List<Ejercicio> ejercicios) {

		List<EjercicioPOJO> uiEjercicios = new ArrayList<EjercicioPOJO>();
		ejercicios.stream().forEach(e -> {
			EjercicioPOJO dto = new EjercicioPOJO();
			BeanUtils.copyProperties(e, dto);
			uiEjercicios.add(dto);
		});
		return uiEjercicios;
	}
	
	@Override
	@Transactional
	public Boolean saveEjercicio(Ejercicio e) {
	
		Ejercicio nejercicio = ejercicioRepository.save(e);
		
		return (nejercicio == null) ? false : true;

	}

}
