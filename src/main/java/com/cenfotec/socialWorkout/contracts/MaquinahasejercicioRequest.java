package com.cenfotec.socialWorkout.contracts;

import com.cenfotec.socialWorkout.pojo.MaquinahasejercicioPOJO;

public class MaquinahasejercicioRequest {


	private MaquinahasejercicioPOJO maquinaEjercicioPOJO;
	
	public MaquinahasejercicioRequest() {
		super();
	}
	
	public MaquinahasejercicioPOJO getEjercicio() {
		return maquinaEjercicioPOJO;
	}
	
	public void setEjercicio(MaquinahasejercicioPOJO maquinaEjercicioPOJO) {
		this.maquinaEjercicioPOJO = maquinaEjercicioPOJO;
	}

	@Override
	public String toString() {
		return "Ejercicio request: [ejercicio=" + maquinaEjercicioPOJO + "]";
	}
	
	
}
