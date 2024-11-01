package com.example.test;

import com.example.test.controller.CRUDController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = {CRUDController.class})
public class TestApplication  {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

}
