package com.cenfotec.socialWorkout.contracts;
import com.cenfotec.socialWorkout.pojo.OcupacionActualParqueoPOJO;

public class OcupacionActualParqueoRequest extends BaseRequest{
	
	private OcupacionActualParqueoPOJO ocupacion;

	public OcupacionActualParqueoRequest() {
		super();
	}
	public OcupacionActualParqueoPOJO getOcupacion() {
		return ocupacion;
	}

	public void setTipo(OcupacionActualParqueoPOJO ocupacion) {
		this.ocupacion = ocupacion;
	}
	
	
	
}
