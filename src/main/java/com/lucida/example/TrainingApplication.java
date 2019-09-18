package com.lucida.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.lucida.example.property.FileStorageProperties;



@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class TrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingApplication.class, args);
	}

}
