package com.javalaniyoruz.springredis.dto;

import com.javalaniyoruz.springredis.entity.Student;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StudentDTO {
    private Integer id;
    private String name;


}
