package br.com.jwt.bearer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Micro Service consome ", version = "1.0",description = " Client open feing "))
public class ClientBearerTokenApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientBearerTokenApplication.class, args);
	}

}
