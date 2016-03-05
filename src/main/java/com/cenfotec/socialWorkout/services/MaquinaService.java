package com.cenfotec.socialWorkout.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.socialWorkout.contracts.MaquinaRequest;
import com.cenfotec.socialWorkout.ejb.Maquina;
import com.cenfotec.socialWorkout.ejb.Unidadmedida;
import com.cenfotec.socialWorkout.pojo.MaquinaPOJO;
import com.cenfotec.socialWorkout.repositories.MaquinaRepository;

@Service
public class MaquinaService implements MaquinaServiceInterface {

	@Autowired
	private MaquinaRepository maquinaRepository;

	@Override
	public List<MaquinaPOJO> getAll(MaquinaRequest mr) {

		List<Maquina> maquinas = maquinaRepository.findAll();
		return generateMaquinaDtos(maquinas);
	}

	private List<MaquinaPOJO> generateMaquinaDtos(List<Maquina> maquinas) {

		List<MaquinaPOJO> uiMaquinas = new ArrayList<MaquinaPOJO>();
		maquinas.stream().forEach(m -> {
			MaquinaPOJO dto = new MaquinaPOJO();
			BeanUtils.copyProperties(m, dto);
			uiMaquinas.add(dto);
		});
		return uiMaquinas;
	}

	@Override
	@Transactional
	public Boolean saveMaquina(Maquina m) {

		Maquina nmaquina = maquinaRepository.save(m);

		return (nmaquina == null) ? false : true;

	}

	@Override
	public Boolean editMaquina(Maquina m) {

		Maquina maquina = this.getAllByIdMaquina(m);

		BeanUtils.copyProperties(m, maquina);

		Maquina nmaquina = maquinaRepository.save(maquina);

		return (nmaquina == null) ? false : true;
	}

	@Override
	public Maquina getAllByIdMaquina(Maquina m) {

		Maquina maquina;

		maquina = maquinaRepository.findOne(m.getIdMaquina());

		return maquina;

	}

	@Override
	public boolean delete(int idMaquina) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exists(Integer idMaquina) {
		// TODO Auto-generated method stub
		return false;
	}

}
