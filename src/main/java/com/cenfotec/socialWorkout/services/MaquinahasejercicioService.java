package com.cenfotec.socialWorkout.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.socialWorkout.contracts.MaquinahasejercicioRequest;
import com.cenfotec.socialWorkout.ejb.Maquinahasejercicio;
import com.cenfotec.socialWorkout.ejb.Unidadmedida;
import com.cenfotec.socialWorkout.repositories.MaquinahasejercicioRepository;

@Service
public class MaquinahasejercicioService implements MaquinahasejercicioServiceInterface {

	@Autowired
	private MaquinahasejercicioRepository maquinaHasEjercicioRepository;



}
