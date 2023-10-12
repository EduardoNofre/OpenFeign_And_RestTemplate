package br.com.consome.client.app.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CatDTO {

	@ApiModelProperty(notes = "Numero de identificação", example = "123", required = false)
	private String id;
	@ApiModelProperty(notes = "Numero url da imagem", example = "www.url.com.br", required = false)
	private String url;
	@ApiModelProperty(notes = "Numero comprimento da imagem", example = "800", required = false)
	private String width;
	@ApiModelProperty(notes = "Numero altura da imagem", example = "400", required = false)
	private String height;
}
