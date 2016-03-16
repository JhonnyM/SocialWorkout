package com.cenfotec.socialWorkout.contracts;

public class LoginRequest {

	private String correoElectronico;
	private String clave;
	
	public LoginRequest() {
		super();
	}

	public LoginRequest(String correoElectronico, String clave) {
		super();
		this.correoElectronico = correoElectronico;
		this.clave = clave;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
}
