package task.bean;

import java.util.Date;

public interface Tehtava {
	
	public abstract int getId();
	
	public abstract void setId(int id);
	
	public abstract String getKuvaus();
	
	public abstract void setKuvaus(String kuvaus);
	
	public abstract String getLisatiedot();
	
	public abstract void setLisatiedot(String lisatiedot);
	
	public abstract int getStatus();
	
	public abstract void setStatus(int status);
	
	public abstract Date getPvmaika();
	
	public abstract void setPvmaika(Date pvmaika);
	
	public abstract Date getMuistutusPvmaika();
	
	public abstract void setMuistutusPvmaika(Date pvmaika);
}
