package com.insp.FeignClientStudent;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class FeignClientStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignClientStudentApplication.class, args);
	}
	
	@Value("${url}")
    private String notificationServiceUrl;
	
	@Bean
    public String getNotificationServiceUrl() {
        return notificationServiceUrl;
    }

}
