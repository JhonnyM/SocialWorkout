package com.cenfotec.socialWorkout.contracts;

import com.cenfotec.socialWorkout.pojo.UsuarioAdministradorPOJO;

public class UserAdministradorRequest extends BaseRequest {
		
		private UsuarioAdministradorPOJO user;
			
			public UserAdministradorRequest() {
				super();
			}
			
			public UsuarioAdministradorPOJO getUser() {
				return user;
			}
			
			public void setUser(UsuarioAdministradorPOJO user) {
				this.user = user;
			}
		
			@Override
			public String toString() {
				return "UsersRequest [user=" + user + "]";
			}

	}
	
