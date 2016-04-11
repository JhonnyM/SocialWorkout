package com.cenfotec.socialWorkout.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cenfotec.socialWorkout.contracts.TipoUsuarioRequest;
import com.cenfotec.socialWorkout.contracts.TipoUsuarioResponse;
import com.cenfotec.socialWorkout.contracts.UserAdministradorRequest;
import com.cenfotec.socialWorkout.contracts.UserAdministradorResponse;
import com.cenfotec.socialWorkout.services.TipoUsuarioServiceInterface;
import com.cenfotec.socialWorkout.services.UserServiceInterface;
import com.cenfotec.socialWorkout.contracts.UserRequest;
import com.cenfotec.socialWorkout.contracts.UserResponse;
import com.cenfotec.socialWorkout.ejb.Tipousuario;
import com.cenfotec.socialWorkout.ejb.Usuario;
import com.cenfotec.socialWorkout.pojo.TipoUsuarioPOJO;
import com.cenfotec.socialWorkout.pojo.UsuarioPOJO;
import com.cenfotec.socialWorkout.utils.Utils;

@RestController
@RequestMapping(value = "rest/protected/users")
public class UserController {

	@Autowired
	private ServletContext servletContext;
	@Autowired
	private UserServiceInterface usersService;
	@Autowired
	private TipoUsuarioServiceInterface tipoUserService;
	@Autowired
	private HttpServletRequest request;

	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	public UserResponse getAll(@RequestBody UserRequest ur) {

		UserResponse us = new UserResponse();
		us.setCode(200);
		us.setCodeMessage("users fetch success");
		us.setUsuarios(usersService.getAll(ur));
		return us;
	}

	@RequestMapping(value = "/getAllToAdministrador", method = RequestMethod.POST)
	public UserAdministradorResponse getAllToAdministrador(@RequestBody UserAdministradorRequest ur) {

		UserAdministradorResponse us = new UserAdministradorResponse();
		us.setCode(200);
		us.setCodeMessage("users fetch success");
		us.setUsuarios(usersService.getAllToAdministrador(ur));
		return us;
	}

	@RequestMapping(value = "/getAllByName", method = RequestMethod.POST)
	public UserResponse getAllByName(@RequestBody UserRequest ur) {

		UserResponse us = new UserResponse();
		us.setCode(200);
		us.setCodeMessage("users fetch success");
		us.setUsuarios(usersService.getAllByName(ur));
		return us;
	}

	@RequestMapping(value = "/ getAllByTipoUsuario", method = RequestMethod.POST)
	public UserResponse getAllByTipoUsuario() {

		UserResponse us = new UserResponse();
		us.setCode(200);
		us.setCodeMessage("users fetch success");
		us.setUsuarios(usersService.getAllByTipoUsuario());
		return us;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public UserResponse create(@RequestBody UserRequest usuarioRequest) {

		UserResponse us = new UserResponse();
		boolean state = usersService.saveUser(usuarioRequest);

		if (state) {
			us.setCode(200);
			us.setCodeMessage("user created succesfully");
		}
		return us;

	};

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public UserResponse edit(@RequestBody UserRequest usuarioRequest) {

		UserResponse us = new UserResponse();
		boolean state = usersService.edit(usuarioRequest);

		if (state) {
			us.setCode(200);
			us.setCodeMessage("user created succesfully");
		}
		return us;

	};

	@RequestMapping(value = "/getTiposUsuario", method = RequestMethod.POST)
	public TipoUsuarioResponse getTiposUsuario(@RequestBody UserRequest ur) {

		TipoUsuarioResponse tr = new TipoUsuarioResponse();
		tr.setCode(200);
		tr.setCodeMessage("users fetch success");
		tr.setTipoUsuariosList(tipoUserService.getAll());
		return tr;
	};

	@RequestMapping(value = "/createTipo", method = RequestMethod.POST)
	public TipoUsuarioResponse createTipo(@RequestBody TipoUsuarioRequest tipoUsuarioRequest) {

		TipoUsuarioResponse ut = new TipoUsuarioResponse();
		if (tipoUserService.saveTipoUsuario(tipoUsuarioRequest)) {
			ut.setCode(200);
			ut.setCodeMessage("user type created succesfully");
			ut.setTipoUsuariosList(tipoUserService.getAll());
		}
		return ut;
	}

	@RequestMapping(value = "/deleteTipo", method = RequestMethod.POST)
	public TipoUsuarioResponse deleteTipo(@RequestBody TipoUsuarioRequest ur) {

		TipoUsuarioResponse ut = new TipoUsuarioResponse();
		if (tipoUserService.delete(ur.getTipo().getIdTipoUsuario())) {
			ut.setCode(200);
			ut.setCodeMessage("user type created succesfully");
		}
		return ut;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public UserResponse getAll() {

		UserResponse response = new UserResponse();
		response.setCode(200);
		response.setCodeMessage("User fetch success");
		response.setUsuarios(usersService.getAll());
		return response;

	}

	@RequestMapping(value = "/getInstructores", method = RequestMethod.GET)
	public UserResponse getInstructores() {

		UserResponse us = new UserResponse();
		us.setCode(200);
		us.setCodeMessage("users fetch success");
		us.setUsuarios(usersService.getInstructores());
		return us;
	}

	@RequestMapping(value = "/usuarioSet", method = RequestMethod.POST)
	public UserResponse getUsuarioLogueado() {
		UserResponse us = new UserResponse();
		us.setCode(200);
		us.setCodeMessage("users fetch success");
		us.setUsuario(usersService.getUsuarioSession());
		return us;
	}

}
