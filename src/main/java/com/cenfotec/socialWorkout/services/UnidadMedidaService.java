package com.cenfotec.socialWorkout.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.cenfotec.socialWorkout.contracts.UnidadMedidaRequest;
import com.cenfotec.socialWorkout.ejb.Maquina;
import com.cenfotec.socialWorkout.ejb.Unidadmedida;
import com.cenfotec.socialWorkout.ejb.Usuario;
import com.cenfotec.socialWorkout.pojo.MaquinaPOJO;
import com.cenfotec.socialWorkout.pojo.UnidadmedidaPOJO;
import com.cenfotec.socialWorkout.repositories.UnidadMedidaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnidadMedidaService implements UnidadMedidaServiceInterface {

	@Autowired
	private UnidadMedidaRepository unidadMedidaRepository;

	@Override
	public List<UnidadmedidaPOJO> getAll() {

		List<Unidadmedida> unidadesMedidas = unidadMedidaRepository.findAll();
		return generateUnidadmedidaDtos(unidadesMedidas);
	}

	private List<UnidadmedidaPOJO> generateUnidadmedidaDtos(List<Unidadmedida> unidadesMedidas) {

		List<UnidadmedidaPOJO> uiUnidadesMedidas = new ArrayList<UnidadmedidaPOJO>();
		unidadesMedidas.stream().forEach(um -> {
			UnidadmedidaPOJO dto = new UnidadmedidaPOJO();
			BeanUtils.copyProperties(um, dto);
		
			uiUnidadesMedidas.add(dto);
		});
		return uiUnidadesMedidas;
	}

	@Override
	@Transactional
	public Boolean saveUnidadMedida(UnidadMedidaRequest umr) {

		UnidadmedidaPOJO unidadMedidaDTO = umr.getUnidadMedida();
		Unidadmedida unidadMedida = new Unidadmedida();
		BeanUtils.copyProperties(unidadMedidaDTO, unidadMedida);
		Unidadmedida nunidadMedida = unidadMedidaRepository.save(unidadMedida);
		return (nunidadMedida == null) ? false : true;

	}

	@Override
	public UnidadmedidaPOJO getById(UnidadMedidaRequest umr) {

		UnidadmedidaPOJO unidadMedidaDTO = new UnidadmedidaPOJO();
		Unidadmedida unidadMedida = unidadMedidaRepository.findOne(umr.getUnidadMedida().getIdUnidadMedida());

		if (unidadMedida != null) {
			BeanUtils.copyProperties(unidadMedida, unidadMedidaDTO);
		}

		return unidadMedidaDTO;

	}

	@Override
	public boolean delete(int idUnidadMedida) {
		unidadMedidaRepository.delete(idUnidadMedida);
		return !unidadMedidaRepository.exists(idUnidadMedida);
	}

	@Override
	public boolean exists(Integer idUnidadMedida) {
		return unidadMedidaRepository.exists(idUnidadMedida);

	}
	@Override
	public UnidadmedidaPOJO getByIdUnidad(int idUnidadMedida) {
		UnidadmedidaPOJO unidadMedidaPOJO = new UnidadmedidaPOJO();
		Unidadmedida unidadMedida = unidadMedidaRepository.findByIdUnidadMedida(idUnidadMedida);
		if (unidadMedida != null) {
			BeanUtils.copyProperties(unidadMedida, unidadMedidaPOJO);
		}
		return unidadMedidaPOJO;
	}
	
}
