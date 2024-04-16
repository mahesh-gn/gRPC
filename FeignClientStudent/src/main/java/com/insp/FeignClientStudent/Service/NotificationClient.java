package com.insp.FeignClientStudent.Service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.insp.FeignClientStudent.DTO.Student;

@FeignClient (name = "notification-service", url = "${url}")
public interface NotificationClient {
	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student student) ;
}
