package com.cenfotec.socialWorkout.contracts;

import java.util.List;

import com.cenfotec.socialWorkout.pojo.EjercicioPOJO;

public class EjercicioResponse extends BaseResponse {

	private List<EjercicioPOJO> ejercicios;

	public EjercicioResponse() {
		super();
	}

	public List<EjercicioPOJO> getEjercicios() {
		return ejercicios;
	}

	public void setEjercicios(List<EjercicioPOJO> ejercicios) {
		this.ejercicios = ejercicios;
	}

}
