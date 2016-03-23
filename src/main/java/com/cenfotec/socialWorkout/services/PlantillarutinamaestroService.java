package com.cenfotec.socialWorkout.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cenfotec.socialWorkout.contracts.PlantillarutinamaestroRequest;
import com.cenfotec.socialWorkout.ejb.Plantillarutinamaestro;
import com.cenfotec.socialWorkout.pojo.PlantillarutinamaestroPOJO;
import com.cenfotec.socialWorkout.repositories.PlantillarutinamaestroRepository;



@Service
public class PlantillarutinamaestroService implements PlantillarutinamaestroServiceInterface{

	@Autowired private PlantillarutinamaestroRepository plantillaMaestroRepository;
	

	@Override
	@Transactional
	public List<PlantillarutinamaestroPOJO> getAll() {		
		List<Plantillarutinamaestro> plantillaRutina = plantillaMaestroRepository.findAll();
		List<PlantillarutinamaestroPOJO> dtos = new ArrayList<PlantillarutinamaestroPOJO>();
		plantillaRutina.stream().forEach(ta ->{
			PlantillarutinamaestroPOJO dto = new PlantillarutinamaestroPOJO();
			BeanUtils.copyProperties(ta, dto);
			dtos.add(dto);
			
		});
		return dtos;	
	}

	@Override
	public boolean save (PlantillarutinamaestroRequest request){
		PlantillarutinamaestroPOJO plantillaDTO = request.getPlantillaRutinaMaestro();
		Plantillarutinamaestro plantilla = new Plantillarutinamaestro();
		BeanUtils.copyProperties(plantillaDTO, plantilla);
		Plantillarutinamaestro s = plantillaMaestroRepository.save(plantilla);
		return !(s == null);
		
	}
	
	@Override
	public boolean exists (Integer idPlantilla){		
		return plantillaMaestroRepository.exists(idPlantilla);		
	}

	@Override
	public boolean delete(Integer idPlantilla) {	
		plantillaMaestroRepository.delete(idPlantilla);
		return !plantillaMaestroRepository.exists(idPlantilla);
	}
}