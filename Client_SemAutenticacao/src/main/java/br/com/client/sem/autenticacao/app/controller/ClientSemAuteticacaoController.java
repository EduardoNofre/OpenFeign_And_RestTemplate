package br.com.client.sem.autenticacao.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.client.sem.autenticacao.app.dto.CatDTO;
import br.com.client.sem.autenticacao.app.handle.ServiceException;
import br.com.client.sem.autenticacao.app.handle.ServiceNoContentExcetion;
import br.com.client.sem.autenticacao.app.service.ClientSemAuteticacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/client/sem/autenticacao/")
@Tag(name=" CLIENT SEM AUTENTICAÇÃO ",description = " EXEMPLO DE CLIENT SEM AUTENTICAÇÃO ")
public class ClientSemAuteticacaoController {

	@Autowired
	private ClientSemAuteticacaoService clientSemAuteticacaoService;

	@Operation(summary = "BASIC AUTHENTICATION - GET", description = "http://localhost:8081/client/swagger-ui/index.html")
	@GetMapping("gatos/{qtd}")
	public ResponseEntity<List<CatDTO>> numeroExcptions(
			@Parameter(description = "Codigo excptions", required = true) @PathVariable Integer qtd)
			throws ServiceException, ServiceNoContentExcetion {

		return ResponseEntity.status(HttpStatus.OK).body(clientSemAuteticacaoService.semAuteticacao(qtd));

	}
}
