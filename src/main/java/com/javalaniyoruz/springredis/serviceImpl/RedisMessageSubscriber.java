package com.javalaniyoruz.springredis.serviceImpl;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RedisMessageSubscriber implements MessageListener {
    public List<String> messageList = new ArrayList<>();

    @Override
    public void onMessage(Message message, byte[] bytes) {;
        messageList.add(message.toString());
    }

    public List<String> getMessages() {
        return messageList;
    }

}
