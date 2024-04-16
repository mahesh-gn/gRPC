package com.insp.FeignClientStudent.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.insp.FeignClientStudent.DTO.Student;

public interface StudentRepository extends MongoRepository<Student, Integer> {

}
