package com.example.demo.scheduled;

import java.time.LocalDateTime;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.demo.main.HttpTest;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class SaticScheduleTask {
	
	@Resource
	private RedisTemplate<String, Object> redisTemplate;
    
    @Scheduled(fixedDelay =1*1000*60*60)
    //或直接指定时间间隔，例如：每小时
    private void HD() throws Exception {
    	for (int i = 0; i < 1000; i++) {
    		try {
        		HttpTest.get_HD_Http();
        		
    		} catch (Exception e) {
    			if (redisTemplate.opsForValue().get("error_hd")==null) {
    				redisTemplate.opsForValue().set("error_hd", 1);
    			}else {
    				 redisTemplate.opsForValue().increment("error_hd",1);
    			}
    		}
		}
    }
    
    @Scheduled(fixedDelay =1*1000*60*60)
    //或直接指定时间间隔，例如：每小时
    private void HN() throws Exception {
    	for (int i = 0; i < 1000; i++) {
    		try {
    			HttpTest.get_HN_Http();
    		} catch (Exception e) {
    			if (redisTemplate.opsForValue().get("error_hn")==null) {
    				redisTemplate.opsForValue().set("error_hn", 1);
    			}else {
    				redisTemplate.opsForValue().increment("error_hn",1);
    			}
    		}
    	}
    }
}