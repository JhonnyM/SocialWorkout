package com.cenfotec.socialWorkout.pojo;

import java.util.List;
import com.cenfotec.socialWorkout.ejb.Maquinahasejercicio;

public class EjercicioPOJO {

	private int idEjercicio;

	private String descEjercicio;

	private List<Maquinahasejercicio> maquinahasejercicios;

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

	public List<Maquinahasejercicio> getMaquinahasejercicios() {
		return this.maquinahasejercicios;
	}

	public void setMaquinahasejercicios(List<Maquinahasejercicio> maquinahasejercicios) {
		this.maquinahasejercicios = maquinahasejercicios;
	}

//	public Maquinahasejercicio addMaquinahasejercicio(Maquinahasejercicio maquinahasejercicio) {
//		getMaquinahasejercicios().add(maquinahasejercicio);
//		maquinahasejercicio.setEjercicio(this);
//
//		return maquinahasejercicio;
//	}
//
//	public Maquinahasejercicio removeMaquinahasejercicio(Maquinahasejercicio maquinahasejercicio) {
//		getMaquinahasejercicios().remove(maquinahasejercicio);
//		maquinahasejercicio.setEjercicio(null);
//
//		return maquinahasejercicio;
//	}

	
}
