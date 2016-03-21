package com.cenfotec.socialWorkout.contracts;
import java.sql.Time;
import java.util.List;
import com.cenfotec.socialWorkout.pojo.PromedioOcupacionPOJO;
public class PromedioOcupacionResponse extends BaseResponse{
	
	private List<PromedioOcupacionPOJO> ocupacion;
	private int nulo;
  
	public PromedioOcupacionResponse() {
		super();
	}
	
	public List<PromedioOcupacionPOJO> getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(List<PromedioOcupacionPOJO>ocupacion) {
		this.ocupacion = ocupacion;
	}

	public int getNulo() {
		return nulo;
	}

	public void setNulo(int nulo) {
		this.nulo = nulo;
	}

}

