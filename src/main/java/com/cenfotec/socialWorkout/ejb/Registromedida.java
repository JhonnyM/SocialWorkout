package com.cenfotec.socialWorkout.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the registromedidas database table.
 * 
 */
@Entity
@Table(name="registromedidas")
@NamedQuery(name="Registromedida.findAll", query="SELECT r FROM Registromedida r")
public class Registromedida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idRegistroMedida;

	private int cantidad;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	//bi-directional many-to-one association to Lugarmedicion
	@ManyToOne
	@JoinColumn(name="idLugarMedicion")
	private Lugarmedicion lugarmedicion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;

	public Registromedida() {
	}

	public int getIdRegistroMedida() {
		return this.idRegistroMedida;
	}

	public void setIdRegistroMedida(int idRegistroMedida) {
		this.idRegistroMedida = idRegistroMedida;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Lugarmedicion getLugarmedicion() {
		return this.lugarmedicion;
	}

	public void setLugarmedicion(Lugarmedicion lugarmedicion) {
		this.lugarmedicion = lugarmedicion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}