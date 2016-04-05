package com.cenfotec.socialWorkout.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.socialWorkout.contracts.MaquinaRequest;
import com.cenfotec.socialWorkout.contracts.RegistroMedidaRequest;
import com.cenfotec.socialWorkout.ejb.Ejercicio;
import com.cenfotec.socialWorkout.ejb.Lugarmedicion;
import com.cenfotec.socialWorkout.ejb.Maquina;
import com.cenfotec.socialWorkout.ejb.Registromedida;
import com.cenfotec.socialWorkout.ejb.Unidadmedida;
import com.cenfotec.socialWorkout.ejb.Usuario;
import com.cenfotec.socialWorkout.pojo.EjercicioPOJO;
import com.cenfotec.socialWorkout.pojo.LugarMedicionPOJO;
import com.cenfotec.socialWorkout.pojo.MaquinaPOJO;
import com.cenfotec.socialWorkout.pojo.RegistroMedidaPOJO;
import com.cenfotec.socialWorkout.pojo.UnidadmedidaPOJO;
import com.cenfotec.socialWorkout.pojo.UsuarioPOJO;
import com.cenfotec.socialWorkout.repositories.EjercicioRepository;
import com.cenfotec.socialWorkout.repositories.LugarMedicionRepository;
import com.cenfotec.socialWorkout.repositories.RegistroMedidaRepository;
import com.cenfotec.socialWorkout.repositories.UnidadMedidaRepository;
import com.cenfotec.socialWorkout.repositories.UserRepository;

@Service
public class RegistroMedidaService implements RegistroMedidaServiceInterface {

	@Autowired
	private RegistroMedidaRepository registroMedidaRepository;

	@Autowired
	private LugarMedicionRepository lugarMedicionRepository;

	@Autowired
	private UnidadMedidaRepository unidadMedidaRepository;

	@Autowired
	private UserRepository usuarioRepository;

	@Override
	public List<RegistroMedidaPOJO> getAllById(RegistroMedidaRequest rmR) {

		List<Registromedida> registrosMedida = registroMedidaRepository
				.findByUsuarioIdUsuario(rmR.getRegistroMedida().getUsuarioPOJO().getIdUsuario());

		registrosMedida.size();
		
		return generateEjercicioDtos(registrosMedida);
	}

	private List<RegistroMedidaPOJO> generateEjercicioDtos(List<Registromedida> registrosMedida) {

		List<RegistroMedidaPOJO> uiRegistroMedida = new ArrayList<RegistroMedidaPOJO>();

		registrosMedida.stream().forEach(rm -> {
			
			Hibernate.initialize(rm.getLugarmedicion());
			
			HibernateProxy proxy = (HibernateProxy)rm.getLugarmedicion();                
			Lugarmedicion lugarMedicion = new Lugarmedicion();
			if (!(proxy ==null)){
			lugarMedicion = (Lugarmedicion)proxy.getHibernateLazyInitializer().getImplementation();			
			lugarMedicion.setRegistromedidas(null);
			}
			RegistroMedidaPOJO dto = new RegistroMedidaPOJO();
			if (!(rm==null)){
			BeanUtils.copyProperties(rm, dto);
			}
			if (!(lugarMedicion==null)){
			dto.setLugarmedicionPOJO(generateLugarMedicionDto(lugarMedicion));
			dto.getLugarmedicionPOJO().setUnidadMedidaPOJO(generateUnidadMedidaDto(
					unidadMedidaRepository.findOne(lugarMedicion.getUnidadmedida().getIdUnidadMedida())));
			}
			dto.setUsuarioPOJO(null);
			
			
			
			uiRegistroMedida.add(dto);
		
		});
		
		return uiRegistroMedida;
	}

	private LugarMedicionPOJO generateLugarMedicionDto(Lugarmedicion lugarMedicion) {
		LugarMedicionPOJO lugarMedicionPOJO = new LugarMedicionPOJO();
		if (!(lugarMedicion==null)){
		BeanUtils.copyProperties(lugarMedicion, lugarMedicionPOJO);
		}
		return lugarMedicionPOJO;
	}

	private UnidadmedidaPOJO generateUnidadMedidaDto(Unidadmedida unidadMedida) {
		UnidadmedidaPOJO unidadMedidaPOJO = new UnidadmedidaPOJO();
		if (!(unidadMedida==null)){
		BeanUtils.copyProperties(unidadMedida, unidadMedidaPOJO);
		}
		return unidadMedidaPOJO;
	}

	@Override
	@Transactional
	public Boolean saveRegistroMedida(RegistroMedidaRequest rmR) {

		RegistroMedidaPOJO registroDTO = rmR.getRegistroMedida();
		Registromedida registroMedida  = new Registromedida();
		
		LugarMedicionPOJO lugarMedicionDTO = rmR.getRegistroMedida().getLugarmedicionPOJO();
		Lugarmedicion lugarMedicion = lugarMedicionRepository.findOne(lugarMedicionDTO.getIdLugarMedicion());

		UsuarioPOJO usuarioPOJO = rmR.getRegistroMedida().getUsuarioPOJO();
		Usuario usuario = usuarioRepository.findOne(usuarioPOJO.getIdUsuario());
		if (!(registroDTO==null)){
		BeanUtils.copyProperties(registroDTO, registroMedida);
		}
		registroMedida.setLugarmedicion(lugarMedicion);
		registroMedida.setUsuario(usuario);
		
		Registromedida nregistroMedida = registroMedidaRepository.save(registroMedida);
		return (nregistroMedida == null) ? false : true;

	}

	@Override
	public boolean delete(int idRegistroMedida) {
		registroMedidaRepository.delete(idRegistroMedida);
		return !registroMedidaRepository.exists(idRegistroMedida);
	}

	@Override
	public boolean exists(Integer idRegistroMedida) {
		return registroMedidaRepository.exists(idRegistroMedida);
	}
	
}
