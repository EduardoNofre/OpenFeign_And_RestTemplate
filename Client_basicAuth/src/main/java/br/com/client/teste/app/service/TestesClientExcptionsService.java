package br.com.client.teste.app.service;

import org.springframework.stereotype.Service;

import br.com.client.teste.app.handle.ServiceException;
import br.com.client.teste.app.handle.ServiceNoContentExcetion;

@Service
public class TestesClientExcptionsService {

	public String retornaExcptions(Integer codigo) throws ServiceException, ServiceNoContentExcetion {

		if (codigo == 0) {
			throw new ServiceException("Erro regra de negocio");
		} else if (codigo == 1) {
			throw new ServiceNoContentExcetion("vazio");
		} else {
			return "sucesso";
		}
	}
}
