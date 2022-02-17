package com.software.api;

public class Software {

    private int swID;
    private String swName;
    private double swVersion;
    private String swDescription;
    private byte[] swFile;	
    private int categoryID;
    
	public int getSwID() {
		return swID;
	}
	public void setSwID(int swID) {
		this.swID = swID;
	}
	public String getSwName() {
		return swName;
	}
	public void setSwName(String swName) {
		this.swName = swName;
	}
	public double getSwVersion() {
		return swVersion;
	}
	public void setSwVersion(double swVersion) {
		this.swVersion = swVersion;
	}
	public String getSwDescription() {
		return swDescription;
	}
	public void setSwDescription(String swDescription) {
		this.swDescription = swDescription;
	}
	public byte[] getSwFile() {
		return swFile;
	}
	public void setSwFile(byte[] swFile) {
		this.swFile = swFile;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	@Override
	public String toString() {
		return "Software [swID=" + swID + ", swName=" + swName + ", swVersion=" + swVersion + ", swDescription="
				+ swDescription + ", swFile=" + swFile + ", categoryID=" + categoryID + "]";
	}
}
