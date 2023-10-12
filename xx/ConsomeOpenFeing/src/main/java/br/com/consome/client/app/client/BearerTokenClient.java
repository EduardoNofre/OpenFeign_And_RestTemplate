package br.com.consome.client.app.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.consome.client.app.dto.DadosDTO;
import br.com.consome.client.app.handle.ServiceException;
import br.com.consome.client.app.handle.ServiceNoContentExcetion;
import feign.Headers;

@FeignClient(url = "${client.bearer.token}", name = "token")
public interface BearerTokenClient {

	/**
	 * 
	 * Rest Template com autorizaçao basic default do spring security
	 * 
	 * @param url
	 * @return
	 * @throws ServiceException
	 * @throws ServiceNoContentExcetion
	 */
	@Headers("Content-Type: application/json")
	@PostMapping()
	String bearerTokenOpenFeign(@RequestBody DadosDTO dadosDTO);

}
