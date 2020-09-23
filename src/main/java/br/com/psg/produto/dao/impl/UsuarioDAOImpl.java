package br.com.psg.produto.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.psg.produto.dao.UsuarioDAO;
import br.com.psg.produto.modal.Usuario;
import br.com.psg.produto.util.HibernateUtil;

public class UsuarioDAOImpl implements UsuarioDAO {

	private static UsuarioDAOImpl usuarioDAOImpl = null;

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public Long saveUsuario(Usuario usuario) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Long id = (Long) session.save(usuario);
		transaction.commit();
		session.close();

		return id;
	}

	public Usuario findUsuarioByUsuario(String usuario) {
		
		Usuario us; 
		
		try {

			Session session = this.sessionFactory.openSession();
			String hql = "from Usuario where userName= :usuario";
			Query query = session.createQuery(hql);
			query.setParameter("usuario", usuario);
			us = (Usuario) query.list().get(0);
			
			session.close();

			return us;

		} catch (Exception e) {
			
			System.out.println( e.getMessage());
			
		}
		
		return null;

	}    

	public static UsuarioDAO getInstance() {
		if (usuarioDAOImpl == null)
			usuarioDAOImpl = new UsuarioDAOImpl();

		return usuarioDAOImpl;
	}
}
