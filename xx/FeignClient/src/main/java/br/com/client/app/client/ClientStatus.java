package br.com.client.app.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import feign.Headers;

@FeignClient(url = "${local.client.comsume.criar}", name = "criar" )
public interface ClientStatus {

	@Headers("Content-Type: application/json")
	@GetMapping()
	 String statusRetorno();
}
