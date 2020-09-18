package br.com.psg.produto.dao;

import br.com.psg.produto.modal.Usuario;

public interface UsuarioDAO {
		
		Long saveUsuario(Usuario usuario);

		void deleteUsuario(Long id);
		
		Usuario findProdutoById(Long id);

}
