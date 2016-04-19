package com.cenfotec.socialWorkout.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.socialWorkout.contracts.EjercicioRequest;
import com.cenfotec.socialWorkout.contracts.MaquinahasejercicioRequest;
import com.cenfotec.socialWorkout.ejb.Ejercicio;
import com.cenfotec.socialWorkout.ejb.Maquina;
import com.cenfotec.socialWorkout.ejb.Maquinahasejercicio;
import com.cenfotec.socialWorkout.pojo.EjercicioPOJO;
import com.cenfotec.socialWorkout.pojo.MaquinaPOJO;
import com.cenfotec.socialWorkout.pojo.MaquinahasejercicioPOJO;
import com.cenfotec.socialWorkout.repositories.EjercicioRepository;
import com.cenfotec.socialWorkout.repositories.MaquinaRepository;
import com.cenfotec.socialWorkout.repositories.MaquinahasejercicioRepository;

@Service
public class EjercicioService implements EjercicioServiceInterface {

	@Autowired
	private EjercicioRepository ejercicioRepository;
	@Autowired
	private MaquinaRepository maquinaRepository;
	@Autowired
	private MaquinahasejercicioRepository maquinahasejercicioRepository;

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
			uiEjercicios.add(dto);
		});
		return uiEjercicios;
	}

	private List<MaquinahasejercicioPOJO> generateMaquinasHasEjercicioDtos(
			List<Maquinahasejercicio> maquinaEjercicios) {

		List<MaquinahasejercicioPOJO> uiMaquinaEjercicios = new ArrayList<MaquinahasejercicioPOJO>();
		maquinaEjercicios.stream().forEach(m -> {

			MaquinaPOJO maquinaDTO = new MaquinaPOJO();
			EjercicioPOJO ejercicioDTO = new EjercicioPOJO();

			MaquinahasejercicioPOJO dto = new MaquinahasejercicioPOJO();
			BeanUtils.copyProperties(m, dto);

			if (m.getEjercicio() != null) {
				BeanUtils.copyProperties(m.getEjercicio(), ejercicioDTO);
				dto.setEjercicio(ejercicioDTO);
			}

			if (m.getMaquina() != null) {
				BeanUtils.copyProperties(m.getMaquina(), maquinaDTO);
				dto.setMaquina(maquinaDTO);
			}

			uiMaquinaEjercicios.add(dto);

		});

		return uiMaquinaEjercicios;

	}

	@Override
	@Transactional
	public Boolean saveEjercicio(EjercicioRequest ejercicioRequest) {

		EjercicioPOJO ejercicioDTO = ejercicioRequest.getEjercicio();

		Ejercicio ejercicio = new Ejercicio();

		BeanUtils.copyProperties(ejercicioDTO, ejercicio);

		Ejercicio nejercicio = ejercicioRepository.save(ejercicio);

		return (nejercicio == null) ? false : true;

	}

	@Override
	public EjercicioPOJO getById(EjercicioRequest ejercicioRequest) {
		EjercicioPOJO ejercicioDTO = new EjercicioPOJO();
		Ejercicio ejercicio = ejercicioRepository.findOne(ejercicioRequest.getEjercicio().getIdEjercicio());

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

	public boolean setMaquinaEjercicio(MaquinahasejercicioRequest maquinaEjercicioRequest) {

		EjercicioPOJO ejercicioDTO = maquinaEjercicioRequest.getMaquinahasejercicio().getEjercicio();
		MaquinaPOJO maquinaDTO = maquinaEjercicioRequest.getMaquinahasejercicio().getMaquina();

		Maquinahasejercicio maquinaEjercicioEJB = new Maquinahasejercicio();

		maquinaEjercicioEJB.setEjercicio(ejercicioRepository.findOne(ejercicioDTO.getIdEjercicio()));

		maquinaEjercicioEJB.setMaquina(maquinaRepository.findOne(maquinaDTO.getIdMaquina()));

		maquinahasejercicioRepository.save(maquinaEjercicioEJB);

		Maquinahasejercicio maquinaEjercicio = new Maquinahasejercicio();

		return (maquinaEjercicio == null) ? false : true;

	}

	public void deleteMaquinasAsignadas(MaquinahasejercicioRequest maquinaEjercicioRequest) {

		Maquinahasejercicio maquinaEjercicio = maquinahasejercicioRepository
				.findByEjercicioIdEjercicioAndMaquinaIdMaquina(
						maquinaEjercicioRequest.getMaquinahasejercicio().getEjercicio().getIdEjercicio(),
						maquinaEjercicioRequest.getMaquinahasejercicio().getMaquina().getIdMaquina());

		maquinahasejercicioRepository.delete(maquinaEjercicio);

	}

	public List<MaquinahasejercicioPOJO> getMaquinasEjercicio(MaquinahasejercicioRequest maquinaEjercicioRequest) {

		List<Maquinahasejercicio> maquinasAsignadas = new ArrayList<Maquinahasejercicio>();

		maquinasAsignadas = maquinahasejercicioRepository.findByEjercicioIdEjercicio(
				maquinaEjercicioRequest.getMaquinahasejercicio().getEjercicio().getIdEjercicio());

		return generateMaquinasHasEjercicioDtos(maquinasAsignadas);

	}

	@Override
	public void deleteAllMaquinasAsignadas(MaquinahasejercicioRequest maquinaEjercicioRequest) {

		List<Maquinahasejercicio> maquinasAsignadas = new ArrayList<Maquinahasejercicio>();

		maquinasAsignadas = maquinahasejercicioRepository.findByEjercicioIdEjercicio(
				maquinaEjercicioRequest.getMaquinahasejercicio().getEjercicio().getIdEjercicio());

		maquinasAsignadas.stream().forEach(ma -> {

			maquinahasejercicioRepository.delete(ma);

		});
	}

	@Override
	public void deleteAllMaquinasAsignadas(EjercicioRequest ejercicioRequest) {

		List<Maquinahasejercicio> maquinasAsignadas = new ArrayList<Maquinahasejercicio>();

		maquinasAsignadas = maquinahasejercicioRepository
				.findByEjercicioIdEjercicio(ejercicioRequest.getEjercicio().getIdEjercicio());

		maquinasAsignadas.stream().forEach(ma -> {

			maquinahasejercicioRepository.delete(ma);

		});

	}

}
