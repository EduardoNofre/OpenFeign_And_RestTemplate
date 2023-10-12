package br.com.consome.client.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.consome.client.app.handle.ServiceException;
import br.com.consome.client.app.handle.ServiceNoContentExcetion;
import br.com.consome.client.app.service.ConsomeBasicAuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/client/com/auth/basic")
@Api(tags = { "API Restful do recurso 'EXEMPLO DE CLIENT COM AUTENTICAÇÃO BASIC AUTH '" })
public class ConsomeBasicAuthController {

	@Autowired
	private ConsomeBasicAuthService consomeBasicAuthService;


	@ApiOperation(value = "basic auth", notes = " Exemplo de exemplo:/basic/{codigo}")
	@GetMapping("basic/auth/{codigo}")
	public ResponseEntity<String> numeroBasicAuth(
			@ApiParam(value = "codigo", required = false) @RequestParam(name = "codigo", required = true) Integer codigo)
			throws ServiceException, ServiceNoContentExcetion {

		return ResponseEntity.status(HttpStatus.OK).body(consomeBasicAuthService.consomeClientBasicAuth(codigo));
	}
}
