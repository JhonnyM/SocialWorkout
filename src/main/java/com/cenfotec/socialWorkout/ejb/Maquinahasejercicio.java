package com.cenfotec.socialWorkout.ejb;
import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the maquinahasejercicio database table.
 * 
 */
@Entity
@NamedQuery(name="Maquinahasejercicio.findAll", query="SELECT m FROM Maquinahasejercicio m")
public class Maquinahasejercicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idEjercicioXMaquina;

	//bi-directional many-to-one association to Ejercicio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idEjercicio")
	private Ejercicio ejercicio;

	//bi-directional many-to-one association to Maquina
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idMaquina")
	private Maquina maquina;

	//bi-directional many-to-one association to Plantillarutinadetalle
	@OneToMany(mappedBy="maquinahasejercicio")
	private List<Plantillarutinadetalle> plantillarutinadetalles;

	public Maquinahasejercicio() {
	}

	public int getIdEjercicioXMaquina() {
		return this.idEjercicioXMaquina;
	}

	public void setIdEjercicioXMaquina(int idEjercicioXMaquina) {
		this.idEjercicioXMaquina = idEjercicioXMaquina;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public void setEjercicio(Ejercicio ejercicio) {
		this.ejercicio = ejercicio;
	}

	public Maquina getMaquina() {
		return this.maquina;
	}

	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}

	public List<Plantillarutinadetalle> getPlantillarutinadetalles() {
		return this.plantillarutinadetalles;
	}

	public void setPlantillarutinadetalles(List<Plantillarutinadetalle> plantillarutinadetalles) {
		this.plantillarutinadetalles = plantillarutinadetalles;
	}

	public Plantillarutinadetalle addPlantillarutinadetalle(Plantillarutinadetalle plantillarutinadetalle) {
		getPlantillarutinadetalles().add(plantillarutinadetalle);
		plantillarutinadetalle.setMaquinahasejercicio(this);

		return plantillarutinadetalle;
	}

	public Plantillarutinadetalle removePlantillarutinadetalle(Plantillarutinadetalle plantillarutinadetalle) {
		getPlantillarutinadetalles().remove(plantillarutinadetalle);
		plantillarutinadetalle.setMaquinahasejercicio(null);

		return plantillarutinadetalle;
	}

}