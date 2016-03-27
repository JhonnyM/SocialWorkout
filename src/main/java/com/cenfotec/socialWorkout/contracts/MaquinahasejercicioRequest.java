package com.cenfotec.socialWorkout.contracts;

import com.cenfotec.socialWorkout.pojo.EjercicioPOJO;
import com.cenfotec.socialWorkout.pojo.MaquinahasejercicioPOJO;

public class MaquinahasejercicioRequest {

	private MaquinahasejercicioPOJO maquinaHasEjercicio;
	
	public MaquinahasejercicioRequest() {
		super();
	}
	
	public MaquinahasejercicioPOJO getMaquinahasejercicio() {
		return maquinaHasEjercicio;
	}
	
	public void setMaquinahasejercicio(MaquinahasejercicioPOJO maquinaHasEjercicio) {
		this.maquinaHasEjercicio = maquinaHasEjercicio;
	}

	@Override
	public String toString() {
		return "MaquinaHasEjercicio request: [maquinaHasEjercicio=" + maquinaHasEjercicio + "]";
	}
	
}
