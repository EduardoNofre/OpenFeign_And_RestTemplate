package br.com.client2.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.client2.app.handle.ServiceException;
import br.com.client2.app.handle.ServiceNoContentExcetion;
import br.com.client2.app.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/client/")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@Operation(summary = "REST TEMPLATE BASIC AUTH", description = "BUSCAR CODIGO EXCPTIONS COM BASIC AUTORIZAÇÃO", tags = {
			" numero 0 = 409 ,numero 1 = 204 and numero > 1 = sucesso " })
	@GetMapping("basic/{codigo}")
	public ResponseEntity<String> numeroBasicAuth(
			@Parameter(description = "Codigo excptions", required = true) @PathVariable Integer codigo)
			throws ServiceException, ServiceNoContentExcetion {

		return ResponseEntity.status(HttpStatus.OK).body(clientService.consomeClientBasicAuth(codigo));
	}
}
