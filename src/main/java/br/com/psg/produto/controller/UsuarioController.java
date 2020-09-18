package br.com.psg.produto.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.psg.produto.dao.UsuarioDAO;
import br.com.psg.produto.dao.impl.UsuarioDAOImpl;
import br.com.psg.produto.modal.Usuario;

@WebServlet("/usuario/cadastro")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDAO usuarioDao = UsuarioDAOImpl.getInstance();

	public UsuarioController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("page/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");

		Usuario usuario = new Usuario(nome, senha);

		PrintWriter out = response.getWriter();

		try {
			
			if (nome != null || nome != "") {
				usuarioDao.saveUsuario(usuario);

				doGet(request, response);

			}
			
		} catch (Exception e) {

			out.println("Erro 004 UsuarioController: " + e.getMessage());
		}

	}

}
