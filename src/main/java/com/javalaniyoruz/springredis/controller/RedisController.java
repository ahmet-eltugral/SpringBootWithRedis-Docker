package com.javalaniyoruz.springredis.controller;

import com.javalaniyoruz.springredis.service.RedisLogService;
import com.javalaniyoruz.springredis.serviceImpl.RedisMessageSubscriber;
import com.javalaniyoruz.springredis.serviceImpl.RedisMessagePublisher;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/redis")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RedisController {
    private static final Logger logger = LoggerFactory.getLogger(RedisController.class);

    private final RedisMessagePublisher messagePublisher;

    private final RedisMessageSubscriber redisMessageSubscriber;
    private final RedisLogService redisLogService;

    @PostMapping("/publish")
    public void publishMessage(@RequestBody String message) {
        logger.info("Publishing : {}", message);
        messagePublisher.publish(message);
        redisLogService.logMessage("messageLog", message);
    }
    @GetMapping("/subscribe")

    public List<String> getMessages() {
        logger.info("Subscribing : {}",redisMessageSubscriber.getMessages());
        redisLogService.logMessageList("Subscribing : {}",redisMessageSubscriber.getMessages());
        return redisMessageSubscriber.getMessages();

    }
}
