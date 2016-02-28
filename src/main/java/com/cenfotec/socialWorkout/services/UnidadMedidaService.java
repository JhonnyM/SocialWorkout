package com.cenfotec.socialWorkout.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.cenfotec.socialWorkout.contracts.UnidadMedidaRequest;
import com.cenfotec.socialWorkout.ejb.Unidadmedida;
import com.cenfotec.socialWorkout.pojo.UnidadmedidaPOJO;
import com.cenfotec.socialWorkout.repositories.UnidadMedidaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class UnidadMedidaService implements UnidadMedidaServiceInterface {
	
	@Autowired UnidadMedidaRepository unidadMedidaRepository;

	@Override
	public List<UnidadmedidaPOJO> getAllByIdUnidadMedida(UnidadMedidaRequest umr) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<UnidadmedidaPOJO> getAllByDescUnidadMedida(UnidadMedidaRequest umr) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<UnidadmedidaPOJO> getAll(UnidadMedidaRequest umr) {
		List<Unidadmedida> unidadesMedidas =  unidadMedidaRepository.findAll();
		return generateUnidadmedidaDtos(unidadesMedidas);
	}

	private List<UnidadmedidaPOJO> generateUnidadmedidaDtos(List<Unidadmedida> unidadesMedidas){
		List<UnidadmedidaPOJO> uiUnidadesMedidas = new ArrayList<UnidadmedidaPOJO>();
		unidadesMedidas.stream().forEach(um -> {
			UnidadmedidaPOJO dto = new UnidadmedidaPOJO();
			BeanUtils.copyProperties(um,dto);
			uiUnidadesMedidas.add(dto);
		});	
		return uiUnidadesMedidas;
	}



}
