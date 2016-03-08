package com.cenfotec.socialWorkout.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.socialWorkout.contracts.EjercicioRequest;
import com.cenfotec.socialWorkout.ejb.Ejercicio;
import com.cenfotec.socialWorkout.ejb.Maquina;
import com.cenfotec.socialWorkout.ejb.Maquinahasejercicio;
import com.cenfotec.socialWorkout.pojo.EjercicioPOJO;
import com.cenfotec.socialWorkout.pojo.MaquinaPOJO;
import com.cenfotec.socialWorkout.pojo.MaquinahasejercicioPOJO;
import com.cenfotec.socialWorkout.repositories.EjercicioRepository;
import com.cenfotec.socialWorkout.repositories.MaquinaRepository;

@Service
public class EjercicioService implements EjercicioServiceInterface {

	@Autowired
	private EjercicioRepository ejercicioRepository;

	@Override
	public List<EjercicioPOJO> getAll() {
		List<Ejercicio> ejercicios = ejercicioRepository.findAll();
		return generateEjercicioDtos(ejercicios);
	}

	private List<EjercicioPOJO> generateEjercicioDtos(List<Ejercicio> ejercicios) {

		List<EjercicioPOJO> uiEjercicios = new ArrayList<EjercicioPOJO>();
		ejercicios.stream().forEach(e -> {
			EjercicioPOJO dto = new EjercicioPOJO();
			BeanUtils.copyProperties(e, dto);
			dto.setMaquinahasejercicios(generateMaquinasHasEjercicioDtos(e.getMaquinahasejercicios()));
			uiEjercicios.add(dto);
		});
		return uiEjercicios;
	}

	private List<MaquinahasejercicioPOJO> 
	generateMaquinasHasEjercicioDtos(List<Maquinahasejercicio> maquinaEjercicios) {

		List<MaquinahasejercicioPOJO> uiMaquinaEjercicios = new ArrayList<MaquinahasejercicioPOJO>();
		maquinaEjercicios.stream().forEach(m -> {
			MaquinahasejercicioPOJO dto = new MaquinahasejercicioPOJO();
			BeanUtils.copyProperties(m, dto);
			uiMaquinaEjercicios.add(dto);
		});
		return uiMaquinaEjercicios;
	}

	
	@Override
	@Transactional
	public Boolean saveEjercicio(EjercicioRequest er) {

		EjercicioPOJO ejercicioDTO = er.getEjercicio();
		Ejercicio ejercicio = new Ejercicio();
		BeanUtils.copyProperties(ejercicioDTO, ejercicio);
		Ejercicio nejercicio = ejercicioRepository.save(ejercicio);
		return (nejercicio == null) ? false : true;

	}

	@Override
	public EjercicioPOJO getById(EjercicioRequest er) {
		EjercicioPOJO ejercicioDTO = new EjercicioPOJO();
		Ejercicio ejercicio = ejercicioRepository.findOne(er.getEjercicio().getIdEjercicio());

		if (ejercicio != null) {
			BeanUtils.copyProperties(ejercicio, ejercicioDTO);
		}
		return ejercicioDTO;
	}

	@Override
	public boolean delete(int idEjercicio) {
		ejercicioRepository.delete(idEjercicio);
		return !ejercicioRepository.exists(idEjercicio);
	}

	@Override
	public boolean exists(Integer idEjercicio) {
		return ejercicioRepository.exists(idEjercicio);
	}

}
