package com.cenfotec.socialWorkout.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cenfotec.socialWorkout.contracts.RegistroMedidaRequest;
import com.cenfotec.socialWorkout.ejb.Ejercicio;
import com.cenfotec.socialWorkout.ejb.Lugarmedicion;
import com.cenfotec.socialWorkout.ejb.Registromedida;
import com.cenfotec.socialWorkout.ejb.Unidadmedida;
import com.cenfotec.socialWorkout.pojo.EjercicioPOJO;
import com.cenfotec.socialWorkout.pojo.LugarMedicionPOJO;
import com.cenfotec.socialWorkout.pojo.RegistroMedidaPOJO;
import com.cenfotec.socialWorkout.pojo.UnidadmedidaPOJO;
import com.cenfotec.socialWorkout.repositories.EjercicioRepository;
import com.cenfotec.socialWorkout.repositories.LugarMedicionRepository;
import com.cenfotec.socialWorkout.repositories.RegistroMedidaRepository;
import com.cenfotec.socialWorkout.repositories.UnidadMedidaRepository;

@Service
public class RegistroMedidaService implements RegistroMedidaServiceInterface {

	@Autowired
	private RegistroMedidaRepository registroMedidaRepository;

	@Autowired
	private LugarMedicionRepository lugarMedicionRepository;

	@Autowired
	private UnidadMedidaRepository unidadMedidaRepository;

	@Override
	public List<RegistroMedidaPOJO> getAllById(RegistroMedidaRequest rmR) {

		List<Registromedida> registrosMedida = registroMedidaRepository
				.findByUsuarioIdUsuario(rmR.getRegistroMedida().getUsuarioPOJO().getIdUsuario());

		return generateEjercicioDtos(registrosMedida);
	}

	private List<RegistroMedidaPOJO> generateEjercicioDtos(List<Registromedida> registrosMedida) {

		List<RegistroMedidaPOJO> uiRegistroMedida = new ArrayList<RegistroMedidaPOJO>();

		registrosMedida.stream().forEach(rm -> {
			RegistroMedidaPOJO dto = new RegistroMedidaPOJO();
			BeanUtils.copyProperties(rm, dto);
			dto.setLugarmedicionPOJO(generateLugarMedicionDto(
					lugarMedicionRepository.findOne(1)));
			
			dto.getLugarmedicionPOJO().setUnidadMedidaPOJO(generateUnidadMedidaDto(
					unidadMedidaRepository.findOne(1)));
			
			dto.setUsuarioPOJO(null);
			
			dto.getLugarmedicionPOJO().getUnidadMedidaPOJO().setLugarmedicions(null);
			
			uiRegistroMedida.add(dto);
		
		});
		
		return uiRegistroMedida;
	}

	private LugarMedicionPOJO generateLugarMedicionDto(Lugarmedicion lugarMedicion) {
		LugarMedicionPOJO lugarMedicionPOJO = new LugarMedicionPOJO();

		BeanUtils.copyProperties(lugarMedicion, lugarMedicionPOJO);

		return lugarMedicionPOJO;
	}

	private UnidadmedidaPOJO generateUnidadMedidaDto(Unidadmedida unidadMedida) {
		UnidadmedidaPOJO unidadMedidaPOJO = new UnidadmedidaPOJO();

		BeanUtils.copyProperties(unidadMedida, unidadMedidaPOJO);

		return unidadMedidaPOJO;
	}

}
