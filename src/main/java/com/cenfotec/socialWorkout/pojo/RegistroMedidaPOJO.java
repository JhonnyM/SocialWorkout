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
	private static final long serialVersionUID = 1L;

	@Id
	private int idRegistroMedida;

	private int cantidad;

	private Date fecha;

	private LugarMedicionPOJO lugarmedicionPOJO;

	private UsuarioPOJO usuarioPOJO;

	public RegistroMedidaPOJO() {
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

	public LugarMedicionPOJO getLugarmedicion() {
		return this.lugarmedicionPOJO;
	}

	public void setLugarmedicion(LugarMedicionPOJO lugarmedicionPOJO) {
		this.lugarmedicionPOJO = lugarmedicionPOJO;
	}

	public UsuarioPOJO getUsuario() {
		return this.usuarioPOJO;
	}

	public void setUsuario(UsuarioPOJO usuarioPOJO) {
		this.usuarioPOJO = usuarioPOJO;
	}

}