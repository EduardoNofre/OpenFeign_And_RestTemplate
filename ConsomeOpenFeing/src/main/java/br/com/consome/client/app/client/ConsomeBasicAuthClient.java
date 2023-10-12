package br.com.consome.client.app.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import feign.Headers;


@FeignClient(url = "${client.basic.auth.url}", name = "basic")
public interface ConsomeBasicAuthClient {


	@Headers("Content-Type: application/json")
	@GetMapping("{codigo}")
	public String basicAuthorizationOPenFeign(@RequestHeader("Authorization") String auth,@PathVariable Integer codigo);
}
