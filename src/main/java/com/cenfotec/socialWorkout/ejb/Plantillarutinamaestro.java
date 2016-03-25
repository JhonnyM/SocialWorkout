package com.cenfotec.socialWorkout.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the plantillarutinamaestro database table.
 * 
 */
@Entity
@NamedQuery(name="Plantillarutinamaestro.findAll", query="SELECT p FROM Plantillarutinamaestro p")
public class Plantillarutinamaestro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idRutina;

	private String descRutina;

	private byte rutinaBase;

	//bi-directional many-to-one association to Plantillarutinadetalle
	@OneToMany(mappedBy="plantillarutinamaestro")
	private List<Plantillarutinadetalle> plantillarutinadetalles;

	//bi-directional many-to-one association to Objetivo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idObjetivo")
	private Objetivo objetivo;

	//bi-directional many-to-one association to Plantillarutinamaestro
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idRutinaBase")
	private Plantillarutinamaestro plantillarutinamaestro;

	//bi-directional many-to-one association to Plantillarutinamaestro
	@OneToMany(mappedBy="plantillarutinamaestro")
	private List<Plantillarutinamaestro> plantillarutinamaestros;

	//bi-directional many-to-one association to Registroingreso
	@OneToMany(mappedBy="plantillarutinamaestro")
	private List<Registroingreso> registroingresos;

	//bi-directional many-to-one association to Rutinahasusuario
	@OneToMany(mappedBy="plantillarutinamaestro")
	private List<Rutinahasusuario> rutinahasusuarios;

	public Plantillarutinamaestro() {
	}

	public int getIdRutina() {
		return this.idRutina;
	}

	public void setIdRutina(int idRutina) {
		this.idRutina = idRutina;
	}

	public String getDescRutina() {
		return this.descRutina;
	}

	public void setDescRutina(String descRutina) {
		this.descRutina = descRutina;
	}

	public byte getRutinaBase() {
		return this.rutinaBase;
	}

	public void setRutinaBase(byte rutinaBase) {
		this.rutinaBase = rutinaBase;
	}

	public List<Plantillarutinadetalle> getPlantillarutinadetalles() {
		return this.plantillarutinadetalles;
	}

	public void setPlantillarutinadetalles(List<Plantillarutinadetalle> plantillarutinadetalles) {
		this.plantillarutinadetalles = plantillarutinadetalles;
	}

	public Plantillarutinadetalle addPlantillarutinadetalle(Plantillarutinadetalle plantillarutinadetalle) {
		getPlantillarutinadetalles().add(plantillarutinadetalle);
		plantillarutinadetalle.setPlantillarutinamaestro(this);

		return plantillarutinadetalle;
	}

	public Plantillarutinadetalle removePlantillarutinadetalle(Plantillarutinadetalle plantillarutinadetalle) {
		getPlantillarutinadetalles().remove(plantillarutinadetalle);
		plantillarutinadetalle.setPlantillarutinamaestro(null);

		return plantillarutinadetalle;
	}

	public Objetivo getObjetivo() {
		return this.objetivo;
	}

	public void setObjetivo(Objetivo objetivo) {
		this.objetivo = objetivo;
	}

	public Plantillarutinamaestro getPlantillarutinamaestro() {
		return this.plantillarutinamaestro;
	}

	public void setPlantillarutinamaestro(Plantillarutinamaestro plantillarutinamaestro) {
		this.plantillarutinamaestro = plantillarutinamaestro;
	}

	public List<Plantillarutinamaestro> getPlantillarutinamaestros() {
		return this.plantillarutinamaestros;
	}

	public void setPlantillarutinamaestros(List<Plantillarutinamaestro> plantillarutinamaestros) {
		this.plantillarutinamaestros = plantillarutinamaestros;
	}

	public Plantillarutinamaestro addPlantillarutinamaestro(Plantillarutinamaestro plantillarutinamaestro) {
		getPlantillarutinamaestros().add(plantillarutinamaestro);
		plantillarutinamaestro.setPlantillarutinamaestro(this);

		return plantillarutinamaestro;
	}

	public Plantillarutinamaestro removePlantillarutinamaestro(Plantillarutinamaestro plantillarutinamaestro) {
		getPlantillarutinamaestros().remove(plantillarutinamaestro);
		plantillarutinamaestro.setPlantillarutinamaestro(null);

		return plantillarutinamaestro;
	}

	public List<Registroingreso> getRegistroingresos() {
		return this.registroingresos;
	}

	public void setRegistroingresos(List<Registroingreso> registroingresos) {
		this.registroingresos = registroingresos;
	}

	public Registroingreso addRegistroingreso(Registroingreso registroingreso) {
		getRegistroingresos().add(registroingreso);
		registroingreso.setPlantillarutinamaestro(this);

		return registroingreso;
	}

	public Registroingreso removeRegistroingreso(Registroingreso registroingreso) {
		getRegistroingresos().remove(registroingreso);
		registroingreso.setPlantillarutinamaestro(null);

		return registroingreso;
	}

	public List<Rutinahasusuario> getRutinahasusuarios() {
		return this.rutinahasusuarios;
	}

	public void setRutinahasusuarios(List<Rutinahasusuario> rutinahasusuarios) {
		this.rutinahasusuarios = rutinahasusuarios;
	}

	/*public Rutinahasusuario addRutinahasusuario(Rutinahasusuario rutinahasusuario) {
		getRutinahasusuarios().add(rutinahasusuario);
		rutinahasusuario.setPlantillarutinamaestro(this);

		return rutinahasusuario;
	}

	public Rutinahasusuario removeRutinahasusuario(Rutinahasusuario rutinahasusuario) {
		getRutinahasusuarios().remove(rutinahasusuario);
		rutinahasusuario.setPlantillarutinamaestro(null);

		return rutinahasusuario;
	}
*/
}