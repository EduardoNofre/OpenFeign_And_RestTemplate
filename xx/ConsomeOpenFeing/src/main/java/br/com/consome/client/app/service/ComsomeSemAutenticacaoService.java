package br.com.consome.client.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.consome.client.app.client.ComsomeSemAutenticacaoClient;
import br.com.consome.client.app.dto.CatDTO;

@Service
public class ComsomeSemAutenticacaoService {

	@Autowired
	private ComsomeSemAutenticacaoClient comsomeSemAutenticacaoClient;

	public List<CatDTO> semAutenticacao(Integer qdt) {

		return comsomeSemAutenticacaoClient.semAutenticacao(qdt);

	}

}
