package com.cenfotec.socialWorkout.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cenfotec.socialWorkout.contracts.ClaseRequest;
import com.cenfotec.socialWorkout.ejb.Clase;
import com.cenfotec.socialWorkout.pojo.ClasePOJO;
import com.cenfotec.socialWorkout.repositories.ClaseRepository;



@Service
public class ClaseService implements ClaseServiceInterface{

	@Autowired private ClaseRepository claseRepository;
	

	@Override
	@Transactional
	public List<ClasePOJO> getAll() {		
		List<Clase> clases = claseRepository.findAll();
		List<ClasePOJO> dtos = new ArrayList<ClasePOJO>();
		clases.stream().forEach(ta ->{
			ClasePOJO dto = new ClasePOJO();
			BeanUtils.copyProperties(ta, dto);
			dtos.add(dto);
			
		});
		return dtos;	
	}
	
	@Override
	public ClasePOJO getById(ClaseRequest request) {
		ClasePOJO cla = new ClasePOJO();
		Clase clase = claseRepository.findOne(request.getClase().getIdClase());
		
		if(clase != null)
		{
			BeanUtils.copyProperties(clase, cla);
		}
		return cla;
	}

	@Override
	public boolean save (ClaseRequest request){
		ClasePOJO eventoDTO = request.getClase();
		Clase clase = new Clase();
		BeanUtils.copyProperties(eventoDTO, clase);
		Clase s = claseRepository.save(clase);
		return !(s == null);
		
	}
	
	@Override
	public boolean exists (Integer idClase){		
		return claseRepository.exists(idClase);		
	}

	@Override
	public boolean delete(int idClase) {	
		claseRepository.delete(idClase);
		return !claseRepository.exists(idClase);
	}
}