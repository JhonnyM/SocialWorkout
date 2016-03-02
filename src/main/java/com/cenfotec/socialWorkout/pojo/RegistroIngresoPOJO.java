package com.cenfotec.socialWorkout.pojo;

import java.util.Date;

import com.cenfotec.socialWorkout.ejb.Plantillarutinamaestro;
import com.cenfotec.socialWorkout.ejb.Usuario;

public class RegistroIngresoPOJO {
	
	private int idRegistroIngreso;
	private Date fechaHoraIngreso;
	private Date fechaHoraSalida;
	private Usuario usuario1;
	private Usuario usuario2;
	private Plantillarutinamaestro plantillarutinamaestro;
	
	public RegistroIngresoPOJO(){
		super();
	}
	
	public int getIdRegistroIngreso() {
		return idRegistroIngreso;
	}

	public void setIdRegistroIngreso(int idRegistroIngreso) {
		this.idRegistroIngreso = idRegistroIngreso;
	}

	public Date getFechaHoraIngreso() {
		return fechaHoraIngreso;
	}

	public void setFechaHoraIngreso(Date fechaHoraIngreso) {
		this.fechaHoraIngreso = fechaHoraIngreso;
	}

	public Date getFechaHoraSalida() {
		return fechaHoraSalida;
	}

	public void setFechaHoraSalida(Date fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
	}

	public Usuario getUsuario1() {
		return usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}

	public Usuario getUsuario2() {
		return usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}

	public Plantillarutinamaestro getPlantillarutinamaestro() {
		return plantillarutinamaestro;
	}

	public void setPlantillarutinamaestro(Plantillarutinamaestro plantillarutinamaestro) {
		this.plantillarutinamaestro = plantillarutinamaestro;
	}
}
