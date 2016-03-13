package com.cenfotec.socialWorkout.services;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cenfotec.socialWorkout.contracts.UserRequest;
import com.cenfotec.socialWorkout.ejb.Tipousuario;
import com.cenfotec.socialWorkout.ejb.Usuario;
import com.cenfotec.socialWorkout.pojo.TipoUsuarioPOJO;
import com.cenfotec.socialWorkout.pojo.UsuarioPOJO;
import com.cenfotec.socialWorkout.repositories.TipoUsuarioRepository;
import com.cenfotec.socialWorkout.repositories.UserRepository;
import com.cenfotec.socialWorkout.utils.Utils;

@Service
public class UserService implements UserServiceInterface{

	@Autowired private UserRepository usersRepository;
	@Autowired private TipoUsuarioServiceInterface  tipoUsuarioService;
	
	@Override
	@Transactional
	public List<UsuarioPOJO> getAll(UserRequest ur) {
		List<Usuario> users =  usersRepository.findAll();
		return generateUserDtos(users);
	}
	
	@Override
	@Transactional
	public List<UsuarioPOJO> getAllByName(UserRequest ur) {
		List<Usuario> usersInstructores =  usersRepository.findBynombreContaining(ur.getSearchTerm());
		return generateUserDtos( usersInstructores );
	}
	@Override
	@Transactional
	public List<UsuarioPOJO> getAllByTipoUsuario() {
		TipoUsuarioPOJO  tipoUsuarioPOJO = new TipoUsuarioPOJO();
		tipoUsuarioPOJO = tipoUsuarioService.getTipoUsuarioById(2);
		Tipousuario tipoUsuario = new Tipousuario();
		BeanUtils.copyProperties(tipoUsuarioPOJO, tipoUsuario);
		List<Usuario> users =  usersRepository.findByTipousuario(tipoUsuario);
		return generateUserDtos(users);
	}
	
	@Override
	@Transactional
	public UsuarioPOJO getUsuarioInstructorById(int idUsuario) {
		UsuarioPOJO usuarioPOJOInstructor = new UsuarioPOJO();
		Utils.copyProperties(usersRepository.findByidUsuario(idUsuario),usuarioPOJOInstructor);
		return usuarioPOJOInstructor;
	}
	/*
	@Override
	@Transactional
	public UsuarioPOJO getUsuarioSession() {
		UsuarioPOJO usuarioPOJOInstructor = new UsuarioPOJO();
		Utils.copyProperties(usersRepository.findByidUsuario(idUsuario),usuarioPOJOInstructor);
		return usuarioPOJOInstructor;
	}
	*/
	private List<UsuarioPOJO> generateUserDtos(List<Usuario> users){
		    List<UsuarioPOJO> usuariosPOJO = new ArrayList<UsuarioPOJO>();
			users.stream().forEach(u -> {
			UsuarioPOJO usuarioPOJO = new UsuarioPOJO();
			TipoUsuarioPOJO tipoUsuarioPOJO = new TipoUsuarioPOJO();
			UsuarioPOJO usuarioPOJOInstructor = new UsuarioPOJO();
			BeanUtils.copyProperties(u, usuarioPOJO);
			BeanUtils.copyProperties(u.getTipousuario(), tipoUsuarioPOJO);
			if (!(u.getUsuario()==null)){
				BeanUtils.copyProperties(u.getUsuario(), usuarioPOJOInstructor);		
			}
			usuarioPOJO.setTipoUsuarioPOJO(tipoUsuarioPOJO);
			usuarioPOJO.setUsuarioPOJOInstructor(usuarioPOJOInstructor);
			usuariosPOJO.add(usuarioPOJO);
		});
		
		/*return users.stream()
			  .map(u -> Utils.copyProperties(u, UsuarioPOJO::new))
		      .peek(dto -> dto.setClave(""))
		      .collect(Collectors.toList());*/
		return usuariosPOJO;
	} 

	@Override
	@Transactional
	public boolean saveUser(UserRequest usuarioRequest) {
	    Usuario usuario = new Usuario();
	    TipoUsuarioPOJO tipoUsuarioPOJO = new TipoUsuarioPOJO();
	    UsuarioPOJO usuarioPOJOInstructor = new UsuarioPOJO();
	    BeanUtils.copyProperties( tipoUsuarioService.getTipoUsuarioById(usuarioRequest.getUser().getTipoUsuarioPOJO().getIdTipoUsuario()),tipoUsuarioPOJO);
	    if (usuarioRequest.getUser().getUsuarioPOJOInstructor().getIdUsuario() > 0  ){
			BeanUtils.copyProperties(getUsuarioInstructorById(usuarioRequest.getUser().getUsuarioPOJOInstructor().getIdUsuario()), usuarioPOJOInstructor);
	    }
	    Tipousuario tipoUsuario = new Tipousuario();
		BeanUtils.copyProperties(tipoUsuarioPOJO, tipoUsuario);
		Utils.copyProperties(usuarioRequest.getUser(), usuario);
		Usuario usuarioInstructor = new Usuario();
	    BeanUtils.copyProperties(usuarioPOJOInstructor, usuarioInstructor);
		usuario.setClave(Utils.devolverMD5(usuario.getIdentificacion())); 
		usuario.setTipousuario( tipoUsuario);
		 if ((usuarioRequest.getUser().getUsuarioPOJOInstructor().getIdUsuario()) > 0) {
		    	usuario.setUsuario(usuarioInstructor);
		 }
		Usuario nuser = usersRepository.save(usuario);
		return nuser != null;
	}
	
	@Override
	@Transactional
	public Boolean edit(UserRequest usuarioRequest){
		Usuario usuario = new Usuario();
		TipoUsuarioPOJO tipoUsuarioPOJO = new TipoUsuarioPOJO();
		UsuarioPOJO usuarioPOJOInstructor = new UsuarioPOJO();
		BeanUtils.copyProperties( tipoUsuarioService.getTipoUsuarioById(usuarioRequest.getUser().getTipoUsuarioPOJO().getIdTipoUsuario()),tipoUsuarioPOJO);
		if ((usuarioRequest.getUser().getUsuarioPOJOInstructor().getIdUsuario()) > 0) {
			BeanUtils.copyProperties(getUsuarioInstructorById(usuarioRequest.getUser().getUsuarioPOJOInstructor().getIdUsuario()), usuarioPOJOInstructor);
	    }
		UsuarioPOJO usuarioPOJO = new UsuarioPOJO();
		usuarioPOJO = usuarioRequest.getUser();
        usuarioPOJO.setClave(usersRepository.findByidUsuario(usuarioRequest.getUser().getIdUsuario()).getClave());
		BeanUtils.copyProperties(usuarioPOJO,usuario);
		Tipousuario tipoUsuario = new Tipousuario();
		BeanUtils.copyProperties(tipoUsuarioPOJO, tipoUsuario);
	    Usuario usuarioInstructor = new Usuario();
	    BeanUtils.copyProperties(usuarioPOJOInstructor, usuarioInstructor);
	    usuario.setTipousuario(tipoUsuario);
	    if ((usuarioRequest.getUser().getUsuarioPOJOInstructor().getIdUsuario()) > 0) {
	    	usuario.setUsuario(usuarioInstructor);
	    }
	    Usuario nUsuario = usersRepository.save(usuario);
		return (nUsuario == null) ? false : true;
	}
	
	
/* este codigo se va a utilizar mas adelante para devolver la lista de rutinas de un usuario
	@Override
	@Transactional
	public List<UsuarioPOJO> getRutinas(UserRequest ur) {
		
		Usuario user = usersRepository.findOne(ur.getUser().getIdUsuario());
		
		UsuarioPOJO dtoU = user.getRutinas()
				               .stream()
				               .map(rut -> Utils.copyProperties(alq, RutinaPOJO::new))
				               .collect(Collectors.collectingAndThen(Collectors.toList(), 
				                        p -> Utils.copyProperties(user, new UsuarioPOJO(p))));
		return Arrays.asList(dtoU);
	}*/
}