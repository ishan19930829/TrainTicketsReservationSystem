package com.uoc.trainsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.uoc.trainsystem","com.uoc.trainsystem.docs","com.uoc.trainsystem.config","com.uoc.trainsystem.core.service"})
@EnableJpaRepositories(basePackages = {"com.uoc.trainsystem.repository"})
@EntityScan(basePackages = {"com.uoc.trainsystem.repository.entities","com.uoc.trainsystem.repository.wrapper"})
public class TrainSystemMain {
	
	public static void main(String[] args) {
		SpringApplication.run(TrainSystemMain.class, args);
	}
	
}
