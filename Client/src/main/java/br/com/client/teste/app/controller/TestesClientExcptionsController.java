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

@RestController
@RequestMapping("/excptions/")
public class TestesClientExcptionsController {

	@Autowired
	private TestesClientExcptionsService testesClientExcptionsService;

	@Operation(summary = "buscar excptions", description = "BUSCAR CODIGO EXCPTIONS", tags = {
			" numero 0 = 409 ,numero 1 = 204 and numero > 1 = sucesso " })
	@GetMapping("/{codigo}")
	public ResponseEntity<String> numeroExcptions(
			@Parameter(description = "Codigo excptions", required = true) @PathVariable Integer codigo)
			throws ServiceException, ServiceNoContentExcetion {

		return ResponseEntity.status(HttpStatus.OK).body(testesClientExcptionsService.retornaExcptions(codigo));

	}

	@Operation(summary = "CREATED", description = "BUSCAR CODIGO EXCPTIONS", tags = {
			" numero 0 = 409 ,numero 1 = 204 and numero > 1 = sucesso " })
	@GetMapping("/criar")
	public ResponseEntity<String> save() throws ServiceException, ServiceNoContentExcetion {

		return ResponseEntity.status(HttpStatus.CREATED).body("teste");

	}
}
