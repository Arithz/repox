package com.software.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.software.api.Feedback;

public class FeedbackRowMapper implements RowMapper<Feedback> {
	public Feedback mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Feedback fb = new Feedback();
		
		fb.setFeedbackID(rs.getInt("feedbackID"));
		fb.setfeedbackDetails(rs.getString("feedbackDetails"));
		fb.setUserID(rs.getInt("userID"));
		
		return fb;
	}
}