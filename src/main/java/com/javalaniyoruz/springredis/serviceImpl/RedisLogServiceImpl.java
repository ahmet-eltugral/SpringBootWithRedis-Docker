package com.javalaniyoruz.springredis.serviceImpl;

import com.javalaniyoruz.springredis.service.RedisLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RedisLogServiceImpl implements RedisLogService {

    private final RedisTemplate<String, String> redisTemplate;

    public void logMessage(String key, String message) {
        redisTemplate.opsForList().rightPush(key, message);
    }

    @Override
    public void logMessageList(String key, List<String> message) {
        redisTemplate.opsForList().rightPushAll(key, message);
    }
}


