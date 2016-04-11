package com.cenfotec.socialWorkout.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cenfotec.socialWorkout.contracts.MaquinahasejercicioRequest;
import com.cenfotec.socialWorkout.ejb.Maquinahasejercicio;
import com.cenfotec.socialWorkout.ejb.Promediorutinasmaquina;
import com.cenfotec.socialWorkout.ejb.Unidadmedida;
import com.cenfotec.socialWorkout.pojo.MaquinahasejercicioPOJO;
import com.cenfotec.socialWorkout.pojo.PromedioRutinasMaquinaPOJO;
import com.cenfotec.socialWorkout.repositories.MaquinahasejercicioRepository;

@Service
public class MaquinahasejercicioService implements MaquinahasejercicioServiceInterface {

	@Autowired
	private MaquinahasejercicioRepository maquinaHasEjercicioRepository;

	@Override
	@Transactional
	public List<MaquinahasejercicioPOJO>  getMaquinaHasEjercicioXIdEjercicioXMaquina(Integer idEjercicioXMaquina) {
		List <Maquinahasejercicio> listaMaquinasHasEjercicio = maquinaHasEjercicioRepository.findByIdEjercicioXMaquina(idEjercicioXMaquina);
		return generateMaquinasHasEjerciciosDtos(listaMaquinasHasEjercicio);
	}

	private List<MaquinahasejercicioPOJO> generateMaquinasHasEjerciciosDtos(List<Maquinahasejercicio> maquinaHasEjercicio){
		List<MaquinahasejercicioPOJO> uiMaquinasHasEjercicio = new ArrayList<MaquinahasejercicioPOJO>();
		maquinaHasEjercicio.stream().forEach(u -> {
			MaquinahasejercicioPOJO dto = new MaquinahasejercicioPOJO();
			if (!(u==null)){
			BeanUtils.copyProperties(u,dto);
			}
			uiMaquinasHasEjercicio.add(dto);
		});	
		return uiMaquinasHasEjercicio;
	}



}
