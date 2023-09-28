package br.com.client.app.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.client.app.dto.CatDTO;

@FeignClient(url = "${gatos.client.comsume}", name = "cat")
public interface ClientFeing {

	@RequestMapping(method = RequestMethod.GET)
	List<CatDTO> buscarGatosApi(@RequestParam("limit") Integer qtd);
}
