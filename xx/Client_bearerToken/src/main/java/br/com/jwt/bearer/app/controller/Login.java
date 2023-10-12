package br.com.jwt.bearer.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.jwt.bearer.app.dto.LoginDTO;
import br.com.jwt.bearer.app.service.UsuarioService;

@RestController
public class Login {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("/token")
	public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {

		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.login(loginDTO));
	}
}
