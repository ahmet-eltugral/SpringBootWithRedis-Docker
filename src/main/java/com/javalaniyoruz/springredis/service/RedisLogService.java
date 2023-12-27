package com.javalaniyoruz.springredis.service;

import java.util.List;

public interface RedisLogService {
     void logMessage(String key, String message);
    void logMessageList(String key, List<String> message);

}
