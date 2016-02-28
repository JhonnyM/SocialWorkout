package com.cenfotec.socialWorkout.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cenfotec.socialWorkout.contracts.ParametroRequest;
import com.cenfotec.socialWorkout.ejb.Parametro;
import com.cenfotec.socialWorkout.pojo.ParametroPOJO;
import com.cenfotec.socialWorkout.repositories.ParametroRepository;

@Service
public class ParametroService implements ParametroServiceInterface{
	
@Autowired private ParametroRepository parametroRepository;
	
	
	@Override
	@Transactional
	public List<ParametroPOJO> getAll(ParametroRequest pr) {
		List<Parametro> parametros =  parametroRepository.findAll();
		return generateParametrosDtos(parametros);
	}
	
	@Override
	@Transactional
	public List<ParametroPOJO> getAllByName(ParametroRequest pr) {
		List<Parametro> parametros =  parametroRepository.findBynombreNegocio(pr.getNombreNegocio());
		return generateParametrosDtos(parametros);
		
	}
	
	private List<ParametroPOJO> generateParametrosDtos(List<Parametro> parametros){
		List<ParametroPOJO> uiParametros = new ArrayList<ParametroPOJO>();
		parametros.stream().forEach(param -> {
			ParametroPOJO dto = new ParametroPOJO();
			BeanUtils.copyProperties(param,dto);
			uiParametros.add(dto);
		});	
		return uiParametros;
	}
	
	@Override
	@Transactional
	public Boolean saveParametro(ParametroRequest pr) {
		Parametro parametro = new Parametro();
		BeanUtils.copyProperties(pr.getParametro(), parametro);
		Parametro newParam = parametroRepository.save(parametro);
		return (newParam == null) ? false : true;
		
	}
}
