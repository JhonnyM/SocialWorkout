package com.cenfotec.socialWorkout.contracts;

import java.util.List;
import com.cenfotec.socialWorkout.pojo.PlantillarutinadetallePOJO;

public class PlantillarutinadetalleResponse extends BaseResponse {
	
	private List<PlantillarutinadetallePOJO> detallesPlantillas;
	private PlantillarutinadetallePOJO detallePlantilla;

	public PlantillarutinadetalleResponse() {
		super();
	}
	
	public List<PlantillarutinadetallePOJO> getPlantillasDetalle() {
		return detallesPlantillas;
	}

	public void setPlantillasDetalle(List<PlantillarutinadetallePOJO> detallesPlantillas) {
		this.detallesPlantillas = detallesPlantillas;
	}

	public PlantillarutinadetallePOJO getPlantillaDetalle() {
		return detallePlantilla;
	}

	public void setPlantillaDetalle(PlantillarutinadetallePOJO detallePlantilla) {
		this.detallePlantilla = detallePlantilla;
	}

}
