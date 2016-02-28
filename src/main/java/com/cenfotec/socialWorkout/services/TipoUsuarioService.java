package com.cenfotec.socialWorkout.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cenfotec.socialWorkout.contracts.TipoUsuarioRequest;
import com.cenfotec.socialWorkout.pojo.TipoUsuarioPOJO;
import com.cenfotec.socialWorkout.repositories.TipoUsuarioRepository;
import com.cenfotec.socialWorkout.utils.Utils;
import com.cenfotec.socialWorkout.ejb.Tipousuario;

@Service
public class TipoUsuarioService implements TipoUsuarioServiceInterface {

	@Autowired
	private TipoUsuarioRepository repo;
	
	@Override
	@Transactional
	public List<TipoUsuarioPOJO> getAll() {
		return repo.findAll()
				   .parallelStream()
				   .map(t -> Utils.copyProperties(t, TipoUsuarioPOJO::new))
				   .collect(Collectors.toList());
	}

	
	@Override
	public boolean saveTipoUsuario(TipoUsuarioRequest r) {
		Tipousuario tu = repo.save(Utils.copyProperties(r.getTipo(), Tipousuario::new));
		return tu != null;
	}

	@Override
	public boolean deleteTipoUsuario(TipoUsuarioRequest r) {
		
		int id = r.getTipo().getIdTipoUsuario();
		boolean exists = repo.exists(id);
		if(exists)
			repo.delete(r.getTipo().getIdTipoUsuario());
		return exists;
	}


	@Override
	public Optional<TipoUsuarioPOJO> getTipoUsuarioById(int idTipoUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
