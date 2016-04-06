package com.cenfotec.socialWorkout.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cenfotec.socialWorkout.contracts.PlantillarutinadetalleRequest;
import com.cenfotec.socialWorkout.ejb.Maquinahasejercicio;
import com.cenfotec.socialWorkout.ejb.Plantillarutinadetalle;
import com.cenfotec.socialWorkout.ejb.Plantillarutinamaestro;
import com.cenfotec.socialWorkout.pojo.MaquinahasejercicioPOJO;
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
			MaquinahasejercicioPOJO relationDto = new MaquinahasejercicioPOJO();
			Maquinahasejercicio relation = ta.getMaquinahasejercicio();
			BeanUtils.copyProperties(relation, relationDto);
			BeanUtils.copyProperties(ta, dto);
			dto.setMaquinahasejercicio(relationDto);
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
		Maquinahasejercicio relation = new Maquinahasejercicio();
		MaquinahasejercicioPOJO relationDto = request.getPlantillaRutinaDetalle().getMaquinahasejercicio();
		BeanUtils.copyProperties(relationDto, relation);
		BeanUtils.copyProperties(plantillaDTO, plantilla);
		BeanUtils.copyProperties(plantillaMaestroDTO, plantillaMaestro);
		plantilla.setPlantillarutinamaestro(plantillaMaestro);
		plantilla.setMaquinahasejercicio(relation);
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