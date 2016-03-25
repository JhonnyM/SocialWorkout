package com.cenfotec.socialWorkout.contracts;
import java.util.List;
import com.cenfotec.socialWorkout.pojo.OcupacionActualGimnasioPOJO;
import com.cenfotec.socialWorkout.pojo.UsuarioPOJO;
public class OcupacionActualGimnasioResponse extends BaseResponse{
	
	private List<OcupacionActualGimnasioPOJO> ocupacion;

	public OcupacionActualGimnasioResponse() {
		super();
	}
	
	public List<OcupacionActualGimnasioPOJO> getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(List<OcupacionActualGimnasioPOJO>ocupacion) {
		this.ocupacion = ocupacion;
	}


}

