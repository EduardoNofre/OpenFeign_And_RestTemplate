package br.com.jwt.bearer.app.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.jwt.bearer.app.handle.ServiceException;
import br.com.jwt.bearer.app.handle.ServiceNoContentExcetion;

@Service
public class ExecptionsService {

	@DeleteMapping()
	public String delete(Long codigo) throws ServiceException, ServiceNoContentExcetion {
		return " DELETE " + String.valueOf(codigo) + " - " + retornaExcptions(codigo);
	}

	@GetMapping()
	public String get(Long codigo) throws ServiceException, ServiceNoContentExcetion {
		return " GET " + String.valueOf(codigo) + " - " + retornaExcptions(codigo);
	}

	@PostMapping()
	public String post(Long codigo) throws ServiceException, ServiceNoContentExcetion {
		return " POST " + String.valueOf(codigo) + " - " + retornaExcptions(codigo);
	}

	private String retornaExcptions(Long codigo) throws ServiceException, ServiceNoContentExcetion {

		if (codigo == 0L) {
			throw new ServiceException("ERRO REGRA DE NEGOCIO");
		} else if (codigo == 1L) {
			throw new ServiceNoContentExcetion("VAZIO");
		} else {
			return "SUCESSO";
		}
	}
}
