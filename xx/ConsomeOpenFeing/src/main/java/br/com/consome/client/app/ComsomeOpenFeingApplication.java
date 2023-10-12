package br.com.consome.client.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ComsomeOpenFeingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComsomeOpenFeingApplication.class, args);
	}

}
