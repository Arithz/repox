package com.software.api;

public class Feedback {

    private int feedbackID;
    private int userID;
    private String feedbackDetails;
    
	public int getFeedbackID() {
		return feedbackID;
	}
	public void setFeedbackID(int feedbackID) {
		this.feedbackID = feedbackID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getfeedbackDetails() {
		return feedbackDetails;
	}
	public void setfeedbackDetails(String feedbackDetails) {
		this.feedbackDetails = feedbackDetails;
	}
	@Override
	public String toString() {
		return "Feedback [feedbackID=" + feedbackID + ", userID=" + userID + ", feedbackDetails=" + feedbackDetails
				+ "]";
	}
    
    
}
