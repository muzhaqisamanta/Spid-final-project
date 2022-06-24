package com.example.spid;

import com.example.spid.entities.User;
import com.example.spid.service.SpidService;
import com.example.spid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.example.spid")
@Configuration
@EnableAutoConfiguration
public class SpidApplication implements CommandLineRunner {
//	@Autowired
//	public UserService userService;
//	@Autowired
//	public SpidService spidService;

	public static void main(String[] args){
		SpringApplication.run(SpidApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
