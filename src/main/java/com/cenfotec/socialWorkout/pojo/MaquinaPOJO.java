package com.cenfotec.socialWorkout.pojo;
import java.util.List;

import com.cenfotec.socialWorkout.ejb.Maquinahasejercicio;

public class MaquinaPOJO {
	
	private int idMaquina;

	private int cantidad;

	private String descMaquina;

	private int minutosXPersona;

	private int personasXMaquina;

	private List<Maquinahasejercicio> maquinahasejercicios;

	public MaquinaPOJO() {
	}

	public int getIdMaquina() {
		return this.idMaquina;
	}

	public void setIdMaquina(int idMaquina) {
		this.idMaquina = idMaquina;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescMaquina() {
		return this.descMaquina;
	}

	public void setDescMaquina(String descMaquina) {
		this.descMaquina = descMaquina;
	}

	public int getMinutosXPersona() {
		return this.minutosXPersona;
	}

	public void setMinutosXPersona(int minutosXPersona) {
		this.minutosXPersona = minutosXPersona;
	}

	public int getPersonasXMaquina() {
		return this.personasXMaquina;
	}

	public void setPersonasXMaquina(int personasXMaquina) {
		this.personasXMaquina = personasXMaquina;
	}

	public List<Maquinahasejercicio> getMaquinahasejercicios() {
		return this.maquinahasejercicios;
	}

	public void setMaquinahasejercicios(List<Maquinahasejercicio> maquinahasejercicios) {
		this.maquinahasejercicios = maquinahasejercicios;
	}

//	public Maquinahasejercicio addMaquinahasejercicio(Maquinahasejercicio maquinahasejercicio) {
//		getMaquinahasejercicios().add(maquinahasejercicio);
//		maquinahasejercicio.setMaquina(this);
//
//		return maquinahasejercicio;
//	}
//
//	public Maquinahasejercicio removeMaquinahasejercicio(Maquinahasejercicio maquinahasejercicio) {
//		getMaquinahasejercicios().remove(maquinahasejercicio);
//		maquinahasejercicio.setMaquina(null);
//
//		return maquinahasejercicio;
//	}


}
