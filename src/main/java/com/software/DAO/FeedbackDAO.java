package com.software.DAO;

import java.util.List;

import com.software.api.Feedback;

public interface FeedbackDAO {
	public int saveFeedback(Feedback fb, String id);
	public List<Feedback> loadFeedbacks();
	public Feedback getFeedbackByID(int id);
}
