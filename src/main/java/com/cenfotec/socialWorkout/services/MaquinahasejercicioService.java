package com.cenfotec.socialWorkout.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.socialWorkout.contracts.MaquinahasejercicioRequest;
import com.cenfotec.socialWorkout.ejb.Maquinahasejercicio;
import com.cenfotec.socialWorkout.repositories.MaquinahasejercicioRepository;

@Service
public class MaquinahasejercicioService implements MaquinahasejercicioServiceInterface {

	@Autowired
	private MaquinahasejercicioRepository maquinaHasEjercicioRepository;


	@Override
	public Boolean saveMaquinahasejercicio(Maquinahasejercicio mh) {
		// TODO Auto-generated method stub
		return null;
	}

}
