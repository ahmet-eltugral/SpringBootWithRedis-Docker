package com.javalaniyoruz.springredis.entity;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

import lombok.Data;

@Data
@RedisHash("Student")
public class Student implements Serializable {
    Integer id;
    String name;
}
