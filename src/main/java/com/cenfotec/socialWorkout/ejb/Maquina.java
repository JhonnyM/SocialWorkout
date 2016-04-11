package com.cenfotec.socialWorkout.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the maquina database table.
 * 
 */
@Entity
@NamedQuery(name="Maquina.findAll", query="SELECT m FROM Maquina m")
public class Maquina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idMaquina;

	private int cantidad;

	private String descMaquina;

	private int minutosXPersona;

	private int personasXMaquina;

	//bi-directional many-to-one association to Maquinahasejercicio
	@OneToMany(mappedBy="maquina")
	private List<Maquinahasejercicio> maquinahasejercicios;

	public Maquina() {
	}

	public int getIdMaquina() {
		return this.idMaquina;
	}

	public void setIdMaquina(int idMaquina) {
		this.idMaquina = idMaquina;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescMaquina() {
		return this.descMaquina;
	}

	public void setDescMaquina(String descMaquina) {
		this.descMaquina = descMaquina;
	}

	public int getMinutosXPersona() {
		return this.minutosXPersona;
	}

	public void setMinutosXPersona(int minutosXPersona) {
		this.minutosXPersona = minutosXPersona;
	}

	public int getPersonasXMaquina() {
		return this.personasXMaquina;
	}

	public void setPersonasXMaquina(int personasXMaquina) {
		this.personasXMaquina = personasXMaquina;
	}

	public List<Maquinahasejercicio> getMaquinahasejercicios() {
		return this.maquinahasejercicios;
	}

	public void setMaquinahasejercicios(List<Maquinahasejercicio> maquinahasejercicios) {
		this.maquinahasejercicios = maquinahasejercicios;
	}

	public Maquinahasejercicio addMaquinahasejercicio(Maquinahasejercicio maquinahasejercicio) {
		getMaquinahasejercicios().add(maquinahasejercicio);
		maquinahasejercicio.setMaquina(this);

		return maquinahasejercicio;
	}

	public Maquinahasejercicio removeMaquinahasejercicio(Maquinahasejercicio maquinahasejercicio) {
		getMaquinahasejercicios().remove(maquinahasejercicio);
		maquinahasejercicio.setMaquina(null);

		return maquinahasejercicio;
	}

}