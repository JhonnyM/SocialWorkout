package com.cenfotec.socialWorkout.ejb;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the actividadsistemahastipoactividad database table.
 * 
 */
@Entity
@NamedQuery(name="Actividadsistemahastipoactividad.findAll", query="SELECT a FROM Actividadsistemahastipoactividad a")
public class Actividadsistemahastipoactividad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idActividadSistemaHasTipoActividad;

	//bi-directional many-to-one association to Actividadsistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idActividadSistema")
	private Actividadsistema actividadsistema;

	//bi-directional many-to-one association to Tipoactividad
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idTipoActividad")
	private Tipoactividad tipoactividad;

	public Actividadsistemahastipoactividad() {
	}

	public int getIdActividadSistemaHasTipoActividad() {
		return this.idActividadSistemaHasTipoActividad;
	}

	public void setIdActividadSistemaHasTipoActividad(int idActividadSistemaHasTipoActividad) {
		this.idActividadSistemaHasTipoActividad = idActividadSistemaHasTipoActividad;
	}

	public Actividadsistema getActividadsistema() {
		return this.actividadsistema;
	}

	public void setActividadsistema(Actividadsistema actividadsistema) {
		this.actividadsistema = actividadsistema;
	}

	public Tipoactividad getTipoactividad() {
		return this.tipoactividad;
	}

	public void setTipoactividad(Tipoactividad tipoactividad) {
		this.tipoactividad = tipoactividad;
	}

}