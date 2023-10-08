package br.com.client2.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(info = @Info(title = "CLIENT CONSUMO DE SERVIÇOS ", version = "1.0",description = " MODELO REST TEMPLATE "))
public class ComsumeClient2Application {

	public static void main(String[] args) {
		SpringApplication.run(ComsumeClient2Application.class, args);
	}

}
