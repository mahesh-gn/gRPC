package com.insp.FeignClientNotification.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.insp.FeignClientNotification.DTO.Notification;

public interface NotificationRepository extends MongoRepository<Notification, String> {

}
