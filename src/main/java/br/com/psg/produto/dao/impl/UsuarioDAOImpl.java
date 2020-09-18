package br.com.psg.produto.dao.impl;

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
			Long id = (Long)session.save(usuario);
			transaction.commit();
			session.close();
			
			return id;	
		}
		
		public void deleteUsuario(Long id) {
			Session session = this.sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Usuario usuario = session.get(Usuario.class, id);
			session.delete(usuario);
			transaction.commit();
			session.close();
			
		}

		public Usuario findProdutoById(Long id) {
			Session session = this.sessionFactory.openSession();
			Usuario usuario = session.get(Usuario.class, id);
			session.close();
			
			return usuario;
		}

	public static UsuarioDAO getInstance() {
		if(usuarioDAOImpl == null)
			usuarioDAOImpl = new UsuarioDAOImpl();
		
		return usuarioDAOImpl;
	}
}
