package com.cenfotec.socialWorkout.pojo;

public class MaquinahasejercicioPOJO {

	private Integer idEjercicioXMaquina;

	private EjercicioPOJO ejercicio;

	private MaquinaPOJO maquina;

	public MaquinahasejercicioPOJO() {
		super();
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

	public void setEjercicio(EjercicioPOJO ejercicioPOJO) {
		this.ejercicio = ejercicioPOJO;
	}

	public MaquinaPOJO getMaquina() {
		return this.maquina;
	}

	public void setMaquina(MaquinaPOJO maquinaPOJO) {
		this.maquina = maquinaPOJO;
	}

}
