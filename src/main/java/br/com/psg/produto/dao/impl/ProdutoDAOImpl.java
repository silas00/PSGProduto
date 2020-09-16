package br.com.psg.produto.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.psg.produto.dao.ProdutoDAO;
import br.com.psg.produto.modal.Produto;
import br.com.psg.produto.util.HibernateUtil;

public class ProdutoDAOImpl implements ProdutoDAO {

	private static ProdutoDAOImpl produtoDaoImpl = null;
	
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public Long saveProduto(Produto produto) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Long id = (Long)session.save(produto);
		transaction.commit();
		session.close();
		
		return id;		
	}

	public void updateProduto(Produto produto) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(produto);
		transaction.commit();
		session.close();
	}

	public void deleteProduto(Long id) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Produto produto = session.get(Produto.class, id);
		session.delete(produto);
		transaction.commit();
		session.close();
	}

	public Produto findProdutoById(Long id) {
		Session session = this.sessionFactory.openSession();
		Produto produto = session.get(Produto.class, id);
		session.close();
		
		return produto;
	}

	@SuppressWarnings("unchecked")
	public List<Produto> listaProduto() {
		Session session = this.sessionFactory.openSession();
		List<Produto> listProduto = session.createCriteria(Produto.class).list();
		session.close();
		
		return listProduto;
	}
	
	public static ProdutoDAO getInstance() {
		if(produtoDaoImpl == null)
			produtoDaoImpl = new ProdutoDAOImpl();
		
		return produtoDaoImpl;
	}
}
