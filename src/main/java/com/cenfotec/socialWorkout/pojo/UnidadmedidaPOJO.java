package com.cenfotec.socialWorkout.pojo;

import java.util.List;

import com.cenfotec.socialWorkout.ejb.Lugarmedicion;

public class UnidadmedidaPOJO {

	private int idUnidadMedida;

	private String descUnidadMedida;

	private List<Lugarmedicion> lugarmedicions;

	public int getIdUnidadMedida() {
		return this.idUnidadMedida;
	}

	public void setIdUnidadMedida(int idUnidadMedida) {
		this.idUnidadMedida = idUnidadMedida;
	}

	public String getDescUnidadMedida() {
		return this.descUnidadMedida;
	}

	public void setDescUnidadMedida(String descUnidadMedida) {
		this.descUnidadMedida = descUnidadMedida;
	}

	public List<Lugarmedicion> getLugarmedicions() {
		return this.lugarmedicions;
	}

	public void setLugarmedicions(List<Lugarmedicion> lugarmedicions) {
		this.lugarmedicions = lugarmedicions;
	}
	
}
