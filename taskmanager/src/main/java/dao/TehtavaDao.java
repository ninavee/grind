package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import java.util.Date;

import bean.Tehtava;

public class TehtavaDao {
	
	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	// Tehtävän lisäys
	public void add(Tehtava tehtava) {
		final String sql = "INSERT INTO Tehtava(t_kuvaus, t_lisatiedot, t_status, t_pvm, t_muistutuspvm) values(?, ?, ?, ?, ?, ?)";
		final String kuvaus = tehtava.getKuvaus();
		final String lisatiedot = tehtava.getLisatiedot();
		final int status = tehtava.getStatus();
		final Date pvm = tehtava.getPvm();
		final Date muistutusPvm = tehtava.getMuistutusPvm();
		KeyHolder idHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
				ps.setString(1, kuvaus);
				ps.setString(2, lisatiedot);
				ps.setInt(3, status);
				ps.setDate(4, pvm);
				ps.setDate(5, muistutusPvm);
				return ps;
			}
		}, idHolder);
		tehtava.setId((idHolder.getKey().intValue() + ""));
	}
	
	//Kaikkien tehtävien listaus

	//Tehtävän poisto
	
	//Tehtävän muokkaus
	
	
}
