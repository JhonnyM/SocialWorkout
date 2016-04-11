package com.cenfotec.socialWorkout.contracts;

import java.util.List;
import com.cenfotec.socialWorkout.pojo.UsuarioPOJO;

public class UserResponse extends BaseResponse {
	
	private List<UsuarioPOJO> usuarios;
	private UsuarioPOJO usuario;

	public UserResponse() {
		super();
	}
	
	public List<UsuarioPOJO> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioPOJO> usuarios) {
		this.usuarios = usuarios;
	}

	public UsuarioPOJO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioPOJO usuario) {
		this.usuario = usuario;
	}

}
