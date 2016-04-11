package com.cenfotec.socialWorkout.pojo;

import java.io.Serializable;
import javax.persistence.*;

import com.cenfotec.socialWorkout.ejb.Usuario;

import java.util.Date;

/**
 * The persistent class for the registromedidas database table.
 * 
 */
public class RegistroMedidaPOJO {

	private int idRegistroMedida;

	private double cantidad;

	private Date fecha;

	private LugarMedicionPOJO lugarmedicionPOJO;

	private UsuarioPOJO usuarioPOJO;

	public int getIdRegistroMedida() {
		return this.idRegistroMedida;
	}

	public void setIdRegistroMedida(int idRegistroMedida) {
		this.idRegistroMedida = idRegistroMedida;
	}

	public double getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public LugarMedicionPOJO getLugarmedicionPOJO() {
		return this.lugarmedicionPOJO;
	}

	public void setLugarmedicionPOJO(LugarMedicionPOJO lugarmedicionPOJO) {
		this.lugarmedicionPOJO = lugarmedicionPOJO;
	}

	public UsuarioPOJO getUsuarioPOJO() {
		return this.usuarioPOJO;
	}

	public void setUsuarioPOJO(UsuarioPOJO usuarioPOJO) {
		this.usuarioPOJO = usuarioPOJO;
	}

}