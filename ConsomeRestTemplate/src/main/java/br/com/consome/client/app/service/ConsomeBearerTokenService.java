package br.com.consome.client.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.consome.client.app.client.ConsomeBearerTokenClient;
import br.com.consome.client.app.dto.DadosDTO;
import br.com.consome.client.app.handle.ServiceException;
import br.com.consome.client.app.handle.ServiceNoContentExcetion;

@Service
public class ConsomeBearerTokenService {

	@Autowired
	private ConsomeBearerTokenClient consomeBearerTokenClient;

	@Value("${client.bearer.token}")
	private String urlToken;
	
	@Value("${client.bearer.token.comsume}")
	private String urlBearerToken;


	public String consomeClientBearerToken(DadosDTO dadosDTO) throws ServiceException, ServiceNoContentExcetion {

		return consomeBearerTokenClient.bearerTokenRestTemplate(urlToken, dadosDTO);
	}

	public String consomeClientBearerTokenAuthGet(int codigo, String token)
			throws ServiceException, ServiceNoContentExcetion {

		return consomeBearerTokenClient.bearerTokenAuthRestTemplateGet(urlBearerToken, codigo, token);
	}

	public String consomeClientBearerTokenAuthPost(int codigo, String token) throws ServiceNoContentExcetion {

		return consomeBearerTokenClient.bearerTokenAuthRestTemplatePost(urlBearerToken, codigo, token);
	}

	public String consomeClientBearerTokenAuthDelete(int codigo, String token) throws ServiceNoContentExcetion {

		return consomeBearerTokenClient.bearerTokenAuthRestTemplateDelete(urlBearerToken, codigo, token);
	}

}
