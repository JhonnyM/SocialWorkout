package com.cenfotec.socialWorkout.pojo;

import java.util.List;

public class PlantillarutinamaestroPOJO {

	private int idRutina;
	private String descRutina;
	private boolean rutinaBase;
	private List<PlantillarutinadetallePOJO> plantillarutinadetalles;
	private ObjetivoPOJO objetivo;
	private PlantillarutinamaestroPOJO plantillarutinamaestro;
	private List<PlantillarutinamaestroPOJO> plantillarutinamaestros;
	private List<RutinahasusuarioPOJO> rutinahasusuarios;

	public PlantillarutinamaestroPOJO() {
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

	public boolean getRutinaBase() {
		return this.rutinaBase;
	}

	public void setRutinaBase(boolean rutinaBase) {
		this.rutinaBase = rutinaBase;
	}

	public List<PlantillarutinadetallePOJO> getPlantillarutinadetalles() {
		return this.plantillarutinadetalles;
	}

	public void setPlantillarutinadetalles(List<PlantillarutinadetallePOJO> plantillarutinadetalles) {
		this.plantillarutinadetalles = plantillarutinadetalles;
	}

	public PlantillarutinadetallePOJO addPlantillarutinadetalle(PlantillarutinadetallePOJO plantillarutinadetalle) {
		getPlantillarutinadetalles().add(plantillarutinadetalle);
		plantillarutinadetalle.setPlantillarutinamaestro(this);

		return plantillarutinadetalle;
	}

	public PlantillarutinadetallePOJO removePlantillarutinadetalle(PlantillarutinadetallePOJO plantillarutinadetalle) {
		getPlantillarutinadetalles().remove(plantillarutinadetalle);
		plantillarutinadetalle.setPlantillarutinamaestro(null);

		return plantillarutinadetalle;
	}

	public ObjetivoPOJO getObjetivo() {
		return this.objetivo;
	}

	public void setObjetivo(ObjetivoPOJO objetivo) {
		this.objetivo = objetivo;
	}

	public PlantillarutinamaestroPOJO getPlantillarutinamaestro() {
		return this.plantillarutinamaestro;
	}

	public void setPlantillarutinamaestro(PlantillarutinamaestroPOJO plantillarutinamaestro) {
		this.plantillarutinamaestro = plantillarutinamaestro;
	}

	public List<PlantillarutinamaestroPOJO> getPlantillarutinamaestros() {
		return this.plantillarutinamaestros;
	}

	public void setPlantillarutinamaestros(List<PlantillarutinamaestroPOJO> plantillarutinamaestros) {
		this.plantillarutinamaestros = plantillarutinamaestros;
	}

	public PlantillarutinamaestroPOJO addPlantillarutinamaestro(PlantillarutinamaestroPOJO plantillarutinamaestro) {
		getPlantillarutinamaestros().add(plantillarutinamaestro);
		plantillarutinamaestro.setPlantillarutinamaestro(this);

		return plantillarutinamaestro;
	}

	public PlantillarutinamaestroPOJO removePlantillarutinamaestro(PlantillarutinamaestroPOJO plantillarutinamaestro) {
		getPlantillarutinamaestros().remove(plantillarutinamaestro);
		plantillarutinamaestro.setPlantillarutinamaestro(null);

		return plantillarutinamaestro;
	}

	public List<RutinahasusuarioPOJO> getRutinahasusuarios() {
		return this.rutinahasusuarios;
	}

	public void setRutinahasusuarios(List<RutinahasusuarioPOJO> rutinahasusuarios) {
		this.rutinahasusuarios = rutinahasusuarios;
	}

	public RutinahasusuarioPOJO addRutinahasusuario(RutinahasusuarioPOJO rutinahasusuario) {
		getRutinahasusuarios().add(rutinahasusuario);
		rutinahasusuario.setPlantillarutinamaestro(this);

		return rutinahasusuario;
	}

	public RutinahasusuarioPOJO removeRutinahasusuario(RutinahasusuarioPOJO rutinahasusuario) {
		getRutinahasusuarios().remove(rutinahasusuario);
		rutinahasusuario.setPlantillarutinamaestro(null);

		return rutinahasusuario;
	}

}
