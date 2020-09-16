package br.com.psg.produto.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.psg.produto.dao.ProdutoDAO;
import br.com.psg.produto.dao.impl.ProdutoDAOImpl;
import br.com.psg.produto.modal.Produto;

@WebServlet("/")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProdutoDAO dao = ProdutoDAOImpl.getInstance();
	
	public HomeController() {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Produto> produtos = dao.listaProduto();

		request.setAttribute("listProduto", produtos);

		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
