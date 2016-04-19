package com.cenfotec.socialWorkout.contracts;
import com.cenfotec.socialWorkout.pojo.PromedioRutinasMaquinaPOJO;

public class PromedioRutinasMaquinaRequest extends BaseRequest{
	
	private PromedioRutinasMaquinaPOJO ocupacion;

	public PromedioRutinasMaquinaRequest() {
		super();
	}
	public PromedioRutinasMaquinaPOJO getOcupacion() {
		return ocupacion;
	}

	public void setTipo(PromedioRutinasMaquinaPOJO ocupacion) {
		this.ocupacion = ocupacion;
	}
	
	
	
}
