package task.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import task.bean.Tehtava;
import task.bean.TehtavaImpl;

public class TestiDAO {
	
	private String username = "a1300883";
	private String password = "piJYb886a";
	private String url = "jdbc:mariadb://localhost/a1300883";
	private SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public List<Tehtava> haeKaikki() {
		Connection yhteys = null;
		List<Tehtava> lista = new ArrayList<Tehtava>();
		try {
			Class.forName("org.mariadb.jdbc.Driver").newInstance();
			yhteys = DriverManager.getConnection(url, username, password);
			String sql = "SELECT t_id, t_kuvaus, t_lisatiedot, t_status, t_deadlinedtm, t_muistutusdtm FROM tehtava";
			Statement haku = yhteys.createStatement();
			ResultSet rs = haku.executeQuery(sql);
			while (rs.next()) {
				TehtavaImpl tehtava = new TehtavaImpl();
				tehtava.setId(rs.getInt("t_id"));
				tehtava.setKuvaus(rs.getString("t_kuvaus"));
				tehtava.setLisatiedot(rs.getString("t_lisatiedot"));
				tehtava.setStatus(rs.getInt("t_status"));
				tehtava.setPvmaika(s.parse(rs.getString("t_deadlinedtm")));
				tehtava.setMuistutusPvmaika(s.parse(rs.getString("t_muistutusdtm")));
				lista.add(tehtava);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (yhteys != null && !yhteys.isClosed())
					yhteys.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return lista;
	}
}
