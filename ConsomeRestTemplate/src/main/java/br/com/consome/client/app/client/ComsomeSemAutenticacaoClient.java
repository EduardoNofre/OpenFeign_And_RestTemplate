package br.com.consome.client.app.client;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.consome.client.app.dto.CatDTO;
import br.com.consome.client.app.handle.ServiceNoContentExcetion;
import lombok.Data;

@Data
@Component
public class ComsomeSemAutenticacaoClient {

	public List<CatDTO> semAutenticacaoRestTemplate(String url, Integer qdt) throws ServiceNoContentExcetion {

		String formUrl = String.format("%s/%s",url, qdt);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<CatDTO>> response = restTemplate.exchange(formUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<CatDTO>>() {
				});

		if (response.getStatusCode().value() == 204) {
			throw new ServiceNoContentExcetion();
		}

		return response.getBody();

	}
}
