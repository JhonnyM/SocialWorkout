package sw;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the clasepremiacion database table.
 * 
 */
@Entity
@NamedQuery(name="Clasepremiacion.findAll", query="SELECT c FROM Clasepremiacion c")
public class Clasepremiacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idClasePremiacion;

	private String descClasePremiacion;

	//bi-directional many-to-one association to Medallavirtual
	@OneToMany(mappedBy="clasepremiacion")
	private List<Medallavirtual> medallavirtuals;

	//bi-directional many-to-one association to Rankeo
	@OneToMany(mappedBy="clasepremiacion")
	private List<Rankeo> rankeos;

	public Clasepremiacion() {
	}

	public int getIdClasePremiacion() {
		return this.idClasePremiacion;
	}

	public void setIdClasePremiacion(int idClasePremiacion) {
		this.idClasePremiacion = idClasePremiacion;
	}

	public String getDescClasePremiacion() {
		return this.descClasePremiacion;
	}

	public void setDescClasePremiacion(String descClasePremiacion) {
		this.descClasePremiacion = descClasePremiacion;
	}

	public List<Medallavirtual> getMedallavirtuals() {
		return this.medallavirtuals;
	}

	public void setMedallavirtuals(List<Medallavirtual> medallavirtuals) {
		this.medallavirtuals = medallavirtuals;
	}

	public Medallavirtual addMedallavirtual(Medallavirtual medallavirtual) {
		getMedallavirtuals().add(medallavirtual);
		medallavirtual.setClasepremiacion(this);

		return medallavirtual;
	}

	public Medallavirtual removeMedallavirtual(Medallavirtual medallavirtual) {
		getMedallavirtuals().remove(medallavirtual);
		medallavirtual.setClasepremiacion(null);

		return medallavirtual;
	}

	public List<Rankeo> getRankeos() {
		return this.rankeos;
	}

	public void setRankeos(List<Rankeo> rankeos) {
		this.rankeos = rankeos;
	}

	public Rankeo addRankeo(Rankeo rankeo) {
		getRankeos().add(rankeo);
		rankeo.setClasepremiacion(this);

		return rankeo;
	}

	public Rankeo removeRankeo(Rankeo rankeo) {
		getRankeos().remove(rankeo);
		rankeo.setClasepremiacion(null);

		return rankeo;
	}

}