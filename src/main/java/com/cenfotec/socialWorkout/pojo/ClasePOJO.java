package com.cenfotec.socialWorkout.pojo;
import java.util.List;


public class ClasePOJO {

	private int idClase;
	private String descClase;
	private List<AgendaclasPOJO> agendaclases;

	public ClasePOJO() {
	}

	public int getIdClase() {
		return this.idClase;
	}

	public void setIdClase(int idClase) {
		this.idClase = idClase;
	}

	public String getDescClase() {
		return this.descClase;
	}

	public void setDescClase(String descClase) {
		this.descClase = descClase;
	}

	public List<AgendaclasPOJO> getAgendaclases() {
		return this.agendaclases;
	}

	public void setAgendaclases(List<AgendaclasPOJO> agendaclases) {
		this.agendaclases = agendaclases;
	}

	public AgendaclasPOJO addAgendaclas(AgendaclasPOJO agendaclas) {
		getAgendaclases().add(agendaclas);
		agendaclas.setClase(this);

		return agendaclas;
	}

	public AgendaclasPOJO removeAgendaclas(AgendaclasPOJO agendaclas) {
		getAgendaclases().remove(agendaclas);
		agendaclas.setClase(null);

		return agendaclas;
	}

}
