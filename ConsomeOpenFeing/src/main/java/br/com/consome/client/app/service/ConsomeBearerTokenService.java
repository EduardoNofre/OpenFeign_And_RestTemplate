package br.com.consome.client.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.consome.client.app.client.BearerTokenClient;
import br.com.consome.client.app.client.ConsomeBearerTokenClient;
import br.com.consome.client.app.dto.DadosDTO;

@Service
public class ConsomeBearerTokenService {

	@Autowired
	private BearerTokenClient bearerTokenClient;

	@Autowired
	private ConsomeBearerTokenClient consomeBearerTokenClient;

	public String consomeClientBearerToken(DadosDTO dadosDTO) {
		return bearerTokenClient.bearerTokenOpenFeign(dadosDTO);
	}

	public String consomeClientBearerTokenAuthGet(int codigo, String bearerToken) {
		return consomeBearerTokenClient.bearerTokenAuthOpenFeignGet(bearerToken, codigo);
	}

	public String consomeClientBearerTokenAuthPost(int codigo, String bearerToken) {
		return consomeBearerTokenClient.bearerTokenAuthOpenFeignPost(bearerToken, codigo);
	}

	public String consomeClientBearerTokenAuthDelete(int codigo, String bearerToken) {
		return consomeBearerTokenClient.bearerTokenAuthOpenFeignDelete(bearerToken, codigo);
	}

}
