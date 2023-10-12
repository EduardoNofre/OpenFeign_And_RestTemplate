package br.com.client.sem.autenticacao.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.client.sem.autenticacao.app.dto.CatDTO;
import br.com.client.sem.autenticacao.app.handle.ServiceException;
import br.com.client.sem.autenticacao.app.handle.ServiceNoContentExcetion;

@Service
public class ClientSemAuteticacaoService {

	public List<CatDTO> semAuteticacao(Integer qtd) throws ServiceException, ServiceNoContentExcetion {

		List<CatDTO> gatos = new ArrayList<>();

		if (qtd <= 1) {

			this.retornaExcptions(qtd);

		}

		for (int count = 0; count <= qtd; count++) {

			CatDTO cat = new CatDTO();

			cat.setHeight(String.valueOf(qtd * count));
			cat.setWidth(String.valueOf(((qtd * count)) * 2));
			cat.setId(count);
			cat.setUrl(String.format("%s%s", "url:teste/gatos/", count));
			gatos.add(cat);
		}

		return gatos;
	}

	public String retornaExcptions(int codigo) throws ServiceException, ServiceNoContentExcetion {

		if (codigo == 0) {
			throw new ServiceException("Erro regra de negocio");
		} else {
			throw new ServiceNoContentExcetion("vazio");
		}
	}

}
