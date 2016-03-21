package com.cenfotec.socialWorkout.contracts;
import java.util.List;
import com.cenfotec.socialWorkout.pojo.PromedioOcupacionParqueoPOJO;
public class PromedioOcupacionParqueoResponse extends BaseResponse{
	
	private List<PromedioOcupacionParqueoPOJO> ocupacion;
	private int nulo;
	
	public PromedioOcupacionParqueoResponse() {
		super();
	}
	
	public List<PromedioOcupacionParqueoPOJO> getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(List<PromedioOcupacionParqueoPOJO>ocupacion) {
		this.ocupacion = ocupacion;
	}

	public int getNulo() {
		return nulo;
	}

	public void setNulo(int nulo) {
		this.nulo = nulo;
	}


}

