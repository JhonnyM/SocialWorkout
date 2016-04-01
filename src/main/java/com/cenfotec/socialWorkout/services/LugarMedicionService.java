package com.cenfotec.socialWorkout.services;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cenfotec.socialWorkout.contracts.LugarMedicionRequest;
import com.cenfotec.socialWorkout.ejb.Lugarmedicion;
import com.cenfotec.socialWorkout.ejb.Unidadmedida;
import com.cenfotec.socialWorkout.pojo.LugarMedicionPOJO;
import com.cenfotec.socialWorkout.pojo.UnidadmedidaPOJO;
import com.cenfotec.socialWorkout.services.UnidadMedidaServiceInterface;
import com.cenfotec.socialWorkout.repositories.LugarMedicionRepository;
import com.cenfotec.socialWorkout.utils.Utils;

@Service
public class LugarMedicionService implements LugarMedicionServiceInterface{

	@Autowired private LugarMedicionRepository lugarMedicionRepository;
	@Autowired private UnidadMedidaServiceInterface  unidadMedidaService;
	
	@Override
	@Transactional
	public List<LugarMedicionPOJO> getAll() {
		List<Lugarmedicion> lugaresMedicion =  lugarMedicionRepository.findAll();
		return generateLugaresMedicionDtos(lugaresMedicion);
	}
	
	@Override
	@Transactional
	public List<LugarMedicionPOJO> getAll2() {
		List<Lugarmedicion> lugaresMedicion =  lugarMedicionRepository.findAll();
		return generateLugaresMedicionDtos2(lugaresMedicion);
	}
	
	
	private List<LugarMedicionPOJO> generateLugaresMedicionDtos(List<Lugarmedicion> lugaresMedicion){
		    List<LugarMedicionPOJO> lugaresMedidaPOJO = new ArrayList<LugarMedicionPOJO>();
			lugaresMedicion.stream().forEach(u -> {
			LugarMedicionPOJO lugarMedicionPOJO = new LugarMedicionPOJO();
			UnidadmedidaPOJO unidadMedidaPOJO = new UnidadmedidaPOJO();
			BeanUtils.copyProperties(u, lugarMedicionPOJO);
			BeanUtils.copyProperties(u.getUnidadmedida(), unidadMedidaPOJO);
			lugarMedicionPOJO.setUnidadMedidaPOJO(unidadMedidaPOJO);
			lugaresMedidaPOJO.add(lugarMedicionPOJO);
			});
     		return lugaresMedidaPOJO;
	} 

	private List<LugarMedicionPOJO> generateLugaresMedicionDtos2(List<Lugarmedicion> lugaresMedicion){
	    List<LugarMedicionPOJO> lugaresMedidaPOJO = new ArrayList<LugarMedicionPOJO>();
		
	    lugaresMedicion.stream().forEach(u -> {

		LugarMedicionPOJO lugarMedicionPOJO = new LugarMedicionPOJO();
		
		UnidadmedidaPOJO unidadMedidaPOJO = new UnidadmedidaPOJO();
		
		BeanUtils.copyProperties(u, lugarMedicionPOJO);
		
		BeanUtils.copyProperties(u.getUnidadmedida(), unidadMedidaPOJO);
		
		unidadMedidaPOJO.setLugarmedicions(null);
		
		lugarMedicionPOJO.setUnidadMedidaPOJO(unidadMedidaPOJO);
		
		lugaresMedidaPOJO.add(lugarMedicionPOJO);
		
		});
	    
 		return lugaresMedidaPOJO;
} 
	
	@Override
	@Transactional
	public boolean save(LugarMedicionRequest lugarMedicionRequest) {
	    Lugarmedicion lugarMedicion = new Lugarmedicion();
	    UnidadmedidaPOJO unidadMedidaPOJO = new UnidadmedidaPOJO();
	    //BeanUtils.copyProperties( unidadMedicionService.getTipoUsuarioById(usuarioRequest.getUser().getTipoUsuarioPOJO().getIdTipoUsuario()),tipoUsuarioPOJO);
	
		Utils.copyProperties(lugarMedicionRequest.getLugarMedicion(), lugarMedicion);

		Lugarmedicion nlugarMedicion = lugarMedicionRepository.save(lugarMedicion);
		return nlugarMedicion != null;
	}
	
	@Override
	@Transactional
	public boolean edit(LugarMedicionRequest lugarMedicionRequest){
	    Lugarmedicion lugarMedicion = new Lugarmedicion();
	    Unidadmedida unidadMedida = new Unidadmedida();
	    UnidadmedidaPOJO unidadMedidaPOJO = new UnidadmedidaPOJO();
	    BeanUtils.copyProperties(unidadMedidaService.getByIdUnidad
	    		(lugarMedicionRequest.getLugarMedicion().getUnidadMedidaPOJO().getIdUnidadMedida()),unidadMedidaPOJO);
	    BeanUtils.copyProperties(lugarMedicionRequest.getLugarMedicion(), lugarMedicion);
	    BeanUtils.copyProperties(unidadMedidaPOJO, unidadMedida);
	    lugarMedicion.setUnidadmedida(unidadMedida);
	    Lugarmedicion nlugarMedicion = lugarMedicionRepository.save(lugarMedicion);
		return nlugarMedicion != null;
	}

	@Override
	public Lugarmedicion getLugarMedicionXId(int idLugarMedicion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Integer idObj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exists(Integer idObj) {
		// TODO Auto-generated method stub
		return false;
	}

};
	