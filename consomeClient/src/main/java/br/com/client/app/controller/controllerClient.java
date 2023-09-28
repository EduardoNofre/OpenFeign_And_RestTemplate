package br.com.client.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.client.app.dto.CatDTO;
import br.com.client.app.service.ServiceClient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/gatos/")
public class controllerClient {

	@Autowired
	private ServiceClient serviceClient;

	@Operation(summary = "BUSCAR", description = "BUSCAR GATOS PASSANDO COMO PARAMETRO A QUANTIDADE DESEJADA ", tags = {
			"quantidade de gatos por qtd" })
	@GetMapping("/{qtd}")
	public ResponseEntity<List<CatDTO>> qtdBuscar(
			@Parameter(description = "Quantidade de gatos", required = true) @PathVariable Integer qtd) {
		return ResponseEntity.status(HttpStatus.OK).body(serviceClient.buscarGatos(qtd));
	}

	@Operation(summary = "BUSCAR", description = "BUSCAR A EXCPTIONS DESEJADA ", tags = {
			"numero 0 = 409 ,numero 1 = 204 and numero > 1 = sucesso " })
	@GetMapping("excptions/{numero}")
	public ResponseEntity<String> buscarExcptions(
			@Parameter(description = "Excptions desejada", required = true) @PathVariable Integer numero) {

		return ResponseEntity.status(HttpStatus.OK).body(serviceClient.buscarExcptionsNumero(numero));
	}

	@Operation(summary = "STATUS", description = "retorna somente status ", tags = {"status 201"})
	@GetMapping("/status")
	public ResponseEntity<String> status() {

		return ResponseEntity.status(HttpStatus.CREATED).body(serviceClient.status());
	}
}
