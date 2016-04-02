package com.cenfotec.socialWorkout.pojo;

public class MaquinahasejercicioPOJO {

	private Integer idEjercicioXMaquina;

	private EjercicioPOJO ejercicioPOJO;

	private MaquinaPOJO maquinaPOJO;

	public MaquinahasejercicioPOJO() {
		super();
	}

	public int getIdEjercicioXMaquina() {
		return this.idEjercicioXMaquina;
	}

	public void setIdEjercicioXMaquina(int idEjercicioXMaquina) {
		this.idEjercicioXMaquina = idEjercicioXMaquina;
	}

	public EjercicioPOJO getEjercicioPOJO() {
		return this.ejercicioPOJO;
	}

	public void setEjercicioPOJO(EjercicioPOJO ejercicioPOJO) {
		this.ejercicioPOJO = ejercicioPOJO;
	}

	public MaquinaPOJO getMaquinaPOJO() {
		return this.maquinaPOJO;
	}

	public void setMaquinaPOJO(MaquinaPOJO maquinaPOJO) {
		this.maquinaPOJO = maquinaPOJO;
	}

}
