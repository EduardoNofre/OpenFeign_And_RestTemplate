package br.com.client2.app.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.client2.app.dto.DadosDTO;
import br.com.client2.app.handle.ServiceException;
import br.com.client2.app.handle.ServiceNoContentExcetion;
import br.com.client2.app.util.Util;
import lombok.Data;


@Data
@Component
public class ConsomeBearerTokenRestTemplate {
	
	/**
	 * 
	 * Rest Template com autorizaçao basic default do spring security
	 * 
	 * @param url
	 * @return
	 * @throws ServiceException
	 * @throws ServiceNoContentExcetion
	 */
	public String bearerTokenRestTemplate(String url, DadosDTO dadosDTO) throws ServiceNoContentExcetion {

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<?> auth = new HttpEntity<>(dadosDTO);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, auth,
				new ParameterizedTypeReference<String>() {
				});

		if (response.getStatusCode().value() == 204) {
			throw new ServiceNoContentExcetion();
		}

		return response.getBody();

	}
	
	
	
	/**
	 * 
	 * Rest Template com bearer token method : get
	 * 
	 * @param url
	 * @return
	 * @throws ServiceException
	 * @throws ServiceNoContentExcetion
	 */
	public String bearerTokenAuthRestTemplateGet(String url, Integer codigo, String token) throws ServiceNoContentExcetion {

		String urlFormat = String.format("%s/%s",url,codigo);
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<?> auth = new HttpEntity<>(Util.bearerToken(token));
		ResponseEntity<String> response = restTemplate.exchange(urlFormat, HttpMethod.GET, auth,
				new ParameterizedTypeReference<String>() {
				});

		if (response.getStatusCode().value() == 204) {
			throw new ServiceNoContentExcetion();
		}

		return response.getBody();
	}
	
	/**
	 * 
	 * Rest Template com bearer token method : DELETE
	 * 
	 * @param url
	 * @return
	 * @throws ServiceException
	 * @throws ServiceNoContentExcetion
	 */
	public String bearerTokenAuthRestTemplateDelete(String url, Integer codigo, String token) throws ServiceNoContentExcetion {

		String urlFormat = String.format("%s/%s",url,codigo);
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<?> auth = new HttpEntity<>(Util.bearerToken(token));
		ResponseEntity<String> response = restTemplate.exchange(urlFormat, HttpMethod.DELETE, auth,
				new ParameterizedTypeReference<String>() {
				});

		if (response.getStatusCode().value() == 204) {
			throw new ServiceNoContentExcetion();
		}

		return response.getBody();
	}
	
	/**
	 * 
	 * Rest Template com bearer token method : DELETE
	 * 
	 * @param url
	 * @return
	 * @throws ServiceException
	 * @throws ServiceNoContentExcetion
	 */
	public String bearerTokenAuthRestTemplatePost(String url, Integer codigo, String token) throws ServiceNoContentExcetion {

		String urlFormat = String.format("%s/%s",url,codigo);
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<?> auth = new HttpEntity<>(Util.bearerToken(token));
		ResponseEntity<String> response = restTemplate.exchange(urlFormat, HttpMethod.POST, auth,
				new ParameterizedTypeReference<String>() {
				});

		if (response.getStatusCode().value() == 204) {
			throw new ServiceNoContentExcetion();
		}

		return response.getBody();
	}

}
