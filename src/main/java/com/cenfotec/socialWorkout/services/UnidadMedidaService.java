package com.cenfotec.socialWorkout.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.cenfotec.socialWorkout.contracts.UnidadMedidaRequest;
import com.cenfotec.socialWorkout.ejb.Unidadmedida;
import com.cenfotec.socialWorkout.ejb.Usuario;
import com.cenfotec.socialWorkout.pojo.UnidadmedidaPOJO;
import com.cenfotec.socialWorkout.repositories.UnidadMedidaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnidadMedidaService implements UnidadMedidaServiceInterface {
	
	@Autowired private UnidadMedidaRepository unidadMedidaRepository;
	
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

	@Override
	@Transactional
	public Boolean saveUnidadMedida(Unidadmedida um) {
	
		Unidadmedida nunidad = unidadMedidaRepository.save(um);
		
		return (nunidad == null) ? false : true;

	}

	@Override
	public UnidadmedidaPOJO getAllByIdUnidadMedida(Unidadmedida um) {

		Unidadmedida unidadMedida;
		UnidadmedidaPOJO uiUnidadMedida = new UnidadmedidaPOJO();
		
		unidadMedida =  unidadMedidaRepository.findOne(um.getIdUnidadMedida());

		BeanUtils.copyProperties(um,unidadMedida);

		BeanUtils.copyProperties(unidadMedida,uiUnidadMedida);
		
		return uiUnidadMedida;
	}

	@Transactional
	public Boolean editUnidadMedida(Unidadmedida um){
		
		UnidadmedidaPOJO unidadMedida = this.getAllByIdUnidadMedida(um);

		Unidadmedida eUnidadMedida = new Unidadmedida();

		BeanUtils.copyProperties(unidadMedida,eUnidadMedida);
	
		Unidadmedida nunidad = unidadMedidaRepository.save(eUnidadMedida);
		
		return (nunidad == null) ? false : true;

	}

}
