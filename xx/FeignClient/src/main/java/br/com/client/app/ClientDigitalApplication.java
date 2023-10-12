package br.com.client.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(info = @Info(title = "Micro Service client Gatos ", version = "1.0",description = " Client open feing "))
public class ClientDigitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientDigitalApplication.class, args);
	}

}
