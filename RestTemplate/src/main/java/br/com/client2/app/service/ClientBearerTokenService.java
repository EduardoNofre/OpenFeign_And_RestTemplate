package br.com.client2.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import br.com.client2.app.client.ConsomeClientRestTemplate;
import br.com.client2.app.dto.DadosDTO;
import br.com.client2.app.handle.ServiceException;
import br.com.client2.app.handle.ServiceNoContentExcetion;

public class ClientBearerTokenService {

	@Autowired
	ConsomeClientRestTemplate consomeClientRestTemplate;

	@Value("${local.client.comsume}")
	private String url;

	@Value("${local.client.bearer}")
	private String urlToken;

	@Value("${local.client.senha}")
	private transient String senha;

	@Value("${local.client.usuario}")
	private transient String usuario;

	@Value("${local.client.bearerToken}")
	private transient String urlBearerToken;

	public String consomeClientBearerToken(DadosDTO dadosDTO) throws ServiceException, ServiceNoContentExcetion {

		return consomeClientRestTemplate.bearerTokenRestTemplate(urlToken, dadosDTO);
	}

	public String consomeClientBearerTokenAuthGet(int codigo, String token)
			throws ServiceException, ServiceNoContentExcetion {

		return consomeClientRestTemplate.bearerTokenAuthRestTemplate(urlBearerToken, codigo, token);
	}

	public String consomeClientBearerTokenAuthPost(int codigo, String token) throws ServiceNoContentExcetion {

		return consomeClientRestTemplate.bearerTokenAuthRestTemplate(urlBearerToken, codigo, token);
	}

	public String consomeClientBearerTokenAuthDelete(int codigo, String token) throws ServiceNoContentExcetion {

		return consomeClientRestTemplate.bearerTokenAuthRestTemplate(urlBearerToken, codigo, token);
	}

}
