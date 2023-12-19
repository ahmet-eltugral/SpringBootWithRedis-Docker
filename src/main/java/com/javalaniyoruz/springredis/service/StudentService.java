package com.javalaniyoruz.springredis.service;

import com.javalaniyoruz.springredis.dto.StudentDTO;
import com.javalaniyoruz.springredis.entity.Student;

import java.util.List;

public interface StudentService {
    StudentDTO saveStudent(StudentDTO studentDTO);

    List<StudentDTO> getAllStudent();

    StudentDTO getById(Integer id);
}
