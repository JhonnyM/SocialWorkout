package com.cenfotec.socialWorkout.contracts;
import java.util.List;
import com.cenfotec.socialWorkout.pojo.TipoUsuarioPOJO;
public class TipoUsuarioResponse extends BaseResponse{
	private List<TipoUsuarioPOJO> tipoUsuariosList;

	public TipoUsuarioResponse() {
		super();
	}
	public TipoUsuarioResponse(List<TipoUsuarioPOJO> tipoUsuariosList) {
		super();
		setTipoUsuariosList(tipoUsuariosList);
	}
	
	public List<TipoUsuarioPOJO> getTipoUsuariosList() {
		return tipoUsuariosList;
	}

	public void setTipoUsuariosList(List<TipoUsuarioPOJO> tipoUsuariosList) {
		this.tipoUsuariosList = tipoUsuariosList;
	}
}
