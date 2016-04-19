package com.cenfotec.socialWorkout.services;

import java.beans.Beans;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cenfotec.socialWorkout.pojo.PromedioRutinasMaquinaPOJO;
import com.cenfotec.socialWorkout.repositories.PromedioRutinasMaquinaRepository;
import com.cenfotec.socialWorkout.ejb.Promediorutinasmaquina;


@Service
public class PromedioRutinasMaquinaService implements PromedioRutinasMaquinaServiceInterface {
	
@Autowired private PromedioRutinasMaquinaRepository promedioRutinasMaquinaRepository;
	
	@Override
	@Transactional
	public List<PromedioRutinasMaquinaPOJO> getAll() {
		List<Promediorutinasmaquina> ocupacion =  promedioRutinasMaquinaRepository.findAll();
		return generatePromedioRutinasMaquinaDtos(ocupacion);
	}

	@Override
	@Transactional
	public List<PromedioRutinasMaquinaPOJO> getOcupacionXMaquinaDia(int codigoMaquina, String dia) {
		List<Promediorutinasmaquina> ocupacion =  promedioRutinasMaquinaRepository.findByCodigoMaquinaAndDia(codigoMaquina,dia);
		return generatePromedioRutinasMaquinaDtos(ocupacion);
	}
	
	@Override
	@Transactional
	public List<PromedioRutinasMaquinaPOJO> getOcupacionXDiaTotal(String dia) {
		List<Promediorutinasmaquina> ocupacion =  promedioRutinasMaquinaRepository.findByDia(dia);
		return generatePromedioRutinasMaquinaDtos(ocupacion);
	}
	
	@Override
	@Transactional
	public List<PromedioRutinasMaquinaPOJO> getOcupacionXDiaHora(String dia, int hora) {
		List<Promediorutinasmaquina> ocupacion =  promedioRutinasMaquinaRepository.findByDiaAndHora(dia, hora);
		return generatePromedioRutinasMaquinaDtos(ocupacion);
	}

	@Override
	@Transactional
	public PromedioRutinasMaquinaPOJO getOcupacionXDiaHoraMaquina(int codigoMaquina,String dia, int hora) {
		Promediorutinasmaquina ocupacionMaquinaUtilizar =  new Promediorutinasmaquina();
		ocupacionMaquinaUtilizar = null;
		ocupacionMaquinaUtilizar = promedioRutinasMaquinaRepository.findByCodigoMaquinaAndDiaAndHora(codigoMaquina,dia, hora );
		PromedioRutinasMaquinaPOJO dto = new PromedioRutinasMaquinaPOJO();
		if (!(ocupacionMaquinaUtilizar==null)){
			BeanUtils.copyProperties(ocupacionMaquinaUtilizar,dto);
		}
		return dto;
	}

	private List<PromedioRutinasMaquinaPOJO> generatePromedioRutinasMaquinaDtos(List<Promediorutinasmaquina> ocupacion){
		List<PromedioRutinasMaquinaPOJO> uiOcupacion = new ArrayList<PromedioRutinasMaquinaPOJO>();
		ocupacion.stream().forEach(u -> {
			PromedioRutinasMaquinaPOJO dto = new PromedioRutinasMaquinaPOJO();
			if (!(u==null)){
			BeanUtils.copyProperties(u,dto);
			}
			uiOcupacion.add(dto);
		});	
		return uiOcupacion;
	}
	
}
