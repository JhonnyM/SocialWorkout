package com.cenfotec.socialWorkout.contracts;

import java.util.List;
import com.cenfotec.socialWorkout.pojo.PlantillarutinamaestroPOJO;

public class PlantillarutinamaestroResponse extends BaseResponse {
	
	private List<PlantillarutinamaestroPOJO> plantillas;
	private PlantillarutinamaestroPOJO plantilla;
	private int nulo;

	public PlantillarutinamaestroResponse() {
		super();
	}
	
	public List<PlantillarutinamaestroPOJO> getPlantillas() {
		return plantillas;
	}

	public void setPlantillas(List<PlantillarutinamaestroPOJO> plantillas) {
		this.plantillas = plantillas;
	}

	public PlantillarutinamaestroPOJO getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(PlantillarutinamaestroPOJO plantilla) {
		this.plantilla = plantilla;
	}

	public int getNulo() {
		return nulo;
	}

	public void setNulo(int nulo) {
		this.nulo = nulo;
	}

}
