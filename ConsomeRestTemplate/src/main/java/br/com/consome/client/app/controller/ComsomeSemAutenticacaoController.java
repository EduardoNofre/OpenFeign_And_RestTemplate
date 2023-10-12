package br.com.consome.client.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.consome.client.app.dto.CatDTO;
import br.com.consome.client.app.handle.ServiceNoContentExcetion;
import br.com.consome.client.app.service.ComsomeSemAutenticacaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping("/client/sem/autenticacao/")
@Api(tags = { "API Restful do recurso 'SEM AUTENTICACAO'" })
public class ComsomeSemAutenticacaoController {

	@Autowired
	private ComsomeSemAutenticacaoService comsomeSemAutenticacaoService;

	@ApiOperation(value = "CLIENT SEM AUTENTICAÇÃO", notes = " Exemplo de exemplo:/sem/autenticacao/{qdt}")
	@GetMapping("sem/autenticacao/{qdt}")
	public ResponseEntity<List<CatDTO>> numeroBasicAuth(@RequestParam Integer qdt) throws ServiceNoContentExcetion{
		
		return ResponseEntity.status(HttpStatus.OK).body(comsomeSemAutenticacaoService.semAutenticacao(qdt));
	}
}
