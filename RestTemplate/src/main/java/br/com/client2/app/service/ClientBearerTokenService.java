package br.com.client2.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.client2.app.client.ConsomeBearerTokenRestTemplate;
import br.com.client2.app.dto.DadosDTO;
import br.com.client2.app.handle.ServiceException;
import br.com.client2.app.handle.ServiceNoContentExcetion;

@Service
public class ClientBearerTokenService {

	@Autowired
	private ConsomeBearerTokenRestTemplate consomeBearerTokenRestTemplate;

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

		return consomeBearerTokenRestTemplate.bearerTokenRestTemplate(urlToken, dadosDTO);
	}

	public String consomeClientBearerTokenAuthGet(int codigo, String token)
			throws ServiceException, ServiceNoContentExcetion {

		return consomeBearerTokenRestTemplate.bearerTokenAuthRestTemplateGet(urlBearerToken, codigo, token);
	}

	public String consomeClientBearerTokenAuthPost(int codigo, String token) throws ServiceNoContentExcetion {

		return consomeBearerTokenRestTemplate.bearerTokenAuthRestTemplatePost(urlBearerToken, codigo, token);
	}

	public String consomeClientBearerTokenAuthDelete(int codigo, String token) throws ServiceNoContentExcetion {

		return consomeBearerTokenRestTemplate.bearerTokenAuthRestTemplateDelete(urlBearerToken, codigo, token);
	}

}
