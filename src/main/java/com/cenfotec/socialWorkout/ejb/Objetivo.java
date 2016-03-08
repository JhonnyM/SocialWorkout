package com.cenfotec.socialWorkout.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the objetivo database table.
 * 
 */
@Entity
@NamedQuery(name="Objetivo.findAll", query="SELECT o FROM Objetivo o")
public class Objetivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idObjetivo;

	private String descObjetivo;

	//bi-directional many-to-one association to Plantillarutinamaestro
	@OneToMany(mappedBy="objetivo")
	private List<Plantillarutinamaestro> plantillarutinamaestros;

	public Objetivo() {
	}

	public int getIdObjetivo() {
		return this.idObjetivo;
	}

	public void setIdObjetivo(int idObjetivo) {
		this.idObjetivo = idObjetivo;
	}

	public String getDescObjetivo() {
		return this.descObjetivo;
	}

	public void setDescObjetivo(String descObjetivo) {
		this.descObjetivo = descObjetivo;
	}

	public List<Plantillarutinamaestro> getPlantillarutinamaestros() {
		return this.plantillarutinamaestros;
	}

	public void setPlantillarutinamaestros(List<Plantillarutinamaestro> plantillarutinamaestros) {
		this.plantillarutinamaestros = plantillarutinamaestros;
	}

	public Plantillarutinamaestro addPlantillarutinamaestro(Plantillarutinamaestro plantillarutinamaestro) {
		getPlantillarutinamaestros().add(plantillarutinamaestro);
		plantillarutinamaestro.setObjetivo(this);

		return plantillarutinamaestro;
	}

	public Plantillarutinamaestro removePlantillarutinamaestro(Plantillarutinamaestro plantillarutinamaestro) {
		getPlantillarutinamaestros().remove(plantillarutinamaestro);
		plantillarutinamaestro.setObjetivo(null);

		return plantillarutinamaestro;
	}

}