package com.cenfotec.socialWorkout.services;
import com.cenfotec.socialWorkout.ejb.Objetivo;

import java.util.ArrayList;

import java.util.List;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cenfotec.socialWorkout.contracts.ObjetivoRequest;
import com.cenfotec.socialWorkout.ejb.Objetivo;
import com.cenfotec.socialWorkout.pojo.ObjetivoPOJO;
import com.cenfotec.socialWorkout.repositories.ObjetivoRepository;

@Service
public class ObjetivoService implements ObjetivoServiceInterface {
	
@Autowired private ObjetivoRepository objetivoRepository;
	
	@Override
	@Transactional
	public List<ObjetivoPOJO> getAll() {
		List<Objetivo> objetivos =  objetivoRepository.findAll();
		List<ObjetivoPOJO> dtos = new ArrayList<ObjetivoPOJO>();
		objetivos.stream().forEach(ta ->{
			ObjetivoPOJO dto = new ObjetivoPOJO();
			BeanUtils.copyProperties(ta, dto);
			dtos.add(dto);
		});
		return dtos;

	}
	
	@Override
	public Objetivo getObjetivoById(int idObjetivo) {
		return objetivoRepository.findOne(idObjetivo);
	}

	@Override
	@Transactional
	public Boolean saveObjetivo(Objetivo objetivo) {
	BeanUtils.copyProperties(objetivo.getDescObjetivo(), objetivo);		
		Objetivo nTObjetivo = objetivoRepository.save(objetivo);		
		return (nTObjetivo == null) ? false : true;
	}


}
