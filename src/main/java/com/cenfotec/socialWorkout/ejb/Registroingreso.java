package com.cenfotec.socialWorkout.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the registroingreso database table.
 * 
 */
@Entity
@NamedQuery(name="Registroingreso.findAll", query="SELECT r FROM Registroingreso r")
public class Registroingreso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idRegistroIngreso;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHoraIngreso;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHoraSalida;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuarioInstructor")
	private Usuario usuario2;

	//bi-directional many-to-one association to Plantillarutinamaestro
	@ManyToOne
	@JoinColumn(name="idRutina")
	private Plantillarutinamaestro plantillarutinamaestro;

	public Registroingreso() {
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

	public Date getFechaHoraSalida() {
		return this.fechaHoraSalida;
	}

	public void setFechaHoraSalida(Date fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
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

	public Plantillarutinamaestro getPlantillarutinamaestro() {
		return this.plantillarutinamaestro;
	}

	public void setPlantillarutinamaestro(Plantillarutinamaestro plantillarutinamaestro) {
		this.plantillarutinamaestro = plantillarutinamaestro;
	}

}