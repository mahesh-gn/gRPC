package com.insp.FeignClientNotification.DTO;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("notificationTracker")
public class Notification {
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	String type;
	Student st;
	String createdOn;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Student getSt() {
		return st;
	}
	public void setSt(Student st) {
		this.st = st;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
}
