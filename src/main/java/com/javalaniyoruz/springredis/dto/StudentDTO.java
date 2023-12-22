package com.javalaniyoruz.springredis.dto;

import com.javalaniyoruz.springredis.entity.Student;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StudentDTO implements Serializable {
    private Integer id;
    private String name;


}
