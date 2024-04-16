package com.insp.NotificationManagement.service;

import com.insp.NotificationManagement.model.Notification;
import com.insp.NotificationManagement.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;
    public Notification getNotificationById(int id)
    {
        Optional<Notification> optional = notificationRepository.findById(id);
        if(optional.isPresent())
        {
            return optional.get();
        }
        return null;
    }
}
