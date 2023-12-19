package com.javalaniyoruz.springredis.serviceImpl;

import com.javalaniyoruz.springredis.entity.Student;
import com.javalaniyoruz.springredis.mapper.StudentDtoMapper;
import com.javalaniyoruz.springredis.service.StudentService;
import com.javalaniyoruz.springredis.dto.StudentDTO;
import com.javalaniyoruz.springredis.repo.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentDtoMapper mapper;
    public StudentDTO saveStudent(StudentDTO studentDTO)
    {
        return mapper.map(studentRepository.save(mapper.converToEntity(studentDTO)));
    }

    public List<StudentDTO> getAllStudent(){
        List<Student> student = new ArrayList<>();

        studentRepository.findAll().iterator().forEachRemaining(student::add);
        return mapper.mapList(student);
    }

}
