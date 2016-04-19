package com.cenfotec.socialWorkout.repositories;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.cenfotec.socialWorkout.ejb.Promediorutinasmaquina;

public interface PromedioRutinasMaquinaRepository extends CrudRepository<Promediorutinasmaquina, Integer>  {	
	List<Promediorutinasmaquina> findAll();
	Promediorutinasmaquina  findByCodigoMaquinaAndDiaAndHora(int codigoMaquina,String dia, int hora);
	List<Promediorutinasmaquina> findByDiaAndHora(String dia, int hora);
	List<Promediorutinasmaquina> findByCodigoMaquinaAndDia(int codigoMaquina,String dia);
	List<Promediorutinasmaquina> findByDia(String dia);
}

