package com.javalaniyoruz.springredis.controller;

import com.javalaniyoruz.springredis.dto.StudentDTO;
import com.javalaniyoruz.springredis.entity.Student;
import com.javalaniyoruz.springredis.repo.StudentRepository;
import com.javalaniyoruz.springredis.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/service")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StudentController {
    private final StudentRepository studentRepository;
    private final StudentService studentService;
    @GetMapping("/getAllStudent")
    public List<StudentDTO> getAllStudent(){
        return studentService.getAllStudent();
    }
    @PostMapping("/saveStudent")
    public StudentDTO saveStudent(@RequestBody StudentDTO student)
    {
       return studentService.saveStudent(student);
    }
    @GetMapping("/getById")
    public StudentDTO StudentgetById(@RequestParam Integer id){
        return studentService.getById(id);
    }
    /*@PostConstruct
    public void saveStudent(){
        Student student = new Student();
        student.setId(1);
        student.setName("ahmet");
        studentRepository.save(student);
    }*/
}
