package br.com.psg.produto.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.psg.produto.dao.ProdutoDAO;
import br.com.psg.produto.dao.impl.ProdutoDAOImpl;

@WebServlet("/produto/delete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteController() {
		// Do Nothing
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String prodId = request.getParameter("prodId");

		if (prodId == "" || prodId == null)
			request.getRequestDispatcher("/").forward(request, response);
		else {
			Long id = Long.parseLong(prodId);
			ProdutoDAO produtoDao = ProdutoDAOImpl.getInstance();

			produtoDao.deleteProduto(id);

			response.sendRedirect(request.getContextPath() + "/");
		}
	}
}
