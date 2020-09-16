package br.com.psg.produto.dao;

import java.util.List;

import br.com.psg.produto.modal.Produto;

public interface ProdutoDAO {
	Long saveProduto(Produto produto);

	void updateProduto(Produto produto);

	void deleteProduto(Long id);

	Produto findProdutoById(Long id);

	List<Produto> listaProduto();
}
