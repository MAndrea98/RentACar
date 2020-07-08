package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.consumingwebservice.MessageRP;
import com.example.consumingwebservice.SendMessageResponse;
import com.example.consumingwebservice.UserModelRP;
import com.example.demo.client.RazmenaPorukaClient;

@SpringBootApplication
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}

	/*@Bean
	CommandLineRunner test(RazmenaPorukaClient razmenaPorukaClient) {
		return args -> {
			MessageRP m = new MessageRP();
			m.setContent("Nova Poruka");
			UserModelRP reciever = new UserModelRP();
			UserModelRP sender = new UserModelRP();
			reciever.setUsername("maki");
			sender.setUsername("pera");
			m.setReciever(reciever);
			m.setSubject("proba");
			SendMessageResponse response = razmenaPorukaClient.sendMessage(m);
			System.err.println(response.getResponse());
		};
	}*/
}
