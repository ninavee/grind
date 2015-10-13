package task.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.jdbc.core.RowMapper;

import task.bean.Tehtava;
import task.bean.TehtavaImpl;

public class TehtavaRowMapper implements RowMapper<Tehtava> {

	public TehtavaImpl mapRow(ResultSet rs, int rowNum) throws SQLException {
		TehtavaImpl tehtava = new TehtavaImpl();
		tehtava.setId(rs.getInt("t_id"));
		tehtava.setKuvaus(rs.getString("t_kuvaus"));
		tehtava.setLisatiedot(rs.getString("t_lisatiedot"));
		tehtava.setStatus(rs.getInt("t_status"));
		tehtava.setPvmaika(LocalDateTime.parse(rs.getString("t_deadlinedtm"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
		tehtava.setMuistutusPvmaika(LocalDateTime.parse(rs.getString("t_muistutusdtm"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
		return tehtava;
	}
}
