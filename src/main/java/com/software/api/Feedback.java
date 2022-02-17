package com.software.api;

public class Feedback {

    private int feedbackID;
    private int swNum;
    private int userID;
    private String summary;
    
	public int getFeedbackID() {
		return feedbackID;
	}
	public void setFeedbackID(int feedbackID) {
		this.feedbackID = feedbackID;
	}
	public int getSwNum() {
		return swNum;
	}
	public void setSwNum(int swNum) {
		this.swNum = swNum;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	@Override
	public String toString() {
		return "Feedback [feedbackID=" + feedbackID + ", swNum=" + swNum + ", userID=" + userID + ", summary=" + summary
				+ "]";
	}
    
    
}
