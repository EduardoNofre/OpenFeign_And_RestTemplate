package br.com.client.teste.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.client.teste.app.handle.ServiceException;
import br.com.client.teste.app.handle.ServiceNoContentExcetion;
import br.com.client.teste.app.service.TestesClientExcptionsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@RestController
@RequestMapping("/basic/authentication/")
@SecurityScheme(name = "bearerAuth", type = SecuritySchemeType.HTTP, scheme = "basic")
public class TestesClientExcptionsController {

	@Autowired
	private TestesClientExcptionsService testesClientExcptionsService;

	@Operation(summary = "BASIC AUTHENTICATION - GET", description = "http://localhost:8081/client/swagger-ui/index.html")
	@GetMapping("/{codigo}")
	public ResponseEntity<String> numeroExcptions(
			@Parameter(description = "Codigo excptions", required = true) @PathVariable Integer codigo)
			throws ServiceException, ServiceNoContentExcetion {

		return ResponseEntity.status(HttpStatus.OK).body(testesClientExcptionsService.retornaExcptions(codigo));

	}
}
