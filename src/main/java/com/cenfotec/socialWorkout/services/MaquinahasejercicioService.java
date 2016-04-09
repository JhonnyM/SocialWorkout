package com.cenfotec.socialWorkout.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.socialWorkout.contracts.MaquinahasejercicioRequest;
import com.cenfotec.socialWorkout.ejb.Maquinahasejercicio;
import com.cenfotec.socialWorkout.pojo.MaquinahasejercicioPOJO;
import com.cenfotec.socialWorkout.repositories.MaquinahasejercicioRepository;

@Service
public class MaquinahasejercicioService implements MaquinahasejercicioServiceInterface {

	@Autowired
	private MaquinahasejercicioRepository maquinaHasEjercicioRepository;

	@Override
	@Transactional
	public List<MaquinahasejercicioPOJO> getAll() {		
		List<Maquinahasejercicio> relationList = maquinaHasEjercicioRepository.findAll();
		List<MaquinahasejercicioPOJO> dtos = new ArrayList<MaquinahasejercicioPOJO>();
		relationList.stream().forEach(ta ->{
			MaquinahasejercicioPOJO dto = new MaquinahasejercicioPOJO();
			BeanUtils.copyProperties(ta, dto);
			dtos.add(dto);
			
		});
		return dtos;	
	}

	@Override
	public boolean save (MaquinahasejercicioRequest request){
		MaquinahasejercicioPOJO eventoDTO = request.getMaquinaEjercicio();
		Maquinahasejercicio relation = new Maquinahasejercicio();
		BeanUtils.copyProperties(eventoDTO, relation);
		Maquinahasejercicio s = maquinaHasEjercicioRepository.save(relation);
		return !(s == null);
		
	}
	
	@Override
	public boolean exists (Integer idRelation){		
		return maquinaHasEjercicioRepository.exists(idRelation);		
	}

	@Override
	public boolean delete(int idRelation) {	
		maquinaHasEjercicioRepository.delete(idRelation);
		return !maquinaHasEjercicioRepository.exists(idRelation);
	}

}
