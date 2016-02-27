package com.cenfotec.socialWorkout.pojo;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class ObjetivoPOJO {

	private int idObjetivo;
	private String descObjetivo;

	public ObjetivoPOJO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDescObjetivo(){
		return descObjetivo;
	}

	public int getIdObjetivo(){
		return idObjetivo;
	}

	public void setDescObjetivo(String descObjetivo) {
		this.descObjetivo = descObjetivo;
	}

}
