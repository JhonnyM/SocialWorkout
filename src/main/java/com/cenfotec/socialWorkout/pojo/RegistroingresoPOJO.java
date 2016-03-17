package com.cenfotec.socialWorkout.pojo;

import java.util.Date;


public class RegistroingresoPOJO {

	private int idRegistroIngreso;
	private Date fechaHoraIngreso;
	private Date horaSalida;
	private UsuarioPOJO usuario1;
	private UsuarioPOJO usuario2;
	private PlantillarutinamaestroPOJO plantillarutinamaestro;

	public RegistroingresoPOJO() {
	}

	public int getIdRegistroIngreso() {
		return this.idRegistroIngreso;
	}

	public void setIdRegistroIngreso(int idRegistroIngreso) {
		this.idRegistroIngreso = idRegistroIngreso;
	}

	public Date getFechaHoraIngreso() {
		return this.fechaHoraIngreso;
	}

	public void setFechaHoraIngreso(Date fechaHoraIngreso) {
		this.fechaHoraIngreso = fechaHoraIngreso;
	}

	public Date getHoraSalida() {
		return this.horaSalida;
	}

	public void setHoraSalida(Date horaSalida) {
		this.horaSalida = horaSalida;
	}

	public UsuarioPOJO getUsuario1() {
		return this.usuario1;
	}

	public void setUsuario1(UsuarioPOJO usuario1) {
		this.usuario1 = usuario1;
	}

	public UsuarioPOJO getUsuario2() {
		return this.usuario2;
	}

	public void setUsuario2(UsuarioPOJO usuario2) {
		this.usuario2 = usuario2;
	}

	public PlantillarutinamaestroPOJO getPlantillarutinamaestro() {
		return this.plantillarutinamaestro;
	}

	public void setPlantillarutinamaestro(PlantillarutinamaestroPOJO plantillarutinamaestro) {
		this.plantillarutinamaestro = plantillarutinamaestro;
	}

}
