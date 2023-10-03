package br.com.client2.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(info = @Info(title = "Micro Service consome ", version = "1.0",description = " Client open feing "))
public class ComsumeClient2Application {

	public static void main(String[] args) {
		SpringApplication.run(ComsumeClient2Application.class, args);
	}

}
