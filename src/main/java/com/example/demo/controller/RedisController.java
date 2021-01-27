package com.example.demo.controller;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

	 @Resource
	 private RedisTemplate<String, Object> redisTemplate;
	
	@RequestMapping("setValue")
	public String value(@RequestParam("key")String key,@RequestParam("value")String value) {
		redisTemplate.opsForValue().set(key,value,5,TimeUnit.SECONDS);
		return value;
	}
}
