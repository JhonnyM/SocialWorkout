package com.cenfotec.socialWorkout.contracts;

import com.cenfotec.socialWorkout.pojo.PlantillarutinadetallePOJO;

public class PlantillarutinadetalleRequest {

	private PlantillarutinadetallePOJO plantillaDetalle;

	public PlantillarutinamaestroRequest() {
		super();
	}
	public PlantillarutinadetallePOJO getPlantillaRutinaMaestro() {
		return plantillaDetalle;
	}

	public void setPlantillaRutinaMaestro(PlantillarutinadetallePOJO plantillaDetalle) {
		this.plantillaDetalle = plantillaDetalle;
	}

}
