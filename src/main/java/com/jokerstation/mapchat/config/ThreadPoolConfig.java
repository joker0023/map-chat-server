package com.jokerstation.mapchat.config;

import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ThreadPoolConfig {

	@Bean
	public ThreadPoolTaskExecutor onMessagePool() {
		ThreadPoolTaskExecutor scheduler = new ThreadPoolTaskExecutor();
		scheduler.setCorePoolSize(100);
		scheduler.setMaxPoolSize(200);
		scheduler.setQueueCapacity(1000);
		scheduler.setKeepAliveSeconds(3600);
		scheduler.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		return scheduler;
	}
}
