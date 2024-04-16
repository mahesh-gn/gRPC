package com.insp.FeignClientNotification.Controller;

import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insp.FeignClientNotification.DTO.Notification;
import com.insp.FeignClientNotification.DTO.Student;
import com.insp.FeignClientNotification.Repository.NotificationRepository;


@RestController
public class NotificationController {
	@Autowired
	NotificationRepository notificationRepository;
	
	@PostMapping("/save")
	public Notification save(@RequestBody Student student) {
		
		Notification notification = new Notification();
		notification.setId(student.getId());
		notification.setType("added");
		notification.setSt(student);
		notification.setCreatedOn(LocalDate.now().toString());
		
		return notificationRepository.save(notification);
	}
}
