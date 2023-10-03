package br.com.client2.app.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.client2.app.handle.ServiceException;
import br.com.client2.app.handle.ServiceNoContentExcetion;
import br.com.client2.app.util.Util;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Component
public class ConsomeClientRestTemplate {

	public String simplesRestTemplate(String url) throws ServiceException, ServiceNoContentExcetion {

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

		if (response.getStatusCode().value() == 204) {
			throw new ServiceNoContentExcetion();
		}
		return response.getBody();

	}

	/**
	 * 
	 * Rest Template com autorizaçao
	 * 
	 * @param url
	 * @return
	 * @throws ServiceException
	 * @throws ServiceNoContentExcetion
	 */
	public String authorizationRestTemplate(String url, String usuario, String senha)
			throws ServiceException, ServiceNoContentExcetion {

		String urlFormat = String.format(url);

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<?> auth = new HttpEntity<>(Util.getAuthorization(usuario, senha));
		ResponseEntity<String> response = restTemplate.exchange(urlFormat, HttpMethod.GET, auth,
				new ParameterizedTypeReference<String>() {
				});

		if (response.getStatusCode().value() == 204) {
			throw new ServiceNoContentExcetion();
		}

		return response.getBody();

	}

}
