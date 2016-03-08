package com.cenfotec.socialWorkout.contracts;
import com.cenfotec.socialWorkout.pojo.ObjetivoPOJO;
import java.util.List;

public class ObjetivoResponse extends BaseResponse{

	private List<ObjetivoPOJO> objetivoList;

	public ObjetivoResponse() {
	 	super();
	}

	public List<ObjetivoPOJO> getObjetivoList() {
	 	return objetivoList;
	}

	public void setObjetivoList(List<ObjetivoPOJO> objetivoList) {
	 	this.objetivoList = objetivoList;
	}

}
