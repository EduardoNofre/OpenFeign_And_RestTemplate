package br.com.client2.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.client2.app.client.ConsomeClientRestTemplate;
import br.com.client2.app.dto.DadosDTO;
import br.com.client2.app.handle.ServiceException;
import br.com.client2.app.handle.ServiceNoContentExcetion;
import lombok.Data;

@Service
@Data
public class ClientBasicAuthService {

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

	/**
	 * 
	 * O usario pode ser o usuario/senha logado ou usuario/senha sistema em um
	 * arquivo properties
	 * 
	 * @param codigo
	 * @return
	 * @throws ServiceException
	 * @throws ServiceNoContentExcetion
	 */
	public String consomeClientBasicAuth(Integer codigo) throws ServiceException, ServiceNoContentExcetion {

		String urlFormt = String.format("%s/%s", url, codigo);
		return consomeClientRestTemplate.basicAuthorizationRestTemplate(urlFormt, usuario, senha);
	}

	public String consomeClientBearerToken(DadosDTO dadosDTO) throws ServiceException, ServiceNoContentExcetion {

		return consomeClientRestTemplate.bearerTokenRestTemplate(urlToken, dadosDTO);
	}

	public String consomeClientBearerTokenAuthGet(int codigo, String token)
			throws ServiceException, ServiceNoContentExcetion {

		return consomeClientRestTemplate.bearerTokenAuthRestTemplate(urlBearerToken, codigo, token);
	}

	public String consomeClientBearerTokenAuthPost(int codigo, String token)
			throws ServiceNoContentExcetion {

		return consomeClientRestTemplate.bearerTokenAuthRestTemplate(urlBearerToken, codigo, token);
	}

	public String consomeClientBearerTokenAuthDelete(int codigo, String token)
			throws ServiceNoContentExcetion {

		return consomeClientRestTemplate.bearerTokenAuthRestTemplate(urlBearerToken, codigo, token);
	}
}
