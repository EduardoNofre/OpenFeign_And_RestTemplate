package br.com.consome.client.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.consome.client.app.client.ComsomeSemAutenticacaoClient;
import br.com.consome.client.app.dto.CatDTO;
import br.com.consome.client.app.handle.ServiceNoContentExcetion;


@Service
public class ComsomeSemAutenticacaoService {
	
	@Value("${local.client.comsume.sem.autenticacao}")
	private String url;
	
	@Autowired
	private ComsomeSemAutenticacaoClient comsomeSemAutenticacaoClient;
	
	public List<CatDTO> semAutenticacao(Integer qdt) throws ServiceNoContentExcetion {
		
		return comsomeSemAutenticacaoClient.semAutenticacaoRestTemplate(url, qdt);
	}
	
}
