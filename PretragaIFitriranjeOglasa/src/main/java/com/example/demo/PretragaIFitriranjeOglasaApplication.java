package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PretragaIFitriranjeOglasaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PretragaIFitriranjeOglasaApplication.class, args);
	}

}
