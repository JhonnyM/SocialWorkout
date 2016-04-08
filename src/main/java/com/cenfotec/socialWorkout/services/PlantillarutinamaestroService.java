package com.cenfotec.socialWorkout.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cenfotec.socialWorkout.contracts.PlantillarutinamaestroRequest;
import com.cenfotec.socialWorkout.ejb.Maquinahasejercicio;
import com.cenfotec.socialWorkout.ejb.Objetivo;
import com.cenfotec.socialWorkout.ejb.Plantillarutinadetalle;
import com.cenfotec.socialWorkout.ejb.Plantillarutinamaestro;
import com.cenfotec.socialWorkout.pojo.MaquinahasejercicioPOJO;
import com.cenfotec.socialWorkout.pojo.ObjetivoPOJO;
import com.cenfotec.socialWorkout.pojo.PlantillarutinadetallePOJO;
import com.cenfotec.socialWorkout.pojo.PlantillarutinamaestroPOJO;
import com.cenfotec.socialWorkout.repositories.PlantillarutinadetalleRepository;
import com.cenfotec.socialWorkout.repositories.PlantillarutinamaestroRepository;



@Service
public class PlantillarutinamaestroService implements PlantillarutinamaestroServiceInterface{

	@Autowired private PlantillarutinamaestroRepository plantillaMaestroRepository;
	@Autowired private PlantillarutinadetalleRepository plantillaDetalleRepository;
	

	@Override
	@Transactional
	public List<PlantillarutinamaestroPOJO> getAll() {		
		List<Plantillarutinamaestro> plantillaRutina = plantillaMaestroRepository.findAll();
		List<PlantillarutinamaestroPOJO> dtos = new ArrayList<PlantillarutinamaestroPOJO>();
		
		plantillaRutina.stream().forEach(ta ->{
			PlantillarutinamaestroPOJO dto = new PlantillarutinamaestroPOJO();
			List<PlantillarutinadetallePOJO> detalledtos = new ArrayList<PlantillarutinadetallePOJO>();
			List<Plantillarutinadetalle> plantillasRutinaDetalle = plantillaDetalleRepository.findByplantillarutinamaestro(ta);
			plantillasRutinaDetalle.stream().forEach(rd -> {
				PlantillarutinadetallePOJO detallePOJO = new PlantillarutinadetallePOJO();
				MaquinahasejercicioPOJO relationDto = new MaquinahasejercicioPOJO();
				Maquinahasejercicio relation = rd.getMaquinahasejercicio();
				BeanUtils.copyProperties(rd,detallePOJO);
				BeanUtils.copyProperties(relation,relationDto);
				detallePOJO.setMaquinahasejercicio(relationDto);
				detalledtos.add(detallePOJO);
			});
			Objetivo objetivo = ta.getObjetivo();
			ObjetivoPOJO objDto = new ObjetivoPOJO();
			BeanUtils.copyProperties(objetivo,objDto);
			BeanUtils.copyProperties(ta, dto);
			dto.setPlantillarutinadetalles(detalledtos);
			dto.setObjetivo(objDto);
			dtos.add(dto);
			
		});
		return dtos;	
	}

	@Override
	public boolean save (PlantillarutinamaestroRequest request){
		PlantillarutinamaestroPOJO plantillaDTO = request.getPlantillaRutinaMaestro();
		Plantillarutinamaestro plantilla = new Plantillarutinamaestro();
		ObjetivoPOJO objetivoDTO = request.getPlantillaRutinaMaestro().getObjetivo();
		Objetivo objetivo = new Objetivo();
		BeanUtils.copyProperties(objetivoDTO, objetivo);
		BeanUtils.copyProperties(plantillaDTO, plantilla);
		plantilla.setObjetivo(objetivo);
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