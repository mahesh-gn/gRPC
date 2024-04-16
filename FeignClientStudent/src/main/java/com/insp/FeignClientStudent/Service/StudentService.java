package com.insp.FeignClientStudent.Service;

import java.lang.reflect.Field;
import java.util.*;

import com.google.protobuf.Descriptors;
import com.proto.NotificationRequest;
import com.proto.NotificationResponse;
import com.proto.StudentNotificationServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.insp.FeignClientStudent.DTO.Student;
import com.insp.FeignClientStudent.Repository.StudentRepository;


@Service
public class StudentService{

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	NotificationClient notificationClient;

	ManagedChannel channel = ManagedChannelBuilder
			.forAddress("localhost", 9090)
			.usePlaintext() // Use plaintext for simplicity, you may want to use TLS in production
			.defaultLoadBalancingPolicy("round_robin") // Specify round-robin load balancing policy
			.build();

	StudentNotificationServiceGrpc.StudentNotificationServiceBlockingStub stub = StudentNotificationServiceGrpc.newBlockingStub(channel);


	public ResponseEntity<Object> saveData(Student student,String url) {
		int id=student.getId();
		Optional<Student> findById = studentRepository.findById(id);
		if(findById.isEmpty()) {
			studentRepository.save(student);
			notificationClient.saveStudent(student);
			return new ResponseEntity<Object>("Student Data with ID "+id+" saved Successfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>("Student with ID "+id+" Already Exists", HttpStatus.CONFLICT);
		}
	}
	
	public List<Student> getAllDetails(){
		return studentRepository.findAll();
	}
	
	public Object getById(int id) {
		Optional<Student> findById = studentRepository.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}else {
			return "Student with ID = "+id+" not Found";
		}
	}
	
	public ResponseEntity<Student> deleteStudent(int id) {
		Optional<Student> findById = studentRepository.findById(id);
		if(findById.isPresent()) {
			Student st=findById.get();
			studentRepository.delete(st);
			return new ResponseEntity<Student>(st,HttpStatus.OK);
		}else {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	}

	public Map<Descriptors.FieldDescriptor,Object> getNotificationById(NotificationRequest request)
	{
		NotificationResponse response =  stub.getNotificationById(request);

		return response.getAllFields();
    }

	public List<Map<String, Object>> getAllNotifications() {
		List<Map<String, Object>> allNotifications = new ArrayList<>();
		List<Student> students = studentRepository.findAll();

		// Iterate over each student and convert it into a map of field names to values
		for (Student student : students) {
			Map<String, Object> notificationMap = new HashMap<>();
			for (Field field : Student.class.getDeclaredFields()) {
				try {
					field.setAccessible(true);
					notificationMap.put(field.getName(), field.get(student));
				} catch (IllegalAccessException e) {
					// Handle exception as needed
				}
			}
			allNotifications.add(notificationMap);
		}
		return allNotifications;
	}


}
