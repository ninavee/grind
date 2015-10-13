package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.time.LocalDateTime;

//import java.util.List;
import javax.inject.Inject;


//import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
import java.util.List;

import bean.Tehtava;

public class TehtavaDaoImpl implements TehtavaDao {
	
	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	// Tehtävän lisäys
	public void lisaaTehtava(Tehtava tehtava) {
		final String sql = "INSERT INTO Tehtava(t_kuvaus, t_lisatiedot, t_status, t_deadlinedtm, t_muistutusdtm) values(?, ?, ?, ?, ?, ?)";
		final String kuvaus = tehtava.getKuvaus();
		final String lisatiedot = tehtava.getLisatiedot();
		final int status = tehtava.getStatus();
		final LocalDateTime deadlinedtm = tehtava.getPvmaika();
		final LocalDateTime muistutusdtm = tehtava.getMuistutusPvmaika();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
				ps.setString(1, kuvaus);
				ps.setString(2, lisatiedot);
				ps.setInt(3, status);
				
				// MySQL-tietokannassa DATETIME-formaatti on muodossa [yyyy-mm-dd hh:mm:ss].
				// Oikea muoto Javan date-oliosta saadaa java.sql.Timestamp:illa ja
				// PreparedStatementin setTimestamp:illa.
				ps.setTimestamp(4, java.sql.Timestamp.valueOf(deadlinedtm));
				ps.setTimestamp(5, java.sql.Timestamp.valueOf(muistutusdtm));
				return ps;
			}
		});
		
	}
	
	//Kaikkien tehtävien listaus
	
	public List<Tehtava> haeKaikki() {
		String sql = "SELECT t_id, t_kuvaus FROM tehtava";
		RowMapper<Tehtava> mapper = new TehtavaRowMapper();
		List<Tehtava> tehtavat = jdbcTemplate.query(sql, mapper);
		return tehtavat;
	}
	
	/*
	//Tehtävän poisto
	public void poistaTehtava(int id) {
		try {
			String sql = "DELETE from tehtava WHERE t_id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.executeUpdate();
		} catch(Exception e){
			throw new DaoPoikkeus("Tehtävän poisto epäonnistui", e);
		}
		
		
	}
	*/
	//Tehtävän muokkaus
	
	
	
}
