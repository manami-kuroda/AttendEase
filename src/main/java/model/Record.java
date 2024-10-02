package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Record {
	private String userId;
	private LocalDate workDate;
	private LocalDateTime workIn;
	private LocalDateTime breakIn;
	private LocalDateTime breakOut;
	private LocalDateTime workOut;
	
	public Record() {}
	// All
	public Record(String userId, LocalDate workDate, LocalDateTime workIn, LocalDateTime breakIn, LocalDateTime breakOut, LocalDateTime workOut) {
		this.userId = userId;
		this.workDate = workDate;
		this.workIn = workIn;
		this.breakIn = breakIn;
		this.breakOut = breakOut;
		this.workOut = workOut;
	}
	// list
	public Record(LocalDate workDate, LocalDateTime workIn, LocalDateTime breakIn, LocalDateTime breakOut, LocalDateTime workOut) {
		this.workDate = workDate;
		this.workIn = workIn;
		this.breakIn = breakIn;
		this.breakOut = breakOut;
		this.workOut = workOut;
	}
	
	// 以下getterとsettter
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public LocalDate getWorkDate() {
		return workDate;
	}
	public void setWorkDate(LocalDate workDate) {
		this.workDate = workDate;
	}
	public LocalDateTime getWorkIn() {
		return workIn;
	}
	public void setWorkIn(LocalDateTime workIn) {
		this.workIn = workIn;
	}
	public LocalDateTime getBreakIn() {
		return breakIn;
	}
	public void setBreakIn(LocalDateTime breakIn) {
		this.breakIn = breakIn;
	}
	public LocalDateTime getBreakOut() {
		return breakOut;
	}
	public void setBreakOut(LocalDateTime breakOut) {
		this.breakOut = breakOut;
	}
	public LocalDateTime getWorkOut() {
		return workOut;
	}
	public void setWorkOut(LocalDateTime workOut) {
		this.workOut = workOut;
	}

}
