package com.cenfotec.socialWorkout.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cenfotec.socialWorkout.contracts.PlantillarutinadetalleRequest;
import com.cenfotec.socialWorkout.ejb.Plantillarutinadetalle;
import com.cenfotec.socialWorkout.ejb.Plantillarutinamaestro;
import com.cenfotec.socialWorkout.pojo.PlantillarutinadetallePOJO;
import com.cenfotec.socialWorkout.pojo.PlantillarutinamaestroPOJO;
import com.cenfotec.socialWorkout.repositories.PlantillarutinadetalleRepository;
import com.cenfotec.socialWorkout.repositories.PlantillarutinamaestroRepository;



@Service
public class PlantillarutinadetalleService implements PlantillarutinadetalleServiceInterface{

	@Autowired private PlantillarutinadetalleRepository plantillaRutinaDetalle;
	
	

	@Override
	@Transactional
	public List<PlantillarutinadetallePOJO> getAll() {		
		List<Plantillarutinadetalle> plantillaRutina = plantillaRutinaDetalle.findAll();
		List<PlantillarutinadetallePOJO> dtos = new ArrayList<PlantillarutinadetallePOJO>();
		plantillaRutina.stream().forEach(ta ->{
			PlantillarutinadetallePOJO dto = new PlantillarutinadetallePOJO();
			BeanUtils.copyProperties(ta, dto);
			dtos.add(dto);
			
		});
		return dtos;	
	}

	@Override
	public boolean save (PlantillarutinadetalleRequest request){
		PlantillarutinadetallePOJO plantillaDTO = request.getPlantillaRutinaDetalle();
		Plantillarutinadetalle plantilla = new Plantillarutinadetalle();
		PlantillarutinamaestroPOJO plantillaMaestroDTO = request.getPlantillaRutinaDetalle().getPlantillarutinamaestro();
		Plantillarutinamaestro plantillaMaestro = new Plantillarutinamaestro();
		BeanUtils.copyProperties(plantillaDTO, plantilla);
		BeanUtils.copyProperties(plantillaMaestroDTO, plantillaMaestro);
		plantilla.setPlantillarutinamaestro(plantillaMaestro);
		Plantillarutinadetalle s = plantillaRutinaDetalle.save(plantilla);
		return !(s == null);
		
	}
	
	@Override
	public boolean exists (Integer idPlantilla){		
		return plantillaRutinaDetalle.exists(idPlantilla);		
	}

	@Override
	public boolean delete(Integer idPlantilla) {	
		plantillaRutinaDetalle.delete(idPlantilla);
		return !plantillaRutinaDetalle.exists(idPlantilla);
	}
}