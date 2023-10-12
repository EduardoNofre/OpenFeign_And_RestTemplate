package br.com.consome.client.app.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

import br.com.consome.client.app.dto.CatDTO;
import feign.Headers;

@FeignClient(url = "${local.client.comsume.sem.autenticacao}", name = "local")
public interface ComsomeSemAutenticacaoClient {

	@Headers("Content-Type: application/json")
	@GetMapping("/{qdt}")
	List<CatDTO> semAutenticacao(@RequestParam("qdt") Integer qdt);
}
