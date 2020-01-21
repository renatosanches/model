package com.xpit.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.xpit.model.services.S3Service;

@SpringBootApplication
public class ModelApplication implements CommandLineRunner {
	
	@Autowired
	private S3Service s3Service;
		

	public static void main(String[] args) {
		SpringApplication.run(ModelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {	
		s3Service.uploadFile("C:\\temp\\xpit-logo.png");
	}

}
