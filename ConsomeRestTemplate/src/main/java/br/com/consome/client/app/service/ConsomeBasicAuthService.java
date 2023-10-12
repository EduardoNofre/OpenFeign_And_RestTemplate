package br.com.consome.client.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.consome.client.app.client.ConsomeBasicAuthClient;
import br.com.consome.client.app.handle.ServiceException;
import br.com.consome.client.app.handle.ServiceNoContentExcetion;

@Service
public class ConsomeBasicAuthService {
	
	@Value("${client.basic.auth.url}")
	private String url;
	
	@Value("${client.basic.auth.usuario}")
	private String usuario;
	
	@Value("${client.basic.auth.senha}")
	private String senha;

	@Autowired
	private ConsomeBasicAuthClient consomeBasicAuthClient;
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
		return consomeBasicAuthClient.basicAuthorizationRestTemplate(urlFormt, usuario, senha);
	}
}
