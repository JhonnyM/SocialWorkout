package com.cenfotec.socialWorkout.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.socialWorkout.contracts.EjercicioRequest;
import com.cenfotec.socialWorkout.contracts.MaquinaRequest;
import com.cenfotec.socialWorkout.ejb.Ejercicio;
import com.cenfotec.socialWorkout.ejb.Maquina;
import com.cenfotec.socialWorkout.ejb.Maquinahasejercicio;
import com.cenfotec.socialWorkout.ejb.Unidadmedida;
import com.cenfotec.socialWorkout.pojo.EjercicioPOJO;
import com.cenfotec.socialWorkout.pojo.MaquinaPOJO;
import com.cenfotec.socialWorkout.pojo.MaquinahasejercicioPOJO;
import com.cenfotec.socialWorkout.repositories.MaquinaRepository;

@Service
public class MaquinaService implements MaquinaServiceInterface {

	@Autowired
	private MaquinaRepository maquinaRepository;

	@Override
	public List<MaquinaPOJO> getAll() {

		List<Maquina> maquinas = maquinaRepository.findAll();
		return generateMaquinaDtos(maquinas);
	}

	private List<MaquinaPOJO> generateMaquinaDtos(List<Maquina> maquinas) {

		List<MaquinaPOJO> uiMaquinas = new ArrayList<MaquinaPOJO>();
		maquinas.stream().forEach(m -> {
			MaquinaPOJO dto = new MaquinaPOJO();
			BeanUtils.copyProperties(m, dto);
			dto.setMaquinahasejercicios(generateMaquinasHasEjercicioDtos(m.getMaquinahasejercicios()));
			uiMaquinas.add(dto);
		});
		return uiMaquinas;
	}

	private List<MaquinahasejercicioPOJO> generateMaquinasHasEjercicioDtos(
			List<Maquinahasejercicio> maquinaEjercicios) {

		List<MaquinahasejercicioPOJO> uiMaquinaEjercicios = new ArrayList<MaquinahasejercicioPOJO>();
		maquinaEjercicios.stream().forEach(m -> {
			
			MaquinahasejercicioPOJO dto = new MaquinahasejercicioPOJO();
			BeanUtils.copyProperties(m, dto);

			MaquinaPOJO mdto = new MaquinaPOJO();
			EjercicioPOJO edto = new EjercicioPOJO();

			BeanUtils.copyProperties(m.getMaquina(), mdto);
			BeanUtils.copyProperties(m.getEjercicio(), edto);

			dto.setMaquinaPOJO(mdto);
			dto.setEjercicioPOJO(edto);
			
			dto.getMaquinaPOJO().setMaquinahasejercicios(null);
			dto.getEjercicioPOJO().setMaquinahasejercicios(null);
			
			uiMaquinaEjercicios.add(dto);

		});
		
		return uiMaquinaEjercicios;
	}

	@Override
	@Transactional
	public Boolean saveMaquina(MaquinaRequest mr) {

		MaquinaPOJO maquinaDTO = mr.getMaquina();
		Maquina maquina = new Maquina();
		BeanUtils.copyProperties(maquinaDTO, maquina);
		Maquina nmaquina = maquinaRepository.save(maquina);
		return (nmaquina == null) ? false : true;

	}

	@Override
	public MaquinaPOJO getById(MaquinaRequest mr) {
		MaquinaPOJO maquinaDTO = new MaquinaPOJO();
		Maquina maquina = maquinaRepository.findOne(mr.getMaquina().getIdMaquina());

		if (maquina != null) {
			BeanUtils.copyProperties(maquina, maquinaDTO);
		}
		return maquinaDTO;
	}

	@Override
	public boolean delete(int idMaquina) {
		maquinaRepository.delete(idMaquina);
		return !maquinaRepository.exists(idMaquina);
	}

	@Override
	public boolean exists(Integer idMaquina) {
		return maquinaRepository.exists(idMaquina);
	}

}
