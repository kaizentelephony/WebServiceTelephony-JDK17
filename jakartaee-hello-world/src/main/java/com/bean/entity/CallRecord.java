package com.bean.entity;
 
import java.sql.Date;
import java.time.LocalDate;
 
public class CallRecord { 
	 //insert into VAR_ENROLLMENT(var_date,var_cust_mob,var_Uniqueid,VAR_LANGUAGE,Flag,File_path,Var_file,process_flag) 
    private String var_mob;
    private String var_uniqueId;
  //  private String var_filePath;
	private String var_calledDate;
    private String var_startTime;
    private String var_endTime;
    private String var_duration;
    private String var_dnis;
    private String var_channelNo;
    private String var_registeredStatus;
    private String var_language;
    // Enrollment Table
    private String var_flag;
    private String var_filepath;
    private String var_file;
    private String var_proc_flag;
    private String var_sftpflag;
    //Insert into VAR_AGENT_DETAILS (var_caller_id, var_patch_start_time,var_VDN,var_unique_id)
    //VAR_PATCH_START_TIME,VAR_PATCH_END_TIME,VAR_PATCH_DURATION

    // Agent Table
    private String var_patchstarttime;
    private String var_patchendtime;
    private String var_patchduration;
    private String var_vdn;
    private String var_callstatus;
    //CALL DETAILS
    private String VAR_CALLERID;
    private String VAR_UNIQUEID;
    private String VAR_CONTRACTNO;
    private String VAR_CONVERSATIONID;
    private String VAR_CALLED_DATE;
    private String VAR_CALL_START_TIME;
    private String VAR_CALL_END_TIME;
    private String VAR_DURATION;
    private String VAR_DNIS;
    private String VAR_CHANNELID;
    private String VAR_REGISTEREDSTATUS;
    private String VAR_LANAGUAGE;
    // CALL TRANSFERDETAIL
    /*private String VAR_CALLERID;
    private String VAR_UNIQUEID;
    private String VAR_CONTRACTNO;
    private String VAR_CONVERSATIONID;*/
    private String VAR_PATCH_START_TIME;
    private String VAR_PATCH_END_TIME;
    private String VAR_PATCH_DURATION;
    private String VAR_TRANSFERVDN;
    private String VAR_TRANSFERSTATUS;
    ///ENROLLMENT
    private String VAR_FILEPATH;
    private String VAR_CALLSTATUS;
    private String VAR_BVPSTATUS;
   // private String VAR_TRANSFERVDN;
    //VERIFICATION
    private String VAR_PROCESSFLAG;
    private String VAR_FLAG;
    private String VAR_CALL_STATUS;
    private String VAR_VERIFICATION_STATUS;
    private String VAR_SCORE;
   // private String VAR_FILEPATH;
    
    
    
    private String VAR_FLOW;
    private String VAR_DISCONNECT_TRACE;
    private String VAR_REGISTERED_NUMBER;
    private String VAR_VOICEPRINT;
   

   // private String

   public String getVAR_VOICEPRINT() {
		return VAR_VOICEPRINT;
	}
	public void setVAR_VOICEPRINT(String vAR_VOICEPRINT) {
		VAR_VOICEPRINT = vAR_VOICEPRINT;
	}
public String getVAR_REGISTERED_NUMBER() {
		return VAR_REGISTERED_NUMBER;
	}
	public void setVAR_REGISTERED_NUMBER(String vAR_REGISTERED_NUMBER) {
		VAR_REGISTERED_NUMBER = vAR_REGISTERED_NUMBER;
	}
public String getVAR_FLOW() {
		return VAR_FLOW;
	}
	public String getVAR_VERIFICATION_STATUS() {
	return VAR_VERIFICATION_STATUS;
}
public void setVAR_VERIFICATION_STATUS(String vAR_VERIFICATION_STATUS) {
	VAR_VERIFICATION_STATUS = vAR_VERIFICATION_STATUS;
}
public String getVAR_SCORE() {
	return VAR_SCORE;
}
public void setVAR_SCORE(String vAR_SCORE) {
	VAR_SCORE = vAR_SCORE;
}
	public void setVAR_FLOW(String vAR_FLOW) {
		VAR_FLOW = vAR_FLOW;
	}
	public String getVAR_DISCONNECT_TRACE() {
		return VAR_DISCONNECT_TRACE;
	}
	public void setVAR_DISCONNECT_TRACE(String vAR_DISCONNECT_TRACE) {
		VAR_DISCONNECT_TRACE = vAR_DISCONNECT_TRACE;
	}
public String getVAR_CALL_STATUS() {
		return VAR_CALL_STATUS;
	}
	public void setVAR_CALL_STATUS(String vAR_CALL_STATUS) {
		VAR_CALL_STATUS = vAR_CALL_STATUS;
	}
	// insert into VAR_VERIFICATION (var_date,var_cust_mob,var_Uniqueid,VAR_LANGUAGE,Flag,File_path,Var_file)
    // Verification
    //private String var_
	public String getVAR_PROCESSFLAG() {
		return VAR_PROCESSFLAG;
	}
	public void setVAR_PROCESSFLAG(String vAR_PROCESSFLAG) {
		VAR_PROCESSFLAG = vAR_PROCESSFLAG;
	}
	public String getVAR_FLAG() {
		return VAR_FLAG;
	}
	public void setVAR_FLAG(String vAR_FLAG) {
		VAR_FLAG = vAR_FLAG;
	}
	public String getVAR_CALLERID() {
		return VAR_CALLERID;
	}
	public String getVAR_BVPSTATUS() {
		return VAR_BVPSTATUS;
	}
	public void setVAR_BVPSTATUS(String vAR_BVPSTATUS) {
		VAR_BVPSTATUS = vAR_BVPSTATUS;
	}
	public void setVAR_CALLERID(String vAR_CALLERID) {
		VAR_CALLERID = vAR_CALLERID;
	}
	public String getVAR_UNIQUEID() {
		return VAR_UNIQUEID;
	}
	public void setVAR_UNIQUEID(String vAR_UNIQUEID) {
		VAR_UNIQUEID = vAR_UNIQUEID;
	}
	public String getVAR_CONTRACTNO() {
		return VAR_CONTRACTNO;
	}
	public void setVAR_CONTRACTNO(String vAR_CONTRACTNO) {
		VAR_CONTRACTNO = vAR_CONTRACTNO;
	}
	public String getVAR_CONVERSATIONID() {
		return VAR_CONVERSATIONID;
	}
	public void setVAR_CONVERSATIONID(String vAR_CONVERSATIONID) {
		VAR_CONVERSATIONID = vAR_CONVERSATIONID;
	}
	public String getVAR_CALLED_DATE() {
		return VAR_CALLED_DATE;
	}
	public void setVAR_CALLED_DATE(String vAR_CALLED_DATE) {
		VAR_CALLED_DATE = vAR_CALLED_DATE;
	}
	public String getVAR_CALL_START_TIME() {
		return VAR_CALL_START_TIME;
	}
	public void setVAR_CALL_START_TIME(String vAR_CALL_START_TIME) {
		VAR_CALL_START_TIME = vAR_CALL_START_TIME;
	}
	public String getVAR_CALL_END_TIME() {
		return VAR_CALL_END_TIME;
	}
	public void setVAR_CALL_END_TIME(String vAR_CALL_END_TIME) {
		VAR_CALL_END_TIME = vAR_CALL_END_TIME;
	}
	public String getVAR_DURATION() {
		return VAR_DURATION;
	}
	public void setVAR_DURATION(String vAR_DURATION) {
		VAR_DURATION = vAR_DURATION;
	}
	public String getVAR_DNIS() {
		return VAR_DNIS;
	}
	public void setVAR_DNIS(String vAR_DNIS) {
		VAR_DNIS = vAR_DNIS;
	}
	public String getVAR_CHANNELID() {
		return VAR_CHANNELID;
	}
	public void setVAR_CHANNELID(String vAR_CHANNELID) {
		VAR_CHANNELID = vAR_CHANNELID;
	}
	public String getVAR_REGISTEREDSTATUS() {
		return VAR_REGISTEREDSTATUS;
	}
	public void setVAR_REGISTEREDSTATUS(String vAR_REGISTEREDSTATUS) {
		VAR_REGISTEREDSTATUS = vAR_REGISTEREDSTATUS;
	}
	public String getVAR_LANAGUAGE() {
		return VAR_LANAGUAGE;
	}
	public void setVAR_LANAGUAGE(String vAR_LANAGUAGE) {
		VAR_LANAGUAGE = vAR_LANAGUAGE;
	}
	public String getVAR_PATCH_START_TIME() {
		return VAR_PATCH_START_TIME;
	}
	public void setVAR_PATCH_START_TIME(String vAR_PATCH_START_TIME) {
		VAR_PATCH_START_TIME = vAR_PATCH_START_TIME;
	}
	public String getVAR_PATCH_END_TIME() {
		return VAR_PATCH_END_TIME;
	}
	public void setVAR_PATCH_END_TIME(String vAR_PATCH_END_TIME) {
		VAR_PATCH_END_TIME = vAR_PATCH_END_TIME;
	}
	public String getVAR_PATCH_DURATION() {
		return VAR_PATCH_DURATION;
	}
	public void setVAR_PATCH_DURATION(String vAR_PATCH_DURATION) {
		VAR_PATCH_DURATION = vAR_PATCH_DURATION;
	}
	public String getVAR_TRANSFERVDN() {
		return VAR_TRANSFERVDN;
	}
	public void setVAR_TRANSFERVDN(String vAR_TRANSFERVDN) {
		VAR_TRANSFERVDN = vAR_TRANSFERVDN;
	}
	public String getVAR_TRANSFERSTATUS() {
		return VAR_TRANSFERSTATUS;
	}
	public void setVAR_TRANSFERSTATUS(String vAR_TRANSFERSTATUS) {
		VAR_TRANSFERSTATUS = vAR_TRANSFERSTATUS;
	}
	public String getVAR_FILEPATH() {
		return VAR_FILEPATH;
	}
	public void setVAR_FILEPATH(String vAR_FILEPATH) {
		VAR_FILEPATH = vAR_FILEPATH;
	}
	public String getVAR_CALLSTATUS() {
		return VAR_CALLSTATUS;
	}
	public void setVAR_CALLSTATUS(String vAR_CALLSTATUS) {
		VAR_CALLSTATUS = vAR_CALLSTATUS;
	}
	public String getVar_calledDate() {
		return var_calledDate;
	}
	public void setVar_calledDate(String var_calledDate) {
		this.var_calledDate = var_calledDate;
	}
	public String getVar_startTime() {
		return var_startTime;
	}
	public void setVar_startTime(String var_startTime) {
		this.var_startTime = var_startTime;
	}
	public String getVar_endTime() {
		return var_endTime;
	}
	public void setVar_endTime(String var_endTime) {
		this.var_endTime = var_endTime;
	}
   public String getVar_duration() {
		return var_duration;
	}
	public void setVar_duration(String var_duration) {
		this.var_duration = var_duration;
	}
	public String getVar_dnis() {
		return var_dnis;
	}
	public void setVar_dnis(String var_dnis) {
		this.var_dnis = var_dnis;
	}
	public String getVar_channelNo() {
		return var_channelNo;
	}
	public void setVar_channelNo(String var_channelNo) {
		this.var_channelNo = var_channelNo;
	}
	public String getVar_registeredStatus() {
		return var_registeredStatus;
	}
	public void setVar_registeredStatus(String var_registeredStatus) {
		this.var_registeredStatus = var_registeredStatus;
	}
	public String getVar_language() {
		return var_language;
	}
	public void setVar_language(String var_language) {
		this.var_language = var_language;
	}
    public String getVar_mob() {
		return var_mob;
	}
	public void setVar_mob(String var_mob) {
		this.var_mob = var_mob;
	}
	public String getVar_uniqueId() {
		return var_uniqueId;
	}
	public void setVar_uniqueId(String var_uniqueId) {
		this.var_uniqueId = var_uniqueId;
	}

    public String getVar_flag() {
		return var_flag;
	}
	public void setVar_flag(String var_flag) {
		this.var_flag = var_flag;
	}
	public String getVar_filepath() {
		return var_filepath;
	}
	public void setVar_filepath(String var_filepath) {
		this.var_filepath = var_filepath;
	}
	public String getVar_file() {
		return var_file;
	}
	public void setVar_file(String var_file) {
		this.var_file = var_file;
	}
	public String getVar_proc_flag() {
		return var_proc_flag;
	}
	public void setVar_proc_flag(String var_proc_flag) {
		this.var_proc_flag = var_proc_flag;

	}
	public String getVar_patchstarttime() {
		return var_patchstarttime;
	}
	public void setVar_patchstarttime(String var_patchstarttime) {
		this.var_patchstarttime = var_patchstarttime;
	}
	public String getVar_patchendtime() {
		return var_patchendtime;
	}
	public void setVar_patchendtime(String var_patchendtime) {
		this.var_patchendtime = var_patchendtime;
	}
	public String getVar_patchduration() {
		return var_patchduration;
	}
	public void setVar_patchduration(String var_patchduration) {
		this.var_patchduration = var_patchduration;
	}
	public String getVar_vdn() {
		return var_vdn;
	}
	public void setVar_vdn(String var_vdn) {
		this.var_vdn = var_vdn;
	}
	public String getVar_sftpflag() {
		return var_sftpflag;
	}
	public void setVar_sftpflag(String var_sftpflag) {
		this.var_sftpflag = var_sftpflag;
	}


	public String getVar_callstatus() {
		return var_callstatus;
	}
	public void setVar_callstatus(String var_callstatus) {
		this.var_callstatus = var_callstatus;
	}
	@Override
    public String toString() { 
      //  return "Person [Mob=" + var_mob + ", Uniqueid=" + var_uniqueId + ", Filepath=" + var_language + "]";
		return "";
    } 
}