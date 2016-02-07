package com.cenfotec.socialWorkout.services;

import javax.servlet.http.HttpSession;

import com.cenfotec.socialWorkout.contracts.LoginRequest;
import com.cenfotec.socialWorkout.contracts.LoginResponse;
import com.cenfotec.socialWorkout.ejb.Usuario;

public interface LoginServiceInterface {

	public void checkUser(LoginRequest lr, LoginResponse response, HttpSession currentSession);

}
