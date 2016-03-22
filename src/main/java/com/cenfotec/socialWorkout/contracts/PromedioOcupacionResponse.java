package com.cenfotec.socialWorkout.contracts;
import java.util.List;
import com.cenfotec.socialWorkout.pojo.PromedioOcupacionPOJO;
public class PromedioOcupacionResponse extends BaseResponse{
	
	private List<PromedioOcupacionPOJO> ocupacion;

	public PromedioOcupacionResponse() {
		super();
	}
	
	public List<PromedioOcupacionPOJO> getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(List<PromedioOcupacionPOJO>ocupacion) {
		this.ocupacion = ocupacion;
	}


}

