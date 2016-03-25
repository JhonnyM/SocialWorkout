package com.cenfotec.socialWorkout.contracts;
import java.util.List;
import com.cenfotec.socialWorkout.pojo.OcupacionActualParqueoPOJO;
public class OcupacionActualParqueoResponse extends BaseResponse{
	
	private List<OcupacionActualParqueoPOJO> ocupacion;

	public OcupacionActualParqueoResponse() {
		super();
	}
	
	public List<OcupacionActualParqueoPOJO> getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(List<OcupacionActualParqueoPOJO>ocupacion) {
		this.ocupacion = ocupacion;
	}


}

