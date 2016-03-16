package com.cenfotec.socialWorkout.contracts;

import java.util.List;
import com.cenfotec.socialWorkout.pojo.ClasePOJO;

public class ClaseResponse extends BaseResponse {
	
	private List<ClasePOJO> clases;
	private ClasePOJO clase;

	public ClaseResponse() {
		super();
	}
	
	public List<ClasePOJO> getClases() {
		return clases;
	}

	public void setClases(List<ClasePOJO> clases) {
		this.clases = clases;
	}

	public ClasePOJO getClase() {
		return clase;
	}

	public void setClase(ClasePOJO clase) {
		this.clase = clase;
	}

}
