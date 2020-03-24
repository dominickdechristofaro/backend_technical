package com.backbase.backendtechnicaltest;

import com.backbase.backendtechnicaltest.mapper.TransactionMapperImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BackendTechnicalTestApplication {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public TransactionMapperImpl transactionMapperImpl() { return new TransactionMapperImpl(); }

	public static void main(String[] args) {
		SpringApplication.run(BackendTechnicalTestApplication.class, args);
	}

}
