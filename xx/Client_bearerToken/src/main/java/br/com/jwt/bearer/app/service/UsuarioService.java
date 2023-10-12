package br.com.jwt.bearer.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.jwt.bearer.app.config.TokenConfig;
import br.com.jwt.bearer.app.dto.LoginDTO;
import br.com.jwt.bearer.app.dto.UsuarioDTO;
import br.com.jwt.bearer.app.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private TokenConfig tokenConfig;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	public String login(LoginDTO loginDTO) {
		
		UsernamePasswordAuthenticationToken userPassAuthentication = new UsernamePasswordAuthenticationToken(
				loginDTO.getLogin(), loginDTO.getPassword());
		
		Authentication authenticate = this.authenticationManager.authenticate(userPassAuthentication);
		
		var usuario = (UsuarioDTO) authenticate.getPrincipal();

		usuarioRepository.findByLogin();
		
		return tokenConfig.gerarToken(usuario);

	}
}
