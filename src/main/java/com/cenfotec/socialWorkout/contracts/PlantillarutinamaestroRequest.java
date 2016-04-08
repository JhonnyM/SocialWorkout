package com.cenfotec.socialWorkout.contracts;

import com.cenfotec.socialWorkout.pojo.PlantillarutinamaestroPOJO;

public class PlantillarutinamaestroRequest {

	private PlantillarutinamaestroPOJO plantilla;

	public PlantillarutinamaestroRequest() {
		super();
	}
	public PlantillarutinamaestroPOJO getPlantillaRutinaMaestro() {
		return plantilla;
	}

	public void setPlantillaRutinaMaestro(PlantillarutinamaestroPOJO plantilla) {
		this.plantilla = plantilla;
	}

}
