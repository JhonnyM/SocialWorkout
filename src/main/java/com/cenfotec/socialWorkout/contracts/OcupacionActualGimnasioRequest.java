package com.cenfotec.socialWorkout.contracts;
import com.cenfotec.socialWorkout.pojo.OcupacionActualGimnasioPOJO;

public class OcupacionActualGimnasioRequest extends BaseRequest{
	
	private OcupacionActualGimnasioPOJO ocupacion;

	public OcupacionActualGimnasioRequest() {
		super();
	}
	public OcupacionActualGimnasioPOJO getOcupacion() {
		return ocupacion;
	}

	public void setTipo(OcupacionActualGimnasioPOJO ocupacion) {
		this.ocupacion = ocupacion;
	}
	
	
	
}
