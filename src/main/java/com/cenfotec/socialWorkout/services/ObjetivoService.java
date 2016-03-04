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
	public List<ObjetivoPOJO> getAll(ObjetivoRequest or) {
		List<Objetivo> objetivos =  objetivoRepository.findAll();
		return generateObjetivosDtos(objetivos);
	}

	private List<ObjetivoPOJO> generateObjetivosDtos(List<Objetivo> objetivos){
		List<ObjetivoPOJO> uiObjetivos = new ArrayList<ObjetivoPOJO>();
		objetivos.stream().forEach(u -> {
			ObjetivoPOJO dto = new ObjetivoPOJO();
			BeanUtils.copyProperties(u,dto);
			uiObjetivos.add(dto);
		});	
		return uiObjetivos;
	}

	@Override
	@Transactional
	public Boolean saveObjetivo(Objetivo objetivo) {
	BeanUtils.copyProperties(objetivo.getDescObjetivo(), objetivo);		
		Objetivo nTObjetivo = objetivoRepository.save(objetivo);		
		return (nTObjetivo == null) ? false : true;
	}
	
	@Override
	public ObjetivoPOJO getAllByIdObjetivo(Objetivo obj) {
		Objetivo objetivo;
		ObjetivoPOJO uiObjetivo = new ObjetivoPOJO();
		objetivo =  objetivoRepository.findOne(obj.getIdObjetivo());
		BeanUtils.copyProperties(obj,objetivo);
		BeanUtils.copyProperties(objetivo,uiObjetivo);
		return uiObjetivo;
	}
	
	@Override
	@Transactional
	public Boolean edit(Objetivo obj){
		ObjetivoPOJO objetivo = this.getAllByIdObjetivo(obj);
		Objetivo eObjetivo = new Objetivo();
		BeanUtils.copyProperties(objetivo,eObjetivo);
		Objetivo nObjetivo = objetivoRepository.save(eObjetivo);
		return (nObjetivo == null) ? false : true;

	}


}
