package com.cenfotec.socialWorkout.contracts;
import com.cenfotec.socialWorkout.pojo.ClasePOJO;

public class ClaseRequest extends BaseRequest {
	
	private ClasePOJO clase;
		
	public ClaseRequest() {
		super();
	}
	
	public ClasePOJO getClase() {
		return clase;
	}
	
	public void setClase(ClasePOJO clase) {
		this.clase = clase;
	}

	@Override
	public String toString() {
		return "ClaseRequest [clase=" + clase + "]";
	}
}

