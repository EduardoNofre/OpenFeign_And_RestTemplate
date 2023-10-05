package br.com.jwt.bearer.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jwt.bearer.app.handle.ServiceException;
import br.com.jwt.bearer.app.handle.ServiceNoContentExcetion;
import br.com.jwt.bearer.app.service.ExecptionsService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@RestController
@SecurityScheme(name = "bearerAuth", type = SecuritySchemeType.HTTP, bearerFormat = "JWT", scheme = "bearer")
public class ExecptionsController {

	@Autowired
	private ExecptionsService execptionsService;

	@DeleteMapping("{codigo}")
	public ResponseEntity<String> delete(
			@Parameter(description = " CODIGO EXCPTIONS - DELETE ", required = true) @PathVariable Long codigo)
			throws ServiceException, ServiceNoContentExcetion {
		return ResponseEntity.status(HttpStatus.OK).body(execptionsService.delete(codigo));
	}

	@GetMapping("{codigo}")
	public ResponseEntity<String> get(
			@Parameter(description = " CODIGO EXCPTIONS - GET ", required = true) @PathVariable Long codigo)
			throws ServiceException, ServiceNoContentExcetion {
		return ResponseEntity.status(HttpStatus.OK).body(execptionsService.get(codigo));
	}

	@PostMapping("{codigo}")
	public ResponseEntity<String> post(
			@Parameter(description = " CODIGO EXCPTIONS - POST ", required = true) @PathVariable Long codigo)
			throws ServiceException, ServiceNoContentExcetion {
		return ResponseEntity.status(HttpStatus.CREATED).body(execptionsService.post(codigo));
	}
}
