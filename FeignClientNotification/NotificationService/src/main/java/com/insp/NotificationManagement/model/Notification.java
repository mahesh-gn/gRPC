package com.insp.NotificationManagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
@Document("notificationTracker")
public class Notification {
    @Id
   private int notificationId;
    public int getNotificationId() {
        return notificationId;
    }
    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }
    String type;
    Student payload;
    String createdOn;
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Student getPayload() {
        return payload;
    }
    public void setPayload(Student payload) {
        this.payload = payload;
    }
    public String getCreatedOn() {
        return createdOn;
    }
    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }
}
