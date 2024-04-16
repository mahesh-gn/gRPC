package com.insp.FeignClientStudent.DTO;

import java.time.LocalDate;

public class Notification {

    int notificationId;
    String notificationType;
    Student payload;
    LocalDate date;

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public Student getPayload() {
        return payload;
    }

    public void setPayload(Student payload) {
        this.payload = payload;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setNotificationId(int notificationId)
    {
        this.notificationId = notificationId;

    }

    public int getNotificationId() {
        return notificationId;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationType='" + notificationType + '\'' +
                ", payload=" + payload +
                ", date=" + date +
                '}';
    }
}
