package com.javalaniyoruz.springredis.service;

import com.javalaniyoruz.springredis.dto.StudentDTO;

import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface StudentService {
    StudentDTO saveStudent(StudentDTO studentDTO);
    @Cacheable(value = "allStudents")
    List<StudentDTO> getAllStudent();

    StudentDTO getById(Integer id);
}
