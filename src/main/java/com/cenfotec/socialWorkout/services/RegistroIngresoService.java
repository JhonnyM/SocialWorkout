package com.cenfotec.socialWorkout.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cenfotec.socialWorkout.contracts.RegistroIngresoRequest;
import com.cenfotec.socialWorkout.ejb.Registroingreso;
import com.cenfotec.socialWorkout.pojo.RegistroIngresoPOJO;
import com.cenfotec.socialWorkout.repositories.IngresoRepository;

@Service
public class RegistroIngresoService implements RegistroIngresoServiceInterface{
	
@Autowired private IngresoRepository ingresoRepository;

	@Override
	@Transactional
	public List<RegistroIngresoPOJO> getAllByFechaIngreso(RegistroIngresoRequest ir) {
		List<Registroingreso> ingresos =  ingresoRepository.findByFechaHoraIngreso(ir.getFechaIngreso());
		return generateIngresosDtos(ingresos);
	}
	
	private List<RegistroIngresoPOJO> generateIngresosDtos(List<Registroingreso> ingresos){
		List<RegistroIngresoPOJO> uiIngresos = new ArrayList<RegistroIngresoPOJO>();
		ingresos.stream().forEach(ingreso -> {
			RegistroIngresoPOJO dto = new RegistroIngresoPOJO();
			BeanUtils.copyProperties(ingreso,dto);
			uiIngresos.add(dto);
		});	
		return uiIngresos;
	}

	@Override
	@Transactional
	public List<RegistroIngresoPOJO> getAll(RegistroIngresoRequest ir) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Boolean saveIngreso(Registroingreso pingreso) {
		// TODO Auto-generated method stub
		return null;
	}

}
