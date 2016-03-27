package com.cenfotec.socialWorkout.contracts;

import com.cenfotec.socialWorkout.pojo.EjercicioPOJO;

public class EjercicioRequest {

	private EjercicioPOJO ejercicio;
	
	public EjercicioRequest() {
		super();
	}
	
	public EjercicioPOJO getEjercicio() {
		return ejercicio;
	}
	
	public void setEjercicio(EjercicioPOJO ejercicio) {
		this.ejercicio = ejercicio;
	}

	@Override
	public String toString() {
		return "Ejercicio request: [ejercicio=" + ejercicio + "]";
	}
	
}
