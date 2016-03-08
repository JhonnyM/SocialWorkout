package com.cenfotec.socialWorkout.pojo;

public class MaquinahasejercicioPOJO {

	private int idEjercicioXMaquina;

	private EjercicioPOJO ejercicio;

	private MaquinaPOJO maquina;

	public MaquinahasejercicioPOJO() {
	}

	public int getIdEjercicioXMaquina() {
		return this.idEjercicioXMaquina;
	}

	public void setIdEjercicioXMaquina(int idEjercicioXMaquina) {
		this.idEjercicioXMaquina = idEjercicioXMaquina;
	}

	public EjercicioPOJO getEjercicio() {
		return this.ejercicio;
	}

	public void setEjercicio(EjercicioPOJO ejercicio) {
		this.ejercicio = ejercicio;
	}

	public MaquinaPOJO getMaquina() {
		return this.maquina;
	}

	public void setMaquina(MaquinaPOJO maquina) {
		this.maquina = maquina;
	}

}
