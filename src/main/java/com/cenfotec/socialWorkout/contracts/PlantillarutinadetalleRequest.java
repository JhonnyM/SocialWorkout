package com.cenfotec.socialWorkout.contracts;

import com.cenfotec.socialWorkout.pojo.PlantillarutinadetallePOJO;

public class PlantillarutinadetalleRequest {

	private PlantillarutinadetallePOJO plantillaDetalle;

	public PlantillarutinadetalleRequest() {
		super();
	}
	public PlantillarutinadetallePOJO getPlantillaRutinaDetalle() {
		return plantillaDetalle;
	}

	public void setPlantillaRutinaDetalle(PlantillarutinadetallePOJO plantillaDetalle) {
		this.plantillaDetalle = plantillaDetalle;
	}

}
