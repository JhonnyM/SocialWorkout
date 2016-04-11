package com.cenfotec.socialWorkout.pojo;

import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.cenfotec.socialWorkout.ejb.Objetivo;
import com.cenfotec.socialWorkout.ejb.Plantillarutinadetalle;
import com.cenfotec.socialWorkout.ejb.Plantillarutinamaestro;

public class PlantillarutinamaestroPOJO {

	private int idRutina;
	private String descRutina;
	private byte rutinaBase;
	private Objetivo objetivo;
	private Plantillarutinamaestro plantillarutinamaestro;
	
	public PlantillarutinamaestroPOJO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getIdRutina() {
		return idRutina;
	}
	public void setIdRutina(int idRutina) {
		this.idRutina = idRutina;
	}
	public String getDescRutina() {
		return descRutina;
	}
	public void setDescRutina(String descRutina) {
		this.descRutina = descRutina;
	}
	public byte getRutinaBase() {
		return rutinaBase;
	}
	public void setRutinaBase(byte rutinaBase) {
		this.rutinaBase = rutinaBase;
	}
	public Objetivo getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(Objetivo objetivo) {
		this.objetivo = objetivo;
	}
	public Plantillarutinamaestro getPlantillarutinamaestro() {
		return plantillarutinamaestro;
	}
	public void setPlantillarutinamaestro(Plantillarutinamaestro plantillarutinamaestro) {
		this.plantillarutinamaestro = plantillarutinamaestro;
	}
}
