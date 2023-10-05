package br.com.jwt.bearer.app.dto;

import lombok.Data;

@Data
public class LoginDTO {

	private String login;
	private String password;

}
