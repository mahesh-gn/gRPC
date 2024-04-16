package com.insp.FeignClientStudent.Controller;

import java.util.List;

import java.util.Map;

import com.google.protobuf.Descriptors;
import com.insp.FeignClientStudent.DTO.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.insp.FeignClientStudent.DTO.Student;
import com.insp.FeignClientStudent.Service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@Autowired
    private Environment env;
	
	@PostMapping("/saveData")
    public Object saveStudent(@RequestBody Student student) {
		String myProperty = env.getProperty("url");
		ResponseEntity<Object> data = studentService.saveData(student,myProperty);
		if (data.getStatusCode() == HttpStatus.CONFLICT) {
			return "Student ID already Exists";
		}else {
			return "Student Data saved Successfully";
		}
    }

    public void someMethod() {
        String myProperty = env.getProperty("url");
        System.out.println("Value of my.property: " + myProperty);
    }
	
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents() {
		someMethod();
		
		List<Student> allDetails = studentService.getAllDetails();
		return allDetails;
	}
	
	@GetMapping("/findById/{id}")
	public Object findByStId(@PathVariable int id) {
		return studentService.getById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		ResponseEntity<Student> deleteStudent = studentService.deleteStudent(id);
		if(deleteStudent.getStatusCode()==HttpStatus.OK) {
			return "Student Data Deleted";
		}else {
			return "Studnet ID Not Found";
		}
	}
	
	@PutMapping("/update/{id}")
	public void updateStudent(@PathVariable int id, @RequestBody Student student) {
		
	}

	@GetMapping("/byId")
	public Map<Descriptors.FieldDescriptor, Object> getNotificationById(@RequestParam int id)
	{
		NotificationRequest request = NotificationRequest.newBuilder().setNotificationId(id).build();
		return studentService.getNotificationById(request);
	}

	@GetMapping("/allNotifications")
	public List<Map<String, Object>> getAllNotifications() {
		return studentService.getAllNotifications();
	}
}
