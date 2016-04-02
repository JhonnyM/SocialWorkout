package com.cenfotec.socialWorkout.pojo;

import java.util.List;
import com.cenfotec.socialWorkout.ejb.Maquinahasejercicio;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EjercicioPOJO {

	private int idEjercicio;

	private String descEjercicio;

	private List<MaquinahasejercicioPOJO> maquinahasejercicios;

	public int getIdEjercicio() {
		return this.idEjercicio;
	}

	public void setIdEjercicio(int idEjercicio) {
		this.idEjercicio = idEjercicio;
	}

	public String getDescEjercicio() {
		return this.descEjercicio;
	}

	public void setDescEjercicio(String descEjercicio) {
		this.descEjercicio = descEjercicio;
	}

	public List<MaquinahasejercicioPOJO> getMaquinahasejercicios() {
		return this.maquinahasejercicios;
	}

	public void setMaquinahasejercicios(List<MaquinahasejercicioPOJO> maquinahasejercicios) {
		this.maquinahasejercicios = maquinahasejercicios;
	}

}
