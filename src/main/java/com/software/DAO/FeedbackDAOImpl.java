package com.software.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.software.api.Feedback;
import com.software.config.MainAppConfig;
import com.software.rowmapper.FeedbackRowMapper;

@Repository
public class FeedbackDAOImpl implements FeedbackDAO {
	
	MainAppConfig mac = new MainAppConfig();

	@Autowired
	private JdbcTemplate jdbcTemplate = new JdbcTemplate(mac.dataSource());

	@Override
	public int saveFeedback(Feedback fb, String id) {
		String sql = "INSERT INTO feedback (feedbackDetails, userID) values ('"+fb.getfeedbackDetails()+"','"+id+"')";
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Feedback> loadFeedbacks() {
		String sql = "SELECT * from feedback ORDER BY feedbackID ASC";
		List<Feedback> listfeedback = jdbcTemplate.query(sql, new FeedbackRowMapper());
		return listfeedback;
	}
	
	@Override
	public Feedback getFeedbackByID(int id) {
		String sql = "SELECT * from feedback where feedbackID = '"+id+"'";
		Feedback feedback = jdbcTemplate.queryForObject(sql, new FeedbackRowMapper());
		return feedback;
	}

}
