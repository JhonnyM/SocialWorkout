package com.cenfotec.socialWorkout.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the eventos database table.
 * 
 */
@Entity
@Table(name="eventos")
@NamedQuery(name="Evento.findAll", query="SELECT e FROM Evento e")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idEvento;

	private String descEvento;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHoraFinal;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHoraInicio;

	private String observaciones;

	//bi-directional many-to-one association to Eventoshasusuario
	@OneToMany(mappedBy="evento")
	private List<Eventoshasusuario> eventoshasusuarios;

	public Evento() {
	}

	public int getIdEvento() {
		return this.idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public String getDescEvento() {
		return this.descEvento;
	}

	public void setDescEvento(String descEvento) {
		this.descEvento = descEvento;
	}

	public Date getFechaHoraFinal() {
		return this.fechaHoraFinal;
	}

	public void setFechaHoraFinal(Date fechaHoraFinal) {
		this.fechaHoraFinal = fechaHoraFinal;
	}

	public Date getFechaHoraInicio() {
		return this.fechaHoraInicio;
	}

	public void setFechaHoraInicio(Date fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public List<Eventoshasusuario> getEventoshasusuarios() {
		return this.eventoshasusuarios;
	}

	public void setEventoshasusuarios(List<Eventoshasusuario> eventoshasusuarios) {
		this.eventoshasusuarios = eventoshasusuarios;
	}

	public Eventoshasusuario addEventoshasusuario(Eventoshasusuario eventoshasusuario) {
		getEventoshasusuarios().add(eventoshasusuario);
		eventoshasusuario.setEvento(this);

		return eventoshasusuario;
	}

	public Eventoshasusuario removeEventoshasusuario(Eventoshasusuario eventoshasusuario) {
		getEventoshasusuarios().remove(eventoshasusuario);
		eventoshasusuario.setEvento(null);

		return eventoshasusuario;
	}

}