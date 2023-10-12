package br.com.consome.client.app.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DadosDTO {

	@ApiModelProperty(notes = "Login", example = "usuario", required = false)
	private String login;
	@ApiModelProperty(notes = "Senha", example = "123senha", required = false)
	private String password;
}
