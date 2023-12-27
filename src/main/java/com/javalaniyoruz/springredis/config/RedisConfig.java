package com.javalaniyoruz.springredis.config;

import com.javalaniyoruz.springredis.service.MessagePublisher;
import com.javalaniyoruz.springredis.serviceImpl.RedisMessagePublisher;
import com.javalaniyoruz.springredis.serviceImpl.RedisMessageSubscriber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@Configuration
@ComponentScan("com.javalaniyoruz.springredis")
@EnableRedisRepositories(basePackages = "com.javalaniyoruz.springredis")
@PropertySource("classpath:application.properties")
public class RedisConfig {

    private final RedisConnectionFactory redisConnectionFactory;

    @Autowired
    public RedisConfig(RedisConnectionFactory redisConnectionFactory) {
        this.redisConnectionFactory = redisConnectionFactory;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        final RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setValueSerializer(new GenericToStringSerializer<>(Object.class));
        template.setHashValueSerializer(new GenericToStringSerializer<>(Object.class));
        template.setHashKeySerializer(new GenericToStringSerializer<>(Object.class));
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public HashOperations<String, Object, Object> hashOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForHash();
    }

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(
            RedisMessageSubscriber messageSubscriber) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        container.addMessageListener(messageSubscriber, topic());
        return container;
    }

    @Bean
    public MessageListenerAdapter messageListenerAdapter(RedisMessageSubscriber messageSubscriber) {
        return new MessageListenerAdapter(messageSubscriber, "onMessage");
    }

    @Bean
    public ChannelTopic topic() {
        return new ChannelTopic("stackfortech");
    }

    @Bean
    public MessagePublisher messagePublisher(RedisTemplate<String, Object> redisTemplate, ChannelTopic topic) {
        return new RedisMessagePublisher(redisTemplate, topic);
    }
}
