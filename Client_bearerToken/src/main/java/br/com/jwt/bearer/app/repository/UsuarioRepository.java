package br.com.jwt.bearer.app.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import br.com.jwt.bearer.app.dto.UsuarioDTO;

@Repository
public class UsuarioRepository {

	@Value("${local.client.id}")
	private transient String id;

	@Value("${local.client.usuario}")
	private transient String user;

	@Value("${local.client.senha}")
	private transient String senha;

	public UsuarioDTO findByLogin() {

		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setId(Long.getLong(id));
		usuario.setLogin(user);
		usuario.setPassword(senha);
		
		return usuario;
	}
}
