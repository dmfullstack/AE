package com.stackroute.assessmentengine.evaluationmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;

//@Configuration

public class RedisConfig {
	//@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(5);
		poolConfig.setTestOnBorrow(true);
		poolConfig.setTestOnReturn(true);
		
		JedisConnectionFactory connectionFactory = new JedisConnectionFactory(poolConfig);
		connectionFactory.setUsePool(true);
		connectionFactory.setHostName("localhost");
		connectionFactory.setPort(6379);
		
		return connectionFactory;
	}
	//@Bean
	public RedisTemplate<String,String> redisTemplate() {
		RedisTemplate<String,String> redisTemplate = new RedisTemplate();
		redisTemplate.setDefaultSerializer(new StringRedisSerializer());
		redisTemplate.setConnectionFactory(redisConnectionFactory());
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setEnableTransactionSupport(true);
		return redisTemplate;
	}
	//@Bean
	public StringRedisTemplate stringRedisTemplate() {
		StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(redisConnectionFactory());
		stringRedisTemplate.setEnableTransactionSupport(true);
		return stringRedisTemplate;
	}	
}