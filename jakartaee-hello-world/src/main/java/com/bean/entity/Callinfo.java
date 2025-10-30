package com.bean.entity;

public class Callinfo {
	private String VAR_TOTALCALLS;
	private String VAR_ACTIVECHANNELS;
	private String VAR_ACTIVECALLS;
	public String getVAR_TOTALCALLS() {
		return VAR_TOTALCALLS;
	}
	public void setVAR_TOTALCALLS(String vAR_TOTALCALLS) {
		VAR_TOTALCALLS = vAR_TOTALCALLS;
	}
	public String getVAR_ACTIVECHANNELS() {
		return VAR_ACTIVECHANNELS;
	}
	public void setVAR_ACTIVECHANNELS(String vAR_ACTIVECHANNELS) {
		VAR_ACTIVECHANNELS = vAR_ACTIVECHANNELS;
	}
	public String getVAR_ACTIVECALLS() {
		return VAR_ACTIVECALLS;
	}
	public void setVAR_ACTIVECALLS(String vAR_ACTIVECALLS) {
		VAR_ACTIVECALLS = vAR_ACTIVECALLS;
	}
	@Override
    public String toString() { 
        return "Person [Mob=" + VAR_ACTIVECALLS + ", Uniqueid=" + VAR_ACTIVECHANNELS + ", Filepath=" + VAR_TOTALCALLS + "]";
		//return "";
    } 
}
