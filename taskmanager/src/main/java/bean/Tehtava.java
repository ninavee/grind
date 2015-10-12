package bean;

import java.util.Date;

public class Tehtava {
	private int id;
	private String kuvaus; // Otsikko tapahtumasta, joka näkyy listassa
	private String lisatiedot; // lisätiedot tapahtumasta
	private int status; // 0 = Ei tehty, 1 = Tehty
	private Date pvm; // Pvm ja aika, jolloin tapahtuma on
	private Date muistutusPvm; // Pvm jolloin muistuttaa asiasta
	
	//Konstruktorit
	public Tehtava() {
		id = 0;
		kuvaus = "";
		lisatiedot = "";
		status = 0;
		pvm = null;
		muistutusPvm = null;
	}

	public Tehtava(int id, String kuvaus, String lisatiedot, int status, Date pvm, Date muistutusPvm) {
		this.id = id;
		this.kuvaus = kuvaus;
		this.lisatiedot = lisatiedot;
		this.status = status;
		this.pvm = pvm;
		this.muistutusPvm = muistutusPvm;
	}
	
	//Getit ja Setit
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

	public Date getPvm() {
		return pvm;
	}

	public Date getMuistutusPvm() {
		return muistutusPvm;
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

	public void setPvm(Date pvm) {
		this.pvm = pvm;
	}

	public void setMuistutusPvm(Date muistutusPvm) {
		this.muistutusPvm = muistutusPvm;
	}

	//toString
	@Override
	public String toString() {
		return "Tehtava [id=" + id + ", kuvaus=" + kuvaus + ", lisatiedot="
				+ lisatiedot + ", status=" + status + ", pvm=" + pvm
				+ ", muistutusPvm=" + muistutusPvm + "]";
	}

}
