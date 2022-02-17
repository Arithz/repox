package com.software.api;

import java.sql.Date;

public class RequestSoftware {

    private int reqID;
    private String reqStatus;
    private Date reqDate;

    private String reqswName;

    private double reqswVersion;

    private int userID;
    private int adminID;
    
	public int getReqID() {
		return reqID;
	}
	public void setReqID(int reqID) {
		this.reqID = reqID;
	}
	public String getReqStatus() {
		return reqStatus;
	}
	public void setReqStatus(String reqStatus) {
		this.reqStatus = reqStatus;
	}
	public Date getReqDate() {
		return reqDate;
	}
	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}
	public String getReqswName() {
		return reqswName;
	}
	public void setReqswName(String reqswName) {
		this.reqswName = reqswName;
	}
	public double getReqswVersion() {
		return reqswVersion;
	}
	public void setReqswVersion(double reqswVersion) {
		this.reqswVersion = reqswVersion;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
}
