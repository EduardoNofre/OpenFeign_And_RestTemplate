package br.com.consome.client.app.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import br.com.consome.client.app.handle.ServiceException;
import br.com.consome.client.app.handle.ServiceNoContentExcetion;
import feign.Headers;

@FeignClient(url = "${client.bearer.token.comsume}", name = "bearerToken")
public interface ConsomeBearerTokenClient {

	/**
	 * 
	 * Rest Template com bearer token method : get
	 * 
	 * @param url
	 * @return
	 * @throws ServiceException
	 * @throws ServiceNoContentExcetion
	 */
	@Headers("Content-Type: application/json")
	@GetMapping("{codigo}/{token}")
	public String bearerTokenAuthOpenFeignGet(@RequestHeader("Authorization") String bearerToken,@PathVariable Integer codigo);

	/**
	 * 
	 * Rest Template com bearer token method : DELETE
	 * 
	 * @param url
	 * @return
	 * @throws ServiceException
	 * @throws ServiceNoContentExcetion
	 */
	@Headers("Content-Type: application/json")
	@DeleteMapping("{codigo}/{token}")
	public String bearerTokenAuthOpenFeignDelete(@RequestHeader("Authorization") String bearerToken,@PathVariable Integer codigo);

	/**
	 * 
	 * Rest Template com bearer token method : DELETE
	 * 
	 * @param url
	 * @return
	 * @throws ServiceException
	 * @throws ServiceNoContentExcetion
	 */
	@Headers("Content-Type: application/json")
	@PostMapping("{codigo}/{token}")
	public String bearerTokenAuthOpenFeignPost(@RequestHeader("Authorization") String bearerToken,@PathVariable Integer codigo);
}
