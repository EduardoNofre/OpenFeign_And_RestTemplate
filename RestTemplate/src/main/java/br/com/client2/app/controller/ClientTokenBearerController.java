package br.com.client2.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.client2.app.dto.DadosDTO;
import br.com.client2.app.handle.ServiceException;
import br.com.client2.app.handle.ServiceNoContentExcetion;
import br.com.client2.app.service.ClientBearerTokenService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/client/token/bearer/")
public class ClientTokenBearerController {
	
	@Autowired
	private ClientBearerTokenService clientBearerTokenService;

	@Operation(summary = " RECUPERA TOKEN ", description = " RETORNA UM BEARER TOKEN PARA AUTORIZAÇÃO")
	@PostMapping()
	public ResponseEntity<String> token(@RequestBody DadosDTO dadosDTO)
			throws ServiceException, ServiceNoContentExcetion {

		return ResponseEntity.status(HttpStatus.OK).body(clientBearerTokenService.consomeClientBearerToken(dadosDTO));
	}

	@Operation(summary = " REST TEMPLATE BEARER TOKEN AUTH GET ", description = " BEARER TOKEN AUTH ", tags = {
			" NUMERO 0 = 409 ,NUMERO 1 = 204 AND NUMERO > 1 = SUCESSO " })
	@GetMapping("/get/{codigo}/{token}")
	public ResponseEntity<String> bearerTokenAuthGet(
			@PathVariable(required = false) Integer codigo,
			@PathVariable(required = false) String token)
			throws ServiceException, ServiceNoContentExcetion {

		return ResponseEntity.status(HttpStatus.OK).body(clientBearerTokenService.consomeClientBearerTokenAuthGet(codigo, token));
	}

	@Operation(summary = " REST TEMPLATE BEARER TOKEN AUTH POST ", description = " BEARER TOKEN AUTH ", tags = {
			" NUMERO 0 = 409 ,NUMERO 1 = 204 AND NUMERO > 1 = SUCESSO " })
	@PostMapping("/post/{codigo}/{token}")
	public ResponseEntity<String> bearerTokenAuthPost(
			@PathVariable(required = false) Integer codigo,
			@PathVariable(required = false) String token)
			throws ServiceNoContentExcetion {

		return ResponseEntity.status(HttpStatus.OK).body(clientBearerTokenService.consomeClientBearerTokenAuthPost(codigo, token));
	}

	@Operation(summary = " REST TEMPLATE BEARER TOKEN AUTH DELETE ", description = " BEARER TOKEN AUTH ", tags = {
			" NUMERO 0 = 409 ,NUMERO 1 = 204 AND NUMERO > 1 = SUCESSO " })
	@DeleteMapping("/delete/{codigo}/{token}")
	public ResponseEntity<String> bearerTokenAuthDelete(
			@PathVariable(required = false) Integer codigo,
			@PathVariable(required = false) String token)
			throws  ServiceNoContentExcetion {

		return ResponseEntity.status(HttpStatus.OK).body(clientBearerTokenService.consomeClientBearerTokenAuthDelete(codigo, token));
	}
}
