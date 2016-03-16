package com.cenfotec.socialWorkout.services;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cenfotec.socialWorkout.contracts.LoginRequest;
import com.cenfotec.socialWorkout.contracts.LoginResponse;
import com.cenfotec.socialWorkout.ejb.Usuario;
import com.cenfotec.socialWorkout.repositories.LoginRepository;
import com.cenfotec.socialWorkout.utils.Utils;

@Service
public class LoginService implements LoginServiceInterface{

	@Autowired private LoginRepository loginRepository;
	
	@Override
	@Transactional
	public void checkUser(LoginRequest lr, LoginResponse response, HttpSession currentSession) {
		Usuario loggedUser = loginRepository.findByCorreoElectronicoAndClave(lr.getCorreoElectronico(), Utils.devolverMD5(lr.getClave()));
		if(loggedUser == null){
			response.setCode(401);
			response.setErrorMessage("Unauthorized User");
		}else{
			response.setCode(200);
			response.setCodeMessage("User authorized");
			
			//CREATE AND SET THE VALUES FOR THE CONTRACT OBJECT
			response.setIdUsuario(loggedUser.getIdUsuario());
			response.setNombre(loggedUser.getNombre());

			//
			currentSession.setAttribute("idUsuario", loggedUser.getIdUsuario());
		}
	}		
}