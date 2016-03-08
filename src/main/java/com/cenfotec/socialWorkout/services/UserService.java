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
import com.cenfotec.socialWorkout.repositories.UserRepository;
import com.cenfotec.socialWorkout.utils.Utils;

@Service
public class UserService implements UserServiceInterface{

	@Autowired private UserRepository usersRepository;
	
	@Override
	@Transactional
	public List<UsuarioPOJO> getAll(UserRequest ur) {
		List<Usuario> users =  usersRepository.findAll();
		return generateUserDtos(users);
	}
	
	@Override
	@Transactional
	public List<UsuarioPOJO> getAllByName(UserRequest ur) {
		List<Usuario> users =  usersRepository.findBynombreContaining(ur.getSearchTerm());
		return generateUserDtos(users);
	}
	
	
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
		Utils.copyProperties(usuarioRequest.getUser(), usuario);
		usuario.setClave(Utils.devolverMD5(usuario.getClave())); 
		Usuario nuser = usersRepository.save(usuario);
		return nuser != null;
	}
	
	@Override
	@Transactional
	public Boolean edit(UserRequest usuarioRequest){
		TipoUsuarioServiceInterface tipoUsuarioService = new TipoUsuarioService();
		Usuario usuario = new Usuario();
		TipoUsuarioPOJO tipoUsuarioPOJO = new TipoUsuarioPOJO();
		BeanUtils.copyProperties(tipoUsuarioService.getTipoUsuarioById
				(usuarioRequest.getUser().getTipoUsuarioPOJO().getIdTipoUsuario()),tipoUsuarioPOJO);
		UsuarioPOJO usuarioPOJO = new UsuarioPOJO();
		usuarioPOJO = usuarioRequest.getUser();
		usuarioPOJO.setTipoUsuarioPOJO(tipoUsuarioPOJO);
		BeanUtils.copyProperties(usuarioRequest.getUser(),usuario);
		
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