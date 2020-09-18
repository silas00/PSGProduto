package br.com.psg.produto.dao;

import br.com.psg.produto.modal.Usuario;

public interface UsuarioDAO {
		
		Long saveUsuario(Usuario usuario);

		Usuario findUsuarioByUsuario(String usuario);

}
