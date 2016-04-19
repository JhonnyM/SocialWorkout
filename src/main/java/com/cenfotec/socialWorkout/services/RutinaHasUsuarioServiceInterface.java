package com.cenfotec.socialWorkout.services;

import java.util.List;
import java.util.Optional;

import com.cenfotec.socialWorkout.contracts.RutinaHasUsuarioRequest;
import com.cenfotec.socialWorkout.contracts.TipoUsuarioRequest;
import com.cenfotec.socialWorkout.contracts.UserRequest;
import com.cenfotec.socialWorkout.pojo.RutinaHasUsuarioPOJO;
import com.cenfotec.socialWorkout.pojo.TipoUsuarioPOJO;
import com.cenfotec.socialWorkout.pojo.UsuarioPOJO;
import com.cenfotec.socialWorkout.ejb.Tipousuario;
import com.cenfotec.socialWorkout.ejb.Usuario;

public interface RutinaHasUsuarioServiceInterface {
	List<RutinaHasUsuarioPOJO> getRutinaDia(String dia, UsuarioPOJO usuarioPOJO);
	List<RutinaHasUsuarioPOJO> getRutinaWithPlantilla(String dia, UsuarioPOJO usuarioPOJO);
	List<RutinaHasUsuarioPOJO> getRutinaWithPlantillaUsuario(UsuarioPOJO usuarioPOJO);
	Boolean actualizaRutinaTemporal(int idRutinaHasUsuario, int temporal);


}
