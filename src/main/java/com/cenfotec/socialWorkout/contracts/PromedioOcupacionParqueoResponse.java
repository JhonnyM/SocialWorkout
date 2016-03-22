package com.cenfotec.socialWorkout.contracts;
import java.util.List;
import com.cenfotec.socialWorkout.pojo.PromedioOcupacionParqueoPOJO;
public class PromedioOcupacionParqueoResponse extends BaseResponse{
	
	private List<PromedioOcupacionParqueoPOJO> ocupacion;

	public PromedioOcupacionParqueoResponse() {
		super();
	}
	
	public List<PromedioOcupacionParqueoPOJO> getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(List<PromedioOcupacionParqueoPOJO>ocupacion) {
		this.ocupacion = ocupacion;
	}


}

