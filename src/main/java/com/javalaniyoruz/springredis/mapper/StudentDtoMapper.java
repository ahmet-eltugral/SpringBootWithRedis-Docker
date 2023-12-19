package com.javalaniyoruz.springredis.mapper;

import com.javalaniyoruz.springredis.dto.StudentDTO;
import com.javalaniyoruz.springredis.entity.Student;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDtoMapper {
    public StudentDTO map (Student student){
        return StudentDTO.builder()
                .id(student.getId())
                .name(student.getName()).build();
    }
    public Student converToEntity(StudentDTO studentDTO)
    {
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setName(studentDTO.getName());
        return student;
    }

    public List<StudentDTO> mapList(List<Student> list) {
        List<StudentDTO> mappedList = new ArrayList<>();
        for (Student student : list) {
            mappedList.add(this.map(student));
        }
        return mappedList;
    }




}
