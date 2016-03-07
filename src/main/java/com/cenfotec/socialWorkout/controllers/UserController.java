package com.cenfotec.socialWorkout.controllers;

import java.util.Date;

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
@RequestMapping(value ="rest/protected/users")
public class UserController {
	
	@Autowired private ServletContext servletContext;
	@Autowired 
	private UserServiceInterface usersService;
	@Autowired
	private TipoUsuarioServiceInterface tipoUserService;
	@Autowired 
	private HttpServletRequest request;
	
	@RequestMapping(value ="/getAll", method = RequestMethod.POST)
	public UserResponse getAll(@RequestBody UserRequest ur){	
			
		UserResponse us = new UserResponse();
		us.setCode(200);
		us.setCodeMessage("users fetch success");
		us.setUsuarios(usersService.getAll(ur));
		return us;		
	}
	
	@RequestMapping(value ="/getAllByName", method = RequestMethod.POST)
	public UserResponse getAllByName(@RequestBody UserRequest ur){	
			
		UserResponse us = new UserResponse();
		us.setCode(200);
		us.setCodeMessage("users fetch success");
		us.setUsuarios(usersService.getAllByName(ur));
		return us;		
	}
	/*
	@RequestMapping(value ="/create", method = RequestMethod.POST)
	public UserResponse create(@RequestParam("identificacion") String identificacion,
			                   @RequestParam("nombre") String nombre,
			                   @RequestParam("apellidos") String apellidos,
			                   @RequestParam("correoElectronico") String correoElectronico,
			                   @RequestParam("estatus") byte estatus,
			                   @RequestParam("fechaIngreso") Date fechaIngreso,
			                   @RequestParam("fechaNac") Date fechaNac,
			                   @RequestParam("fechaPago") Date fechaPago,
			                   @RequestParam("poseeVehiculo") byte poseeVehiculo,
			                   @RequestParam("descTipoUsuario") String descTipoUsuario){	
		
		UserResponse us = new UserResponse();
		Usuario usuario = new Usuario();
		usuario.setIdentificacion(identificacion);
		usuario.setNombre(nombre);
		usuario.setApellidos(apellidos);
		usuario.setCorreoElectronico(correoElectronico);
		usuario.setEstatus(estatus);
		usuario.setFechaIngreso(fechaIngreso);
		usuario.setFechaNac(fechaNac);
		usuario.setFechaPago(fechaPago);
		usuario.setPoseeVehiculo(poseeVehiculo);
		usuario.setTipousuario(tipoUserService.getTipoUsuarioByDescTipoUsuario(descTipoUsuario));
		
		boolean state = usersService.saveUser(usuario);
	
		if(state) {
			us.setCode(200);
			us.setCodeMessage("user created succesfully");
		}
		return us;
		
	}
	*/
	@RequestMapping(value ="/edit", method = RequestMethod.POST)
	public UserResponse edit(@RequestBody UserRequest usuarioRequest){	

			UserResponse us = new UserResponse();
			UsuarioPOJO usuarioPOJO = new UsuarioPOJO();
			usuarioPOJO = usuarioRequest.getUser();
			//usuarioPOJO.setTipoUsuarioPOJO(tipoUserService.getTipoUsuarioByDescTipoUsuario
			//		(usuarioRequest.getUser().getTipoUsuarioPOJO().getDescTipoUsuario()));
			Usuario usuarioDTO = new Usuario();
			
			Utils.copyProperties(usuarioPOJO, usuarioDTO );
			
			boolean state = usersService.edit(usuarioDTO);
			
			if(state) {
			us.setCode(200);
			us.setCodeMessage("user created succesfully");
			}
			return us;
			
			}
	
	@RequestMapping(value ="/getTiposUsuario", method = RequestMethod.POST)
	public TipoUsuarioResponse getTiposUsuario(@RequestBody UserRequest ur){	
		
		
		TipoUsuarioResponse tr = new TipoUsuarioResponse();
		tr.setCode(200);
		tr.setCodeMessage("users fetch success");
		tr.setTipoUsuariosList(tipoUserService.getAll());
		return tr;		
	}
	
	@RequestMapping(value ="/createTipo", method = RequestMethod.POST)
	public TipoUsuarioResponse createTipo(@RequestBody Tipousuario ur){	
			
		TipoUsuarioResponse ut = new TipoUsuarioResponse();
		if(tipoUserService.saveTipoUsuario(ur)) {
			ut.setCode(200);
			ut.setCodeMessage("user type created succesfully");
			ut.setTipoUsuariosList(tipoUserService.getAll());
		}
		return ut;		
	}
	
	@RequestMapping(value ="/deleteTipo", method = RequestMethod.POST)
	public TipoUsuarioResponse deleteTipo(@RequestBody TipoUsuarioRequest ur){	
			
		TipoUsuarioResponse ut = new TipoUsuarioResponse();
		if(tipoUserService.delete(ur.getTipo().getIdTipoUsuario())) {
			ut.setCode(200);
			ut.setCodeMessage("user type created succesfully");
		}
		return ut;		
	}
	
	
}
