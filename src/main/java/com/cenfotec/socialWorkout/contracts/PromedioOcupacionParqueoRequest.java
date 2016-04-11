package com.cenfotec.socialWorkout.contracts;
import com.cenfotec.socialWorkout.pojo.PromedioOcupacionParqueoPOJO;

public class PromedioOcupacionParqueoRequest extends BaseRequest{
	
	private PromedioOcupacionParqueoPOJO ocupacion;

	public PromedioOcupacionParqueoRequest() {
		super();
	}
	public PromedioOcupacionParqueoPOJO getOcupacion() {
		return ocupacion;
	}

	public void setTipo(PromedioOcupacionParqueoPOJO ocupacion) {
		this.ocupacion = ocupacion;
	}
	
	
	
}
