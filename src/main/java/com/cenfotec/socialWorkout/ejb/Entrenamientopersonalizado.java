package com.cenfotec.socialWorkout.ejb;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the entrenamientopersonalizado database table.
 * 
 */
@Entity
@NamedQuery(name="Entrenamientopersonalizado.findAll", query="SELECT e FROM Entrenamientopersonalizado e")
public class Entrenamientopersonalizado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idRegistroEntrenadorXUsuario;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuarioEntrenador")
	private Usuario usuario2;

	public Entrenamientopersonalizado() {
	}

	public int getIdRegistroEntrenadorXUsuario() {
		return this.idRegistroEntrenadorXUsuario;
	}

	public void setIdRegistroEntrenadorXUsuario(int idRegistroEntrenadorXUsuario) {
		this.idRegistroEntrenadorXUsuario = idRegistroEntrenadorXUsuario;
	}

	public Usuario getUsuario1() {
		return this.usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}

	public Usuario getUsuario2() {
		return this.usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}

}