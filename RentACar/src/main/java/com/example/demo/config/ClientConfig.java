package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.example.demo.client.AdministratorClient;
import com.example.demo.client.OcenjivanjeIKomentariClient;
import com.example.demo.client.RazmenaPorukaClient;

public class ClientConfig {
	
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
	    // pom.xml
		marshaller.setContextPath("com.example.consumingwebservice");
	    return marshaller;
	}
	
	@Bean
	public RazmenaPorukaClient razmenaPorukaClient(Jaxb2Marshaller marshaller) {
		RazmenaPorukaClient client = new RazmenaPorukaClient();
		client.setDefaultUri("http://localhost:8089/ws");
	    client.setMarshaller(marshaller);
	    client.setUnmarshaller(marshaller);
	    return client;
	}
	
	@Bean
	public OcenjivanjeIKomentariClient ocenjivanjeIKomentariClient(Jaxb2Marshaller marshaller) {
		OcenjivanjeIKomentariClient client = new OcenjivanjeIKomentariClient();
		client.setDefaultUri("http://localhost:8085/ws");
	    client.setMarshaller(marshaller);
	    client.setUnmarshaller(marshaller);
	    return client;
	}
	
	@Bean
	public AdministratorClient administratorClient(Jaxb2Marshaller marshaller) {
		AdministratorClient client = new AdministratorClient();
		client.setDefaultUri("http://localhost:8087/ws");
	    client.setMarshaller(marshaller);
	    client.setUnmarshaller(marshaller);
	    return client;
	}
}
