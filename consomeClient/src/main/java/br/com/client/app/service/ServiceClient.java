package br.com.client.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.client.app.client.ClientFeing;
import br.com.client.app.client.ClientFeingLocal;
import br.com.client.app.client.ClientStatus;
import br.com.client.app.dto.CatDTO;
import lombok.Data;

@Service
@Data
public class ServiceClient {

	@Autowired
	private final ClientFeing clientFeing;

	@Autowired
	private final ClientFeingLocal clientFeingLocal;

	@Autowired
	private final ClientStatus clientStatus;

	public List<CatDTO> buscarGatos(Integer qtd) {

		List<CatDTO> gatos = clientFeing.buscarGatosApi(qtd);

		return gatos;
	}

	public String buscarExcptionsNumero(Integer qtd) {

		return clientFeingLocal.buscarExcptionslocal(qtd);

	}

	public String status() {

		return clientStatus.statusRetorno();

	}
}
