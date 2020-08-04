package com.jokerstation.mapchat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAsync
//@EnableTransactionManagement
@SpringBootApplication
@ComponentScan("com.jokerstation")
public class BootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}
}
