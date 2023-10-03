package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.client.ClientOpenFeign;
import com.example.demo.exception.ViaCepException;
import com.example.demo.model.CepModel;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ServiceOpenFeign {

	@Autowired
	private ClientOpenFeign clientOpenFeign;

	public Optional<CepModel> consultaCep(String cep) {

		Optional<CepModel> cepModelOptinal = Optional.ofNullable(clientOpenFeign.buscaCepClient(cep));

		if (cepModelOptinal.map(CepModel :: getCep).isPresent()) {

			return cepModelOptinal;
		}
		log.warn("Não a registro para o cep informado :{} retorno do via Cep :{}",cep, cepModelOptinal.isPresent());
		throw new ViaCepException("Verifica o cep passado como parametro.");
	}
}
