package task.bean;
import java.time.LocalDateTime;

public class TehtavaImpl implements Tehtava {
	private int id;
	private String kuvaus;
	private String lisatiedot;
	private int status;
	private LocalDateTime pvmaika;
	private LocalDateTime muistutusPvmaika;
	
	public TehtavaImpl() {
		this.id = 0;
		this.kuvaus = "";
		this.lisatiedot = "";
		this.status = 0;
		this.pvmaika = null;
		this.muistutusPvmaika = null;
	}

	public TehtavaImpl(int id, String kuvaus, String lisatiedot, int status, LocalDateTime pvmaika, LocalDateTime muistutusPvm) {
		this.id = id;
		this.kuvaus = kuvaus;
		this.lisatiedot = lisatiedot;
		this.status = 0;
		this.pvmaika = pvmaika;
		this.muistutusPvmaika = muistutusPvm;
	}
	
	public int getId() {
		return id;
	}

	public String getKuvaus() {
		return kuvaus;
	}

	public String getLisatiedot() {
		return lisatiedot;
	}

	public int getStatus() {
		return status;
	}

	public LocalDateTime getPvmaika() {
		return pvmaika;
	}

	public LocalDateTime getMuistutusPvmaika() {
		return muistutusPvmaika;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}

	public void setLisatiedot(String lisatiedot) {
		this.lisatiedot = lisatiedot;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setPvmaika(LocalDateTime pvmaika) {
		this.pvmaika = pvmaika;
	}

	public void setMuistutusPvmaika(LocalDateTime muistutusPvmaika) {
		this.muistutusPvmaika = muistutusPvmaika;
	}
}
