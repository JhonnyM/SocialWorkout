package com.cenfotec.socialWorkout.contracts;
import com.cenfotec.socialWorkout.pojo.ObjetivoPOJO;

public class ObjetivoRequest extends BaseRequest{

	private ObjetivoPOJO objetivo;

	public ObjetivoRequest(){
		super();
	}
	
	public ObjetivoPOJO getObjetivo(){
		return objetivo;
	}
	
	public void setObjetivo(ObjetivoPOJO  objetivo){
		this.objetivo = objetivo;
	}
	
	@Override
	public String toString(){
		return "ObjetivoRequest [objetivo=" + objetivo + "]";
	}

}
