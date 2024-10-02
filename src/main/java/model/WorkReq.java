package model;

import java.time.LocalDateTime;

public class WorkReq {
	private String name;
	private LocalDateTime workReqDate;
	private String workReqWork;
	private String workReqReason;
	private String workReqNote;
	
	public WorkReq() {}
	// All
	public WorkReq(String name, LocalDateTime workReqDate, String workReqWork, String workReqReason, String workReqNote) {
		this.name = name;
		this.workReqDate = workReqDate;
		this.workReqWork = workReqWork;
		this.workReqReason = workReqReason;
		this.workReqNote = workReqNote;
	}
	// workReqNoteなし
	public WorkReq(String name, LocalDateTime workReqDate, String workReqWork, String workReqReason) {
		this.name = name;
		this.workReqDate = workReqDate;
		this.workReqWork = workReqWork;
		this.workReqReason = workReqReason;
	}
	//以下getterとsettter
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getWorkReqDate() {
		return workReqDate;
	}
	public void setWorkReqDate(LocalDateTime workReqDate) {
		this.workReqDate = workReqDate;
	}
	public String getWorkReqWork() {
		return workReqWork;
	}
	public void setWorkReqWork(String workReqWork) {
		this.workReqWork = workReqWork;
	}
	public String getWorkReqReason() {
		return workReqReason;
	}
	public void setWorkReqReason(String workReqReason) {
		this.workReqReason = workReqReason;
	}
	public String getWorkReqNote() {
		return workReqNote;
	}
	public void setWorkReqNote(String workReqNote) {
		this.workReqNote = workReqNote;
	}
	
}
