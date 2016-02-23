package com.cenfotec.socialWorkout.ejb;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the actividadsistema database table.
 * 
 */
@Entity
@NamedQuery(name="Actividadsistema.findAll", query="SELECT a FROM Actividadsistema a")
public class Actividadsistema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idActividadSistema;

	private String descActividadSistema;

	//bi-directional many-to-one association to Tipoactividad
	@ManyToOne
	@JoinColumn(name="idTipoActividad")
	private Tipoactividad tipoactividad;

	//bi-directional one-to-one association to Actividadsistemahastipousuario
	@OneToOne(mappedBy="actividadsistema")
	private Actividadsistemahastipousuario actividadsistemahastipousuario;

	public Actividadsistema() {
	}

	public int getIdActividadSistema() {
		return this.idActividadSistema;
	}

	public void setIdActividadSistema(int idActividadSistema) {
		this.idActividadSistema = idActividadSistema;
	}

	public String getDescActividadSistema() {
		return this.descActividadSistema;
	}

	public void setDescActividadSistema(String descActividadSistema) {
		this.descActividadSistema = descActividadSistema;
	}

	public Tipoactividad getTipoactividad() {
		return this.tipoactividad;
	}

	public void setTipoactividad(Tipoactividad tipoactividad) {
		this.tipoactividad = tipoactividad;
	}

	public Actividadsistemahastipousuario getActividadsistemahastipousuario() {
		return this.actividadsistemahastipousuario;
	}

	public void setActividadsistemahastipousuario(Actividadsistemahastipousuario actividadsistemahastipousuario) {
		this.actividadsistemahastipousuario = actividadsistemahastipousuario;
	}

}