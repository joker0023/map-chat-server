package com.jokerstation.mapchat.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jokerstation.mapchat.job.HandleMessageJob;

@Component
public class MessageListHandle implements CommandLineRunner {
	
	@Autowired
	private HandleMessageJob handleMessageJob;

	@Override
	public void run(String... args) throws Exception {
		handleMessageJob.run();
	}
	
	
}
