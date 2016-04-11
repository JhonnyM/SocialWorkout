package com.cenfotec.socialWorkout.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipoactividad database table.
 * 
 */
@Entity
@NamedQuery(name="Tipoactividad.findAll", query="SELECT t FROM Tipoactividad t")
public class Tipoactividad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idTipoActividad;

	private String descTipoActividad;

	//bi-directional many-to-one association to Actividadsistema
	@OneToMany(mappedBy="tipoactividad")
	private List<Actividadsistema> actividadsistemas;

	//bi-directional many-to-one association to Actividadsistemahastipoactividad
	@OneToMany(mappedBy="tipoactividad")
	private List<Actividadsistemahastipoactividad> actividadsistemahastipoactividads;

	public Tipoactividad() {
	}

	public int getIdTipoActividad() {
		return this.idTipoActividad;
	}

	public void setIdTipoActividad(int idTipoActividad) {
		this.idTipoActividad = idTipoActividad;
	}

	public String getDescTipoActividad() {
		return this.descTipoActividad;
	}

	public void setDescTipoActividad(String descTipoActividad) {
		this.descTipoActividad = descTipoActividad;
	}

	public List<Actividadsistema> getActividadsistemas() {
		return this.actividadsistemas;
	}

	public void setActividadsistemas(List<Actividadsistema> actividadsistemas) {
		this.actividadsistemas = actividadsistemas;
	}

	public Actividadsistema addActividadsistema(Actividadsistema actividadsistema) {
		getActividadsistemas().add(actividadsistema);
		actividadsistema.setTipoactividad(this);

		return actividadsistema;
	}

	public Actividadsistema removeActividadsistema(Actividadsistema actividadsistema) {
		getActividadsistemas().remove(actividadsistema);
		actividadsistema.setTipoactividad(null);

		return actividadsistema;
	}

	public List<Actividadsistemahastipoactividad> getActividadsistemahastipoactividads() {
		return this.actividadsistemahastipoactividads;
	}

	public void setActividadsistemahastipoactividads(List<Actividadsistemahastipoactividad> actividadsistemahastipoactividads) {
		this.actividadsistemahastipoactividads = actividadsistemahastipoactividads;
	}

	public Actividadsistemahastipoactividad addActividadsistemahastipoactividad(Actividadsistemahastipoactividad actividadsistemahastipoactividad) {
		getActividadsistemahastipoactividads().add(actividadsistemahastipoactividad);
		actividadsistemahastipoactividad.setTipoactividad(this);

		return actividadsistemahastipoactividad;
	}

	public Actividadsistemahastipoactividad removeActividadsistemahastipoactividad(Actividadsistemahastipoactividad actividadsistemahastipoactividad) {
		getActividadsistemahastipoactividads().remove(actividadsistemahastipoactividad);
		actividadsistemahastipoactividad.setTipoactividad(null);

		return actividadsistemahastipoactividad;
	}

}