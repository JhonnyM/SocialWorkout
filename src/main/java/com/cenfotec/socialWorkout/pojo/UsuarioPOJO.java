package com.cenfotec.socialWorkout.pojo;

import java.util.Date;
import java.util.List;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.cenfotec.socialWorkout.ejb.Tipousuario;

public class UsuarioPOJO{
	
	private int idUsuario;
	private String apellidos;
	private String clave;
	private String correoElectronico;
	private boolean estatus;
	private Date fechaIngreso;
	private Date fechaNac;
	private Date fechaPago;
	private String identificacion;
	private String nombre;
	private boolean poseeVehiculo;
	private TipoUsuarioPOJO tipoUsuarioPOJO;
	private UsuarioPOJO usuarioPOJOInstructor;
	
	public UsuarioPOJO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public boolean isPoseeVehiculo() {
		return poseeVehiculo;
	}

	public void setPoseeVehiculo(boolean poseeVehiculo) {
		this.poseeVehiculo = poseeVehiculo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
