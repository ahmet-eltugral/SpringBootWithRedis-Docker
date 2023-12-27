package com.javalaniyoruz.springredis.service;

public interface MessagePublisher {
    void publish(String message);
}
