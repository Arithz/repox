package com.software.api;

public class User {

    private int userID;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userCategory;
    
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserCategory() {
		return userCategory;
	}
	public void setUserCategory(String userCategory) {
		this.userCategory = userCategory;
	}
	
	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", userPassword=" + userPassword + ", userEmail="
				+ userEmail + ", userCategory=" + userCategory + "]";
	}
	
}
