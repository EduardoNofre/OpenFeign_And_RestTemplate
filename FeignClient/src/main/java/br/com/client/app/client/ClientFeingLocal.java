package br.com.client.app.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import feign.Headers;

@FeignClient(url = "${local.client.comsume}", name = "local" )
public interface ClientFeingLocal {

	@Headers("Content-Type: application/json")
	@GetMapping("/{numero}")
	 String buscarExcptionslocal(@PathVariable Integer numero);
}
