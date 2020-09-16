package br.com.psg.produto.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import br.com.psg.produto.dao.ProdutoDAO;
import br.com.psg.produto.dao.impl.ProdutoDAOImpl;
import br.com.psg.produto.modal.Produto;

@WebServlet("/produto/cadastro")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, // 1MB
		maxFileSize = 1024 * 1024 * 4, // 4MB
		maxRequestSize = 1024 * 1024 * 4 // 4MB
)

public class CadastroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String uploadPath = System.getProperty("user.dir") + "/";

	private ProdutoDAO produtoDao = ProdutoDAOImpl.getInstance();

	public CadastroController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String prodId = request.getParameter("id");
		String nome = request.getParameter("nome");
		String tipo = request.getParameter("tipo");
		double preco = Double.parseDouble(request.getParameter("preco"));
		String vencimento = request.getParameter("vencimento");
		String upload = request.getParameter("upload");

		Produto produto = new Produto(nome, tipo, preco, vencimento);

		PrintWriter out = response.getWriter();

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart) {
			out.println("<h1>Voce não enviou um arquivo!</h1>");
			return;
		}

		try {
			List<FileItem> fileItems = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
			for (FileItem item : fileItems) {
				if(item.getFieldName().equals("upload")) {
					
					String fileName = System.currentTimeMillis() + "_" + item.getName();

					File file = new File(uploadPath + fileName);

					item.write(file);
					produto.setArquivo(fileName);
					
				}
			}

			if (prodId == null || prodId == "")
				produtoDao.saveProduto(produto);
			else {
				Long id = Long.parseLong(prodId);
				produto.setId(id);
				produtoDao.updateProduto(produto);
			}
			
			out.println("<h1>Arquivo gravado!</h1>");

		} catch (Exception e) {
			out.println("<h1>Erro ao escrever no arquivo!</h1>");
			return;
		}

		//response.sendRedirect(request.getContextPath() + "/");
	}

}
