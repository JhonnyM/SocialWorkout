package com.cenfotec.socialWorkout.contracts;

import java.util.List;
import com.cenfotec.socialWorkout.pojo.UsuarioAdministradorPOJO;

public class UserAdministradorResponse extends BaseResponse {
		
		private List<UsuarioAdministradorPOJO> usuarios;
		
		public UserAdministradorResponse() {
			super();
		}
		
		public List<UsuarioAdministradorPOJO> getUsuarios() {
			return usuarios;
		}

		public void setUsuarios(List<UsuarioAdministradorPOJO> usuarios) {
			this.usuarios = usuarios;
		}


	}

	