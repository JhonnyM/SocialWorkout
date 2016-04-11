package com.cenfotec.socialWorkout.contracts;
import com.cenfotec.socialWorkout.pojo.PromedioOcupacionPOJO;

public class PromedioOcupacionRequest extends BaseRequest{
	
	private PromedioOcupacionPOJO ocupacion;

	public PromedioOcupacionRequest() {
		super();
	}
	public PromedioOcupacionPOJO getOcupacion() {
		return ocupacion;
	}

	public void setTipo(PromedioOcupacionPOJO ocupacion) {
		this.ocupacion = ocupacion;
	}
	
	
	
}
