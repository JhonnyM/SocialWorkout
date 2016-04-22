package com.cenfotec.socialWorkout.contracts;
import java.util.List;

import com.cenfotec.socialWorkout.pojo.RutinaHasUsuarioPOJO;

public class RutinaHasUsuarioResponse extends BaseResponse {

	private List<RutinaHasUsuarioPOJO> rutinasHasUsuarioPOJO;
	private RutinaHasUsuarioPOJO rutinaHasUsuarioPOJO;
	private int nulo;

	public RutinaHasUsuarioResponse(){
		super();
	}

	public List<RutinaHasUsuarioPOJO> getRutinasHasUsuarioPOJO() {
		return rutinasHasUsuarioPOJO;
	}

	public void setRutinasHasUsuarioPOJO(List<RutinaHasUsuarioPOJO> rutinasHasUsuarioPOJO) {
		this.rutinasHasUsuarioPOJO = rutinasHasUsuarioPOJO;
	}

	public int getNulo() {
		return nulo;
	}

	public void setNulo(int nulo) {
		this.nulo = nulo;
	}

	public RutinaHasUsuarioPOJO getRutinaHasUsuarioPOJO() {
		return rutinaHasUsuarioPOJO;
	}

	public void setRutinaHasUsuarioPOJO(RutinaHasUsuarioPOJO rutinaHasUsuarioPOJO) {
		this.rutinaHasUsuarioPOJO = rutinaHasUsuarioPOJO;
	}



	
}

