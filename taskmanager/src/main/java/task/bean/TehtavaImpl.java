package task.bean;

import java.util.Date;

public class TehtavaImpl implements Tehtava {
	private int id;
	private String kuvaus;
	private String lisatiedot;
	private int status;
	private Date pvmaika;
	private Date muistutusPvmaika;
	
	public TehtavaImpl() {
		this.id = 0;
		this.kuvaus = "Kuvaus";
		this.lisatiedot = "Tiedot";
		this.status = 0;
		this.pvmaika = new Date();
		this.muistutusPvmaika = new Date();
	}

	public TehtavaImpl(int id, String kuvaus, String lisatiedot, int status, Date pvmaika, Date muistutusPvm) {
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

	public Date getPvmaika() {
		return pvmaika;
	}

	public Date getMuistutusPvmaika() {
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

	public void setPvmaika(Date pvmaika) {
		this.pvmaika = pvmaika;
	}

	public void setMuistutusPvmaika(Date muistutusPvmaika) {
		this.muistutusPvmaika = muistutusPvmaika;
	}
}
