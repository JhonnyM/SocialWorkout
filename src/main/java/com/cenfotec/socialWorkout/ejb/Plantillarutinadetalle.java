package com.cenfotec.socialWorkout.ejb;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the plantillarutinadetalle database table.
 * 
 */
@Entity
@NamedQuery(name="Plantillarutinadetalle.findAll", query="SELECT p FROM Plantillarutinadetalle p")
public class Plantillarutinadetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idLineaEjercicioMaquina;

	private double cantidadPeso;

	private int cantidadRepeticiones;

	private int cantidadSeries;

	//bi-directional many-to-one association to Maquinahasejercicio
	@ManyToOne
	@JoinColumn(name="idEjercicioXMaquina")
	private Maquinahasejercicio maquinahasejercicio;

	//bi-directional many-to-one association to Plantillarutinamaestro
	@ManyToOne
	@JoinColumn(name="idRutina")
	private Plantillarutinamaestro plantillarutinamaestro;

	public Plantillarutinadetalle() {
	}

	public int getIdLineaEjercicioMaquina() {
		return this.idLineaEjercicioMaquina;
	}

	public void setIdLineaEjercicioMaquina(int idLineaEjercicioMaquina) {
		this.idLineaEjercicioMaquina = idLineaEjercicioMaquina;
	}

	public double getCantidadPeso() {
		return this.cantidadPeso;
	}

	public void setCantidadPeso(double cantidadPeso) {
		this.cantidadPeso = cantidadPeso;
	}

	public int getCantidadRepeticiones() {
		return this.cantidadRepeticiones;
	}

	public void setCantidadRepeticiones(int cantidadRepeticiones) {
		this.cantidadRepeticiones = cantidadRepeticiones;
	}

	public int getCantidadSeries() {
		return this.cantidadSeries;
	}

	public void setCantidadSeries(int cantidadSeries) {
		this.cantidadSeries = cantidadSeries;
	}

	public Maquinahasejercicio getMaquinahasejercicio() {
		return this.maquinahasejercicio;
	}

	public void setMaquinahasejercicio(Maquinahasejercicio maquinahasejercicio) {
		this.maquinahasejercicio = maquinahasejercicio;
	}

	public Plantillarutinamaestro getPlantillarutinamaestro() {
		return this.plantillarutinamaestro;
	}

	public void setPlantillarutinamaestro(Plantillarutinamaestro plantillarutinamaestro) {
		this.plantillarutinamaestro = plantillarutinamaestro;
	}

}