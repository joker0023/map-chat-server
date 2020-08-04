package com.jokerstation.mapchat.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jokerstation.common.util.JsonUtils;
import com.jokerstation.mapchat.queue.MessageQueue;
import com.jokerstation.mapchat.vo.MapMessage;

@RestController
public class CommonCtrl {
	
	private static Logger logger = LoggerFactory.getLogger(CommonCtrl.class);
	
//	@Autowired
//	private RedisTemplate<String, Object> redisTemplate;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private MessageQueue messageQueue;
	
	@Resource
	private ThreadPoolTaskExecutor onMessagePool;
	
	@RequestMapping("/test")
	public String test() {
		logger.info("test in ...");
//		logger.debug("debug log test");
//		logger.info("info log test");
//		logger.warn("warn log test");
//		logger.error("error log test");
		
		String key = "map-chat-server";
		MapMessage msg = new MapMessage();
		msg.setSid("1122");
		msg.setMessage("hello");
		msg.setLatitude(11.1);
//		redisTemplate.opsForList().rightPush(key, msg);
		stringRedisTemplate.opsForList().rightPush(key, JsonUtils.toJson(msg));
		
		return "success";
	}
	
	@RequestMapping("/test2")
	public String test2() {
		String key = "map-chat-server";
		String json = stringRedisTemplate.opsForList().leftPop(key);
		if (null != json) {
			System.out.println(json);
		}
		return "success";
	}
}
