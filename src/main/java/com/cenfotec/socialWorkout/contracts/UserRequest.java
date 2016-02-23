package com.cenfotec.socialWorkout.contracts;
import com.cenfotec.socialWorkout.pojo.UsuarioPOJO;

public class UserRequest extends BaseRequest {
	
	private UsuarioPOJO user;
		
		public UserRequest() {
			super();
		}
		
		public UsuarioPOJO getUser() {
			return user;
		}
		
		public void setUser(UsuarioPOJO user) {
			this.user = user;
		}
	
		@Override
		public String toString() {
			return "UsersRequest [user=" + user + "]";
		}

}
