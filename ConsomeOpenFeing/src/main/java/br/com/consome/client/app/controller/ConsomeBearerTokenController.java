package br.com.consome.client.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.consome.client.app.dto.DadosDTO;
import br.com.consome.client.app.handle.ServiceNoContentExcetion;
import br.com.consome.client.app.service.ConsomeBearerTokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/client/bearer/token/")
@Api(tags = { "API Restful do recurso 'EXEMPLO DE CLIENT COM AUTENTICAÇÃO BEARER TOKEN '" })
public class ConsomeBearerTokenController {

	@Autowired
	private ConsomeBearerTokenService consomeBearerTokenService;

	@ApiOperation(value = " RECUPERA TOKEN  ", notes = " RETORNA UM BEARER TOKEN PARA AUTORIZAÇÃO")
	@PostMapping()
	public ResponseEntity<String> token(@RequestBody DadosDTO dadosDTO) {

		return ResponseEntity.status(HttpStatus.OK).body(consomeBearerTokenService.consomeClientBearerToken(dadosDTO));
	}

	@ApiOperation(value = " REST TEMPLATE BEARER TOKEN AUTH GET ", notes = " BEARER TOKEN AUTH ")
	@GetMapping("/get/{codigo}/{token}")
	public ResponseEntity<String> bearerTokenAuthGet(
			@ApiParam(value = "codigo", required = false) @RequestParam(name = "codigo", required = true) Integer codigo,
			@ApiParam(value = "token", required = false) @RequestParam(name = "token", required = true) String token) {

		return ResponseEntity.status(HttpStatus.OK)
				.body(consomeBearerTokenService.consomeClientBearerTokenAuthGet(codigo, token));
	}

	@ApiOperation(value = " REST TEMPLATE BEARER TOKEN AUTH POST ", notes = " BEARER TOKEN AUTH ")
	@PostMapping("/post/{codigo}/{token}")
	public ResponseEntity<String> bearerTokenAuthPost(
			@ApiParam(value = "codigo", required = false) @RequestParam(name = "codigo", required = true) Integer codigo,
			@ApiParam(value = "token", required = false) @RequestParam(name = "token", required = true) String token)
			throws ServiceNoContentExcetion {

		return ResponseEntity.status(HttpStatus.OK)
				.body(consomeBearerTokenService.consomeClientBearerTokenAuthPost(codigo, token));
	}

	@ApiOperation(value = " REST TEMPLATE BEARER TOKEN AUTH DELETE ", notes = " BEARER TOKEN AUTH ")
	@DeleteMapping("/delete/{codigo}/{token}")
	public ResponseEntity<String> bearerTokenAuthDelete(
			@ApiParam(value = "codigo", required = false) @RequestParam(name = "codigo", required = true) Integer codigo,
			@ApiParam(value = "token", required = false) @RequestParam(name = "token", required = true) String token)
			throws ServiceNoContentExcetion {

		return ResponseEntity.status(HttpStatus.OK)
				.body(consomeBearerTokenService.consomeClientBearerTokenAuthDelete(codigo, token));
	}
}
