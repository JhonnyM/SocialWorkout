package com.cenfotec.socialWorkout.pojo;

import java.util.Date;
import java.util.List;

import com.cenfotec.socialWorkout.ejb.Registroingreso;

public class UsuarioAdministradorPOJO {

	private int idUsuario;
	private String identificacion;
	private String nombre;
	private String apellidos;
	private Date fechaIngreso;
	private Date fechaPago;
	private TipoUsuarioPOJO tipoUsuarioPOJO;
	private UsuarioPOJO usuarioPOJOInstructor;
	private RegistroingresoPOJO registroIngresoPOJO;
	private String debePago;

	public UsuarioAdministradorPOJO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setDebePago() {

		Date todayDate = new Date();

		if (tipoUsuarioPOJO != null) {
			if (tipoUsuarioPOJO.getIdTipoUsuario() == 1) {
				if (this.fechaPago.before(todayDate)) {
					this.debePago = "Pago pendiente";
				} else {
					this.debePago = "Pago realizado";
				}
			} else {
				this.debePago = "No aplica para pago";
			}

		} else {
			this.debePago = "No aplica para pago";
		}

	}

	public String getDebePago() {
		return this.debePago;
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public String getIdentificacion() {
		return this.identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return this.nombre + ' ' + this.apellidos;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public RegistroingresoPOJO getRegistroIngresoPOJO() {
		return this.registroIngresoPOJO;
	}

	public void setRegistroIngresoPOJO(RegistroingresoPOJO registroIngresoPOJO) {
		this.registroIngresoPOJO = registroIngresoPOJO;
	}

	public TipoUsuarioPOJO getTipoUsuarioPOJO() {
		return tipoUsuarioPOJO;
	}

	public void setTipoUsuarioPOJO(TipoUsuarioPOJO tipoUsuarioPOJO) {
		this.tipoUsuarioPOJO = tipoUsuarioPOJO;
	}

	public UsuarioPOJO getUsuarioPOJOInstructor() {
		return usuarioPOJOInstructor;
	}

	public void setUsuarioPOJOInstructor(UsuarioPOJO usuarioPOJOInstructor) {
		this.usuarioPOJOInstructor = usuarioPOJOInstructor;
	}

}
