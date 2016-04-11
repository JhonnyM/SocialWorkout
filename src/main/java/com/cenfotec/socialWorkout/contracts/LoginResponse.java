package com.cenfotec.socialWorkout.contracts;


public class LoginResponse extends BaseResponse {
	
	private int idUsuario;
	private String nombre;
	private String apellidos; 

	public LoginResponse() {
		super();
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	

}
