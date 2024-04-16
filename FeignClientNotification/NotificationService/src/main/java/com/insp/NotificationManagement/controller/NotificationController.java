package com.insp.NotificationManagement.controller;


import com.insp.NotificationManagement.model.Notification;
import com.insp.NotificationManagement.model.Student;
import com.insp.NotificationManagement.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class NotificationController {
    @Autowired
    NotificationRepository notificationRepository;

    @PostMapping("/save")
    public Notification save(@RequestBody Student student) {

        Notification notification = new Notification();
        notification.setNotificationId(1);
        notification.setType("added");
        notification.setPayload(student);
        notification.setCreatedOn(LocalDate.now().toString());

        return notificationRepository.save(notification);
    }
}
