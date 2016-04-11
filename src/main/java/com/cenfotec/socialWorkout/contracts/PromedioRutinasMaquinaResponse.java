package com.cenfotec.socialWorkout.contracts;
import java.sql.Time;
import java.util.List;
import com.cenfotec.socialWorkout.pojo.PromedioRutinasMaquinaPOJO;
public class PromedioRutinasMaquinaResponse extends BaseResponse{
	
	private List<PromedioRutinasMaquinaPOJO> ocupacion;
	private int nulo;
  
	public PromedioRutinasMaquinaResponse() {
		super();
	}
	
	public List<PromedioRutinasMaquinaPOJO> getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(List<PromedioRutinasMaquinaPOJO>ocupacion) {
		this.ocupacion = ocupacion;
	}

	public int getNulo() {
		return nulo;
	}

	public void setNulo(int nulo) {
		this.nulo = nulo;
	}

}

