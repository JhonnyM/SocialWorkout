package com.cenfotec.socialWorkout.ejb;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rankeo database table.
 * 
 */
@Entity
@NamedQuery(name="Rankeo.findAll", query="SELECT r FROM Rankeo r")
public class Rankeo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idRanqueo;

	private int cantidadPuntosAcumulada;

	private byte logroAlcanzado;

	//bi-directional many-to-one association to Clasepremiacion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idClasePremiacion")
	private Clasepremiacion clasepremiacion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUsuarioEvaluador")
	private Usuario usuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUsuario")
	private Usuario usuario2;

	public Rankeo() {
	}

	public int getIdRanqueo() {
		return this.idRanqueo;
	}

	public void setIdRanqueo(int idRanqueo) {
		this.idRanqueo = idRanqueo;
	}

	public int getCantidadPuntosAcumulada() {
		return this.cantidadPuntosAcumulada;
	}

	public void setCantidadPuntosAcumulada(int cantidadPuntosAcumulada) {
		this.cantidadPuntosAcumulada = cantidadPuntosAcumulada;
	}

	public byte getLogroAlcanzado() {
		return this.logroAlcanzado;
	}

	public void setLogroAlcanzado(byte logroAlcanzado) {
		this.logroAlcanzado = logroAlcanzado;
	}

	public Clasepremiacion getClasepremiacion() {
		return this.clasepremiacion;
	}

	public void setClasepremiacion(Clasepremiacion clasepremiacion) {
		this.clasepremiacion = clasepremiacion;
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