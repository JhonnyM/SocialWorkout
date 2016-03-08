package com.cenfotec.socialWorkout.ejb;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the actividadsistemahastipousuario database table.
 * 
 */
@Entity
@NamedQuery(name="Actividadsistemahastipousuario.findAll", query="SELECT a FROM Actividadsistemahastipousuario a")
public class Actividadsistemahastipousuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idActividadSistema;

	//bi-directional one-to-one association to Actividadsistema
	@OneToOne
	@JoinColumn(name="idActividadSistema")
	private Actividadsistema actividadsistema;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;

	public Actividadsistemahastipousuario() {
	}

	public int getIdActividadSistema() {
		return this.idActividadSistema;
	}

	public void setIdActividadSistema(int idActividadSistema) {
		this.idActividadSistema = idActividadSistema;
	}

	public Actividadsistema getActividadsistema() {
		return this.actividadsistema;
	}

	public void setActividadsistema(Actividadsistema actividadsistema) {
		this.actividadsistema = actividadsistema;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}