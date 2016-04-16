package com.cenfotec.socialWorkout.contracts;
import com.cenfotec.socialWorkout.pojo.RutinaHasUsuarioPOJO;

public class RutinaHasUsuarioRequest extends BaseRequest {

	private RutinaHasUsuarioPOJO rutinaHasUsuarioPOJO;
	
	public RutinaHasUsuarioRequest(){
		super();
	}
	
	public RutinaHasUsuarioPOJO getRutinaHasUsuarioPOJO() {
		return rutinaHasUsuarioPOJO;
	}

	public void setRutinaHasUsuarioPOJO(RutinaHasUsuarioPOJO rutinaHasUsuarioPOJO) {
		this.rutinaHasUsuarioPOJO = rutinaHasUsuarioPOJO;
	}

	@Override
	public String toString() {
		return "RutinaHasUsuarioRequest [rutinaHasUsuarioPOJO=" + rutinaHasUsuarioPOJO + "]";
	}

}
